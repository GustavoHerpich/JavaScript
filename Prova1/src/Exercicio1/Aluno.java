package Exercicio1;

public class Aluno {
    private String nome, assinatura;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, String assinatura) {
        this.nome = nome;
        this.assinatura = assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " " + assinatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;

        return (getNome().equals(aluno.getNome()));
    }

    @Override
    public int hashCode() {
        return getNome().hashCode();
    }
}
