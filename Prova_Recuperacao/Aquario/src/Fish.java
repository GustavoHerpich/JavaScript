import java.util.Objects;

public class Fish {
    private String nome, especie, cor;

    public Fish(String nome, String especie, String cor) {
        this.nome = nome;
        this.especie = especie;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
