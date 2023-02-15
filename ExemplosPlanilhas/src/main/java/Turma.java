import java.util.ArrayList;

public class Turma {
    ArrayList<Aluno> lista_aluno;

    public Turma(ArrayList<Aluno> lista_aluno) {
        this.lista_aluno = lista_aluno;
    }

    public ArrayList<Aluno> getLista_aluno() {
        return lista_aluno;
    }

    public void setLista_aluno(ArrayList<Aluno> lista_aluno) {
        this.lista_aluno = lista_aluno;
    }
}
