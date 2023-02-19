package nutricionista;

import java.io.File;
import java.io.FileOutputStream;

public class Excel {

    public static void escrever(String[] args) {

//        //Blank workbook
//        */
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        //Create a blank sheet
//        XSSFSheet sheet = workbook.createSheet("Turma2");
//        //This data needs to be written (Object[])
//        /*Map<String, Object[]> data = new TreeMap<String, Object[]>();
//        data.put("1", new Object[]{"MATRICULA", "NAME", "IDADE"});
//        int i = 2;
//        for(Aluno aluno:lista_aluno) {
//            data.put(String.valueOf(i), new Object[]{aluno.matricula, aluno.nome, aluno.idade});
//            i++;
//        }
//        //Iterate over data and write to sheet
//        Set<String> keyset = data.keySet();
//        int rownum = 0;
//        for (String key : keyset) {
//            Row row = sheet.createRow(rownum++);
//            Object[] objArr = data.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr) {
//                Cell cell = row.createCell(cellnum++);
//                if (obj instanceof String)
//                    cell.setCellValue((String) obj);
//                else if (obj instanceof Integer)
//                    cell.setCellValue((Integer) obj);
//                else if (obj instanceof Double)
//                    cell.setCellValue((Double) obj);
//            }
//        }
//
//         */
//
//        Row row = sheet.createRow(1);
//        Cell cell = row.createCell(1);
//        cell.setCellValue("abacate");
//        Cell cell2 = row.createCell(2);
//        cell2.setCellValue(45);
//
//        XSSFSheet sheet2 = workbook.createSheet("Turma 1");
//
//        Row row2 = sheet2.createRow(1);
//        Cell cell3 = row2.createCell(1);
//        cell3.setCellValue("ruffle");
//        Cell cell4 = row2.createCell(2);
//        cell4.setCellValue(23);
//
//        try {
//            //Write the workbook in file system
//            FileOutputStream out = new FileOutputStream(new File("arq.xlsx"));
//            workbook.write(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
