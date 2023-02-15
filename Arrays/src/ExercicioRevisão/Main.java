package ExercicioRevisão;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        ArrayList<Curso> lista_Curso = new ArrayList();

            File f = new File("arquivo.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            else {
                try (FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis)){
                    lista_Curso = (ArrayList<Curso>) ois.readObject();
                    System.out.println("Dados lidos:");
                    System.out.println(lista_Curso.toString());
                } catch (ClassNotFoundException e) {
                    System.out.println("Nao consegui ler o arquivo");
                }
            }

        int opcao;

        do {

            opcao = menu();

            switch (opcao) {
                case 1 -> {
                    Curso adicionaCurso = criaCurso();
                    lista_Curso.add(adicionaCurso);
                }
                case 2 -> System.out.println(lista_Curso);
                case 3 -> {
                    Curso removeCurso = buscaCurso();
                    if (lista_Curso.remove(removeCurso)) {
                        System.out.println("Curso removido");
                    } else {
                        System.out.println("Curso nao encontrado");
                    }
                }
                case 4 -> {
                    Curso atualizaCurso = buscaCurso();
                    int pos = lista_Curso.indexOf(atualizaCurso);
                    if (pos == -1) {
                        System.out.println("Curso nao encontrado");
                    } else {
                        atualizaCurso = lista_Curso.get(pos);
                        System.out.println("Novo cordenador: ");
                        atualizaCurso.setCoordenador(br.readLine());
                        System.out.println("Nova carga horaria: ");
                        atualizaCurso.setCargaHoraria(Integer.parseInt(br.readLine()));
                        lista_Curso.set(pos, atualizaCurso);
                    }
                }
            }
        } while (opcao != 0);

        try (FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lista_Curso);
        }
    }

    private static int menu() throws IOException {
        int opcao;
        System.out.println("----------------------------------");
        System.out.println("SEJA BEM VINDO AO SEU PROPRIO CRIADOR DE CURSOS ONLINE!!");
        System.out.println("----------------------------------");
        System.out.println("1)Criar\n" +
                "2)Visualizar\n" +
                "3)Atualizar\n" +
                "4)Deletar\n" +
                "0)Sair");
        System.out.println("Escolha sua opcao:");
        opcao = Integer.parseInt(br.readLine());
        return opcao;

    }


    private static Curso buscaCurso() throws IOException {
        System.out.println("Qual o nome do seu curso?");
        String cursoRemover = br.readLine();
        Curso curso = new Curso(cursoRemover);
        return curso;
    }

    private static Curso criaCurso() throws IOException {

        System.out.println("Cadastre seu curso: \n");
        System.out.println("Qual o nome do seu curso?");
        String novoCurso = br.readLine();
        System.out.println("Qual o coordenador do seu curso?");
        String novoCoordenador = br.readLine();
        System.out.println("Qual a carga horario do seu curso?");
        int novaCargaHoraria = Integer.parseInt(br.readLine());
        ArrayList<Disciplina> disciplinaNew = criaDisciplina();
        Curso curso = new Curso(novoCurso, novoCoordenador, novaCargaHoraria, disciplinaNew);
        return curso;


    }

    private static ArrayList<Disciplina> criaDisciplina() throws IOException {

        ArrayList<Disciplina> lista_Disciplinas = new ArrayList();
        System.out.println("Quntas disiciplinas quer? ");
        int numeroDisiciplina = Integer.parseInt(br.readLine());
        for (int i = 0; i < numeroDisiciplina; i++) {
            System.out.println("Qual o nome da sua disciplina?");
            String novaDisciplina = br.readLine();
            System.out.println("Qual a carga horario da sua disciplina?");
            int novaCargaHoraria = Integer.parseInt(br.readLine());
            Professor professorNew = criaProfessor();
            ArrayList<Aluno> alunoNew = criaAlunos();
            Disciplina disciplina = new Disciplina(novaDisciplina, novaCargaHoraria, professorNew, alunoNew);
            lista_Disciplinas.add(disciplina);
        }
        return lista_Disciplinas;
    }

    private static Professor criaProfessor() throws IOException {

        System.out.println("Crie um professor para está disciplina\n");
        System.out.println("Qual o nome do seu professor?");
        String novoProfessor = br.readLine();
        System.out.println("Qual o email do professor?");
        String novoEmail = br.readLine();
        System.out.println("Qual o salario do professor?");
        double novoSalario = Double.parseDouble(br.readLine());

        Professor professor = new Professor(novoProfessor, novoEmail, novoSalario);
        return professor;
    }

    private static ArrayList<Aluno> criaAlunos() throws IOException {
        ArrayList<Aluno> alunos = new ArrayList();
        System.out.println("Quantos alunos quer na disciplina?");
        int numeroAlunos = Integer.parseInt(br.readLine());

        for (int i = 0; i < numeroAlunos; i++) {
            System.out.println("Qual o nome do aluno?");
            String novoAluno = br.readLine();
            System.out.println("Qual a matricula do aluno?");
            int novaMatricula = Integer.parseInt(br.readLine());
            System.out.println("Qual o telefone do aluno?");
            int novoTelefone = Integer.parseInt(br.readLine());
            System.out.println("Qual a cidade natal do aluno?");
            String novaCidadeNatal = br.readLine();
            Aluno aluno = new Aluno(novoAluno, novaMatricula, novoTelefone, novaCidadeNatal);
            alunos.add(aluno);
        }
        return alunos;


    }
}
