import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;

public class Exercicio3 {
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite 3 valores aqui: ");
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());
        int C = Integer.parseInt(bf.readLine());
        int maiorAB = (A + B + abs(A-B))/2;
        int maiorAC = (A + C + abs(A-C))/2;
        int maiorBC = (B + C + abs(B-C))/2;
        if (maiorAB >= maiorAC && maiorAB >= maiorBC) {
            System.out.println(maiorAB + " Eh o maior numero");
        } else if (maiorAC >= maiorAB && maiorAC >= maiorBC) {
            System.out.println(maiorAC + " Eh o maior numero");
        } else {
            System.out.println(maiorBC + " Eh o maior numero");
        }
    }
}
