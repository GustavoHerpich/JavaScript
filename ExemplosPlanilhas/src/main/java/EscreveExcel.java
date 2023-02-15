import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EscreveExcel {

    public static void main(String[] args) {
       ArrayList<Aluno> lista_aluno1 = new ArrayList<>();
       ArrayList<Turma> lista_turma = new ArrayList<>();

        lista_aluno1.add(new Aluno("Gustavo", 6, 8, 9));
        lista_aluno1.add(new Aluno("Joao", 7, 9, 2));
        lista_aluno1.add(new Aluno("Pedro", 2, 5, 10));
        ;
        lista_turma.add(new Turma(lista_aluno1));
        lista_turma.add(new Turma(lista_aluno1));
        int cont = 1;
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        for(Turma turma: lista_turma) {

            XSSFSheet sheet = workbook.createSheet("Turma " + cont);
            Map<String, Object[]> data = new TreeMap<String, Object[]>();
            data.put("1", new Object[]{"NOME", "NOTA 1", "NOTA 2", "NOTA 3", "MEDIA FINAL", "Passou"});
            int i = 2;
            for(Aluno aluno:lista_aluno1) {
                data.put(String.valueOf(i), new Object[]{aluno.nome, aluno.nota1, aluno.nota2, aluno.nota3, aluno.mediaFinal, aluno.passeiOUnao()});
                i++;
            }

            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String)
                        cell.setCellValue((String) obj);
                    else if (obj instanceof Integer)
                        cell.setCellValue((Integer) obj);
                    else if (obj instanceof Double)
                        cell.setCellValue((Double) obj);
                    else if (obj instanceof Boolean)
                        cell.setCellValue((Boolean) obj);
                }
            }
            try {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("arq.xlsx"));
                workbook.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        cont++;
        }
    }

}
