package ExercicioRevisão;

import java.io.Serializable;
import java.util.Objects;

public class Aluno implements Serializable {

    String nome;
    int matricula;
    int telefone;
    String cidadeNatal;

    public Aluno(String nome, int matricula, int telefone, String cidadeNatal) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.cidadeNatal = cidadeNatal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getCidadeNatal() {
        return cidadeNatal;
    }

    public void setCidadeNatal(String cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula, telefone, cidadeNatal);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", telefone=" + telefone +
                ", cidadeNatal='" + cidadeNatal + '\'' +
                '}';
    }
}
