import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessingGaming {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        gerar_numero();

    }
    public static int Numero_aleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void gerar_numero() throws IOException {

        System.out.println("Digite o numero de entrada: ");
        int numero_inicial = Integer.parseInt(br.readLine());
        System.out.println("Digite o numero de saida: ");
        int numero_final = Integer.parseInt(br.readLine());
        int numero_gerado = Numero_aleatorio(numero_inicial, numero_final);
        int pontos = 20;

        for(int i = 1; i <= 20; i++) {

            System.out.println("Tentativa: " + i + " Digite um numero: ");
            int numero_digitado = Integer.parseInt(br.readLine());

            if (numero_digitado == numero_gerado) {
                System.out.println("Voce acertou o numero");
                break;
            } else {
                System.out.println("Este nao é o numero certo, tente novamente");
                pontos -= 1;
            }
        }
        System.out.println("Total de pontos = " + pontos);
        System.out.println(numero_gerado);
    }
}


