package Exercicio1;

public class Exerc1 {

    public static void main(String[] args) {
        Disciplina[] listaDisciplina = new Disciplina[5];

        Professor prof1 = new Professor("Jef", "Matematica Basica", 23);
        Professor prof2 = new Professor("Gustavo", "Matematica Discreta", 90);
        Professor prof3 = new Professor("Julia", "Algoritmos 1", 103);
        Professor prof4 = new Professor("Ramiro", "Algoritmos 2", 309);
        Professor prof5 = new Professor("Tiago", "Introducao de Hardware", 401);

        Disciplina disci1 = new Disciplina("Matematica Basica", prof1, 120);
        Disciplina disci2 = new Disciplina("Matematica Discreta", prof2, 150, disci1);
        Disciplina disci3 = new Disciplina("Algoritmos 1", prof3, 130);
        Disciplina disci4 = new Disciplina("Algoritmos 2", prof4, 150, disci3);
        Disciplina disci5 = new Disciplina("Introducao de Hardware", prof5, 80);

        listaDisciplina[0] = disci1;
        listaDisciplina[1] = disci2;
        listaDisciplina[2] = disci3;
        listaDisciplina[3] = disci4;
        listaDisciplina[4] = disci5;

        imprimeDisciplina(listaDisciplina);

    }

    public static void imprimeDisciplina(Disciplina[] listaDisciplina) {
        for (Disciplina disciplinas : listaDisciplina) {
            System.out.println("Nome - " + disciplinas.getNome());
            System.out.println("Professor - " + disciplinas.getProfessor().getNome() + '\n');

            if (disciplinas.getRequisito() != null) {
                System.out.println("Requisito - " + disciplinas.getRequisito().getNome() + '\n');
            }
        }
    }

}

