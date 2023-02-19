package nutricionista.utils;

import java.io.*;

public class Erro {
    public static void escrever_Erro(Exception erro) {

        try {

            OutputStream os = new FileOutputStream("Erros.txt");
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            br.write(erro.toString());
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
