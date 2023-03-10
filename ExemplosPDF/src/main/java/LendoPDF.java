
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class LendoPDF {
    public static void main(String[] args) {
        try {
            //Read file using PdfReader
            PdfReader pdfReader = new PdfReader("HelloWorld.pdf");

            //Modify file using PdfReader
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(
                    "HelloWorld-modified.pdf"));

            Image image = Image.getInstance("imagem.png");
            image.scaleAbsolute(100, 50);
            image.setAbsolutePosition(100f, 700f);

            PdfReaderContentParser parser = new PdfReaderContentParser(pdfReader);
            TextExtractionStrategy strategy;

            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                System.out.println(strategy.getResultantText());

                PdfContentByte content = pdfStamper.getUnderContent(i);
                content.addImage(image);
            }
            pdfStamper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
