package ExercicioRevisão;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Disciplina implements Serializable {

    String nome;
    int cargaHorariaIndividual;
    Professor professor;
    ArrayList<Aluno> aluno;

    public Disciplina(String nome, int cargaHorariaIndividual, Professor professor, ArrayList<Aluno> aluno) {
        this.nome = nome;
        this.cargaHorariaIndividual = cargaHorariaIndividual;
        this.professor = professor;
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCargaHorariaIndividual() {
        return cargaHorariaIndividual;
    }

    public void setCargaHorariaIndividual(int cargaHorariaIndividual) {
        this.cargaHorariaIndividual = cargaHorariaIndividual;
    }

    public ArrayList<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(ArrayList<Aluno> aluno) {
        this.aluno = aluno;
    }

    public void adicionaAluno(Aluno novo) {
        aluno.add(novo);
    }

    public void excluirAluno(Aluno deletado) {
        aluno.remove(deletado);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cargaHorariaIndividual, professor, aluno);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", cargaHorariaIndividual=" + cargaHorariaIndividual +
                ", professor=" + professor +
                ", aluno=" + aluno +
                '}';
    }
}
