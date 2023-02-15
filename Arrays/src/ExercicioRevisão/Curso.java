package ExercicioRevisão;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Curso implements Serializable {

    String nome;
    String coordenador;
    int cargaHoraria;

    ArrayList<Disciplina> disciplinas;

    public Curso(String nome, String coordenador, int cargaHoraria, ArrayList<Disciplina> disciplinas) {
        this.nome = nome;
        this.coordenador = coordenador;
        this.cargaHoraria = cargaHoraria;
        this.disciplinas = disciplinas;
    }

    public Curso(String nome, String coordenador, int cargaHoraria) {
        this.nome = nome;
        this.coordenador = coordenador;
        this.cargaHoraria = cargaHoraria;
        this.disciplinas = new ArrayList();
    }


    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionaDisciplina(Disciplina nova) {
        disciplinas.add(nova);
    }

    public void excluirDisiciplina(Disciplina deletado) {
        disciplinas.remove(deletado);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return nome.equals(curso.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, coordenador, cargaHoraria, disciplinas);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", coordenador='" + coordenador + '\'' +
                ", cargaHoraria=" + cargaHoraria + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
