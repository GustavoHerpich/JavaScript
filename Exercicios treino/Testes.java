import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Testes {

        public static void main(String[] args) throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                Float N1 = Float.parseFloat(bf.readLine());
                Float N2 = Float.parseFloat(bf.readLine());
                double media_ponderada = (N1*3.5 + N2*7.5)/(11);
                System.out.println("MEDIA = " + String.format("%.5f", media_ponderada));
        }

}