
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banco_Informatics {

    public static boolean primeira_escolha = true;
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final int
            OPCAO_SAQUE = 1,
            OPCAO_DEPOSITO = 2,
            OPCAO_VERIFICA_SALDO = 3,
            OPCAO_CADASTRO = 4,
            OPCAO_ALTERAR_DADOS = 5;

    public static void main(String[] args) throws IOException {

        while (true) {
            menu();

        }
    }
    public static void saque() throws IOException {

        while (true) {
            System.out.print("- Premium(1)\n- Executiva(2)\n- Padrao(3)\nConta: ");
            int conta = Integer.parseInt(br.readLine());
            System.out.print("Digite o valor que queira sacar:\nR$ ");
            double dinheiro = Double.parseDouble(br.readLine());
            if (conta == 3) {
                if (dinheiro <= 1000) {
                    System.out.println("O valor de: " + dinheiro + " sacado com sucesso!");
                    return;
                } else if (dinheiro > 1000) {
                    System.out.println("A sua conta nao permite sacar essa quantia de dinheiro, coloque um " +
                            "valor valido");
                }
            }

            if (conta == 2) {
                if (dinheiro <= 2500) {
                    System.out.println("O valor de: " + dinheiro + " sacado com sucesso!");
                    return;
                } else if (dinheiro > 2500) {
                    System.out.println("A sua conta nao permite sacar essa quantia de dinheiro, coloque um" +
                            " valor valido");
                }
            }

            if (conta == 1) {
                System.out.println("O valor de: " + dinheiro + " sacado com sucesso!");
                return;
            }
            else {
                System.out.println("Digite um numero de conta valido");
            }
        }
    }
    public static void deposito() throws IOException {

        System.out.println("Digite um valor que queira depositar:");
        double banco = Double.parseDouble(br.readLine());
        System.out.println("Dinheiro depositado na sua conta, no valor de: " + banco);

    }
    public static void cadastro() throws IOException {
        System.out.println("Digite seu nome: ");
        String nome_cliente = br.readLine();
        int numero_da_conta = numero_conta(1, 10);
        System.out.println("O numero da sua conta eh: " + numero_da_conta);
    }
    public static int numero_conta(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void alterar_cadastro() throws IOException {

        while (true) {
            System.out.println("Se deseja alterar o nome digite (1), para mudar o tipo de conta digite (2) ou digite (0) " +
                    "para volta ao menu");
            int opcao = Integer.parseInt(br.readLine());
            if (opcao == 1) {
                System.out.println("Alterar nome do cliente para: ");
                String alterar = br.readLine();
                System.out.println("Nome alterado para: " + alterar);
            } else if (opcao == 2) {
                System.out.println("- Premium(1)\n- Executiva(2)\n- Padrao(3)\nAlterar tipo de conta para: ");
                int alterar_conta = Integer.parseInt(br.readLine());
                if ((alterar_conta == 1) || (alterar_conta == 2) || (alterar_conta == 3)) {
                    System.out.println("Conta alterada para: " + alterar_conta);
                }
                else {
                    System.out.println("Digite um valor de conta valido!");
                }
            } else if (opcao == 0) {
                return;

            } else {
                System.out.println("Digite um comando valido!");
            }
        }
    }
    public static void verifica_saldo() throws IOException {

        System.out.println("Digite o nome do cliente que queira verificar: ");
        String nome_cliente = br.readLine();
        System.out.println("Cliente: " + nome_cliente + "\nNumero da conta: " + numero_conta(1, 10) + "\nSaldo: R$" + numero_conta(1,1000000000));
    }
    public static void menu() throws IOException {

        System.out.println("MENU PRINCIPAL:\n- SACAR DINHEIRO (1)\n- DEPOSITAR QUANTIA (2)\n- VERIFICAR SALDO (3)\n" +
                "- CADASTRAR CLIENTE (4)\n- ALTERAR CADASTRO (5)\nDigite o comando que queira executar: ");

        int comando = Integer.parseInt(br.readLine());

        if (comando == 1 && primeira_escolha == false) {
            saque();

        } else if (comando == 2 && primeira_escolha == false) {
            deposito();

        } else if (comando == 3 && primeira_escolha == false) {
            verifica_saldo();

        } else if (comando == 4) {
            primeira_escolha = false;
            cadastro();

        } else if (comando == 5 && primeira_escolha == false) {
            alterar_cadastro();

        } else if (comando != 4 && primeira_escolha == true) {
            System.out.println("Primeiro precisa cadastrar um cliente para continuar o programa!");

        }

    }

}

