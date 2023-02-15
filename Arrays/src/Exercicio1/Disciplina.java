package Exercicio1;
public class Disciplina {

    private String nome;
    private Professor professor;
    private double cargaHorario;
    private Disciplina requisito;

    public Disciplina(String nome, Professor professor, double cargaHorario, Disciplina requisito) {
        this.nome = nome;
        this.professor = professor;
        this.cargaHorario = cargaHorario;
        this.requisito = requisito;
    }

    public Disciplina(String nome, Professor professor, double cargaHorario) {
        this.nome = nome;
        this.professor = professor;
        this.cargaHorario = cargaHorario;
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

    public double getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(double cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public Disciplina getRequisito() {
        return requisito;
    }

    public void setRequisito(Disciplina requisito) {
        this.requisito = requisito;
    }

}
