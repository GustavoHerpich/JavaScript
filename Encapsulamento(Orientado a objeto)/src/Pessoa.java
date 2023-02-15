import java.util.Objects;

public class Pessoa {

    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public boolean irmaos(Pessoa p) {
        return p.pai.equals(this.pai) && p.mae.equals(this.mae);
    }

    public boolean igualdade_semantica(Pessoa p) {
        return p.nome.equals(this.nome) && p.mae.equals(this.mae);
    }

    public boolean antecessor(Pessoa p) {
        return p.equals(this.pai)
                || p.equals(this.mae)
                || this.pai.pai.equals(p)
                || this.pai.mae.equals(p)
                || this.mae.mae.equals(p)
                || this.mae.pai.equals(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return nome.equals(pessoa.nome) && mae.equals(pessoa.mae);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, mae);
    }

}