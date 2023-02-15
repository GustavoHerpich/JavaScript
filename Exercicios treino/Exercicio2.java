import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Exercicio2 {
    public static void main(String[]args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat deci = new DecimalFormat("0.00");
        System.out.println("Escreva seu nome aqui: ");
        String nome = bf.readLine();
        System.out.println("Escreva seu salario aqui: ");
        float salario = Float.parseFloat(bf.readLine());
        System.out.println("Escreva (em dinheiro) seu total de vendas: ");
        float total_vendas = Float.parseFloat(bf.readLine());
        double total_mes = salario + total_vendas + (total_vendas*0.15);
            System.out.println("Salario total do " + nome + " é = R$" + deci.format(total_mes));
    }
}
