import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Maior {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        System.out.println("Digite o n1: ");
        int n1 = Integer.parseInt(br.readLine());
        System.out.println("Digite o n2: ");
        int n2 = Integer.parseInt(br.readLine());
        int maior = (n1>n2) ?n1:n2;
        System.out.println(maior);
    }
}
