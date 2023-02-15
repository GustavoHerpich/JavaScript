import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercicio1 {
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        float N1 = Float.parseFloat(bf.readLine());
        float N2 = Float.parseFloat(bf.readLine());
        float N3 = Float.parseFloat(bf.readLine());
        float media_ponderada = (N1*2 + N2*3 + N3*5)/(2+3+5);
            System.out.println(media_ponderada);
    }
}
