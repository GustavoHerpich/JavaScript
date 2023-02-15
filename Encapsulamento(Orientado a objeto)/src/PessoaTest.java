public class PessoaTest {
    public static void main(String[] args) {
        Pessoa pai = new Pessoa("Marcos");
        Pessoa mae = new Pessoa("Eliane");
        Pessoa pessoa1 = new Pessoa("Gustavo", pai, mae);

        System.out.println(pessoa1.getMae().getNome());

    }
}
