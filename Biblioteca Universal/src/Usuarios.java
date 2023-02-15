public class Usuarios {

    String nome;
    String email;
    int idade;
    int cpf;
    String categoria;
    String endereco;

    public static int total_usuarios = 0;

    public enum categoria {

        Professor,
        Alunos,
        Funcionarios;

    }

    void altera_categoria(String novo_caregoria) {
        this.categoria = novo_caregoria;
    }

    void modifica_email(String novo_email) {
        this.email = novo_email;
    }

    void modifica_idade(int nova_idade) {
        this.idade = nova_idade;
    }

    void modifica_endereco(String novo_endereco) {
        this.endereco = novo_endereco;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", categoria='" + categoria + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';


    }
}

