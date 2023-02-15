import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fastfood_NotFasting {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        menu();

    }
    public static void Mostrar_cardapio() {

        System.out.println("1 - Hambúrguer (tradicional, vegano ou duplo)\n" +
                "2 - Poke (salmao, atum ou vegetais)\n" +
                "3 - Sanduiche (mortadela, copa ou parma)\n" +
                "4 - Pizza (margherita, calabresa ou doce)\n" +
                "5 - Frango frito (apimentado ou normal)\n" +
                "6 - Tacos (carne seca ou file).");
    }
    public static void Mostrar_lanches() {

        System.out.println("1 - Hamburguer\n" +
                "2 - Poke\n" +
                "3 - Sanduiche\n" +
                "4 - Pizza\n" +
                "5 - Frango frito\n" +
                "6 - Tacos");
    }
    public static void Hamburguer() {

        System.out.println("1- Tradicional = R$20,0\n" +
                "2 - Vegano = R$15,00\n" +
                "3 - Duplo = R$30,00");
    }
    public static void Poke() {

        System.out.println("1- Vegetais = R$15,0\n" +
                "2 - Atum = R$20,00\n" +
                "3 - Salmao = R$35,00");
    }
    public static void Sanduiche() {

        System.out.println("1-  Mortadela = R$10,0\n" +
                "2 - Parma = R$15,00\n" +
                "3 - Copa = R$20,00");
    }
    public static void Pizza() {

        System.out.println("1- Margherita = R$20,0\n" +
                "2 - Calabresa = R$20,00\n" +
                "3 - Doce = R$25,00");
    }
    public static void Frango_frito() {

        System.out.println("1- Apimentado = R$20,0\n" +
                "2 - Normal = R$15,00\n");
    }
    public static void Tacos() {

        System.out.println("1- File = R$30,00\n" +
                "2 - Carne seca = R$15,00\n");
    }
    public static void menu() throws IOException {

        System.out.println("-------------------" +
                "Bem vindo ao Notfasting!" +
                "-------------------");
        Mostrar_cardapio();
        System.out.println("\nQuantos lanches deseja? ");
        int total_pedidos = Integer.parseInt(br.readLine());
        double total_valor_pedido = 0.00;

        for (int i = 0; i < total_pedidos; i++) {
            Mostrar_lanches();
            System.out.println("Qual lache deseja? ");
            int escolha_lache = Integer.parseInt(br.readLine());
            int escolha_numero_lanche;

            switch (escolha_lache) {
                case 1:
                    Hamburguer();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 20.00;
                    } else if (escolha_numero_lanche == 2) {
                        total_valor_pedido += 15.00;
                    } else {
                        total_valor_pedido += 30.00;
                    }
                    break;

                case 2:
                    Poke();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 15.00;
                    } else if (escolha_numero_lanche == 2) {
                        total_valor_pedido += 20.00;
                    } else {
                        total_valor_pedido += 35.00;
                    }
                    break;

                case 3:
                    Sanduiche();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 10.00;
                    } else if (escolha_numero_lanche == 2) {
                        total_valor_pedido += 15.00;
                    } else {
                        total_valor_pedido += 20.00;
                    }
                    break;

                case 4:
                    Pizza();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 20.00;
                    } else if (escolha_numero_lanche == 2) {
                        total_valor_pedido += 20.00;
                    } else {
                        total_valor_pedido += 25.00;
                    }
                    break;

                case 5:
                    Frango_frito();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 20.00;
                    } else {
                        total_valor_pedido += 15.00;
                    }
                    break;

                case 6:
                    Tacos();
                    System.out.println("Escolha o numero do lache: ");
                    escolha_numero_lanche = Integer.parseInt(br.readLine());

                    if (escolha_numero_lanche == 1) {
                        total_valor_pedido += 30.00;
                    } else {
                        total_valor_pedido += 15.00;
                    }
                    break;

            }

        }

        System.out.println("O valor total da sua compra deu = R$" + total_valor_pedido);

    }

}


