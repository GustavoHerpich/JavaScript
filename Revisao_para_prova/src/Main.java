import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        int opcao;
        do {
            opcao = menu();
            if (opcao == 1) {
                cadastra_Fornecedor(listaFornecedor);
            } else if (opcao == 2) {
                Fornecedor x = busca_Fornecedor(listaFornecedor);

                if (x == null) {
                    System.out.println("Nao deu!");
                } else {
                    System.out.println(x);
                }
            }
        } while (opcao != 3);
    }

    public static int menu() throws IOException {
        int opcao;
        System.out.println("Cadastre seu fornecedor:" +
                " 1 - Executar " +
                "2 - Buscar " +
                " 3 - Sair");
        System.out.println("Escolha uma opcao:");
        opcao = Integer.parseInt(br.readLine());
        return opcao;
    }

    public static void cadastra_Fornecedor(ArrayList<Fornecedor> listaFornecedor) throws IOException {


        System.out.println("Qual o nome do fornecedor?");
        String novoNome = br.readLine();
        System.out.println("Qual o endereco do fornecedor?");
        String novoEndereco = br.readLine();
        System.out.println("Qual o Telefone do fornecedor?");
        String novoTelefone = br.readLine();;
        System.out.println("Qual o valor de credito do fornecedor?");
        Double novoValorCred = Double.parseDouble(br.readLine());
        System.out.println("Qual o valor de divida do fornecedor?");
        Double novoValorDev = Double.parseDouble(br.readLine());
        Fornecedor fornecedor = new Fornecedor(novoNome, novoEndereco, novoTelefone, novoValorCred, novoValorDev);
        listaFornecedor.add(fornecedor);

    }

    public static Fornecedor busca_Fornecedor(ArrayList<Fornecedor> fornecedores) throws IOException {
        System.out.println("Qual o nome do fornecedor?");
        String buscaNome = br.readLine();
        for (Fornecedor busca: fornecedores) {
            if (busca.getNome().equals(buscaNome)) return busca;
        } return null;
    }

    public static int busca_Fornecedor_pocicao(ArrayList<Fornecedor> fornecedores) throws IOException {
        System.out.println("Qual o nome do fornecedor?");
        String buscaNome = br.readLine();
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getNome().equals(buscaNome)) return i;
        } return -1;
    }

    public static Boolean atualiza_forncedor(ArrayList<Fornecedor> fornecedores) throws IOException {
        int posicao = busca_Fornecedor_pocicao(fornecedores);


        if (posicao == -1) {
            return false;
        } else {
            System.out.println("Qual o nome do fornecedor?");
            String novoNome = br.readLine();
            System.out.println("Qual o endereco do fornecedor?");
            String novoEndereco = br.readLine();
            System.out.println("Qual o Telefone do fornecedor?");
            String novoTelefone = br.readLine();;
            System.out.println("Qual o valor de credito do fornecedor?");
            Double novoValorCred = Double.parseDouble(br.readLine());
            System.out.println("Qual o valor de divida do fornecedor?");
            Double novoValorDev = Double.parseDouble(br.readLine());
            fornecedores.get(posicao).setNome(novoNome);
            fornecedores.get(posicao).setEndereco(novoEndereco);
            fornecedores.get(posicao).setTelefone(novoTelefone);
            fornecedores.get(posicao).setValorCredito(novoValorCred);
            fornecedores.get(posicao).setValorDivida(novoValorDev);

        }
        return true;
    }

    public static Boolean remove_fornecedor(ArrayList<Fornecedor> fornecedores) throws IOException {
        System.out.println("Qual o nome do fornecedor?");
        String novoNome = br.readLine();
        Fornecedor x = new Fornecedor(novoNome);

        return fornecedores.remove(x);
    }
}
