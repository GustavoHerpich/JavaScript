import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Investigacao {

        public static void main(String[] args) throws IOException {
            boolean[] listaRespostas = obtemResposta();
            int cont = contadorresposta(listaRespostas);
            analise(cont);
        }

        public static boolean[] obtemResposta() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] perguntas = {"Telefonou para a vítima?",
                    "Esteve no local do crime?",
                    "Mora perto da vítima?",
                    "Devia para a vítima?",
                    "Já trabalhou com a vítima?"};
            boolean[] listaRespostas = new boolean[perguntas.length];
            for (int i = 0; i < perguntas.length; i++) {
                System.out.println(perguntas[i]);
                String resposta = in.readLine();
                listaRespostas[i] = resposta.equals("sim");
            }
            return listaRespostas;
        }

        public static int contadorresposta(boolean[] listaRespostas) {
            int cont = 0;

            for (boolean resposta : listaRespostas) {
                if (resposta) {
                    cont++;
                }
            }
            return cont;
        }

        public static void analise(int cont) {
            if (cont == 2) {
                System.out.println("Suspeita");
            } else if (cont == 3 || cont == 4) {
                System.out.println("Cúmplice");
            } else if (cont == 5) {
                System.out.println("Assasino");
            } else {
                System.out.println("Inocente");
            }
        }

    }
