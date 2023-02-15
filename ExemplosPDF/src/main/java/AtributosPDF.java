
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AtributosPDF {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    "AtributosPDF.pdf"));
            document.open();
            document.add(new Paragraph("Texto aleatório..."));

            //Set attributes here
            document.addAuthor("Rafael Vieira Coelho");
            document.addCreationDate();
            document.addCreator("IFRS");
            document.addTitle("Exemplo de Atributos");
            document.addSubject("Um exemplo de como definir atributos ao PDF.");

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
