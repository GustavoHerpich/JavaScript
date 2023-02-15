package Exercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Entrada
Haverá diversos casos de testes.
A primeira linha de cada caso inicia com um inteiros N (1 ≤ N ≤ 50)
representando a quantidade de alunos de sua turma.

As próximas N linhas serão da seguinte forma:
           Nome do aluno   Assinatura Original

A seguir haverá um inteiro M (0 ≤ M ≤ N), representando a
quantidade de alunos que compareceram a uma aula.

M linhas seguem, no seguinte formato:
            Nome do aluno   Assinatura na aula

Todos os alunos possuem apenas o primeiro nome na lista,
nenhum nome se repete e todos os nomes contêm no máximo
20 letras (a-z A-Z).

A entrada termina com N = 0, a qual não deve ser processada.

Saída
Para cada caso, exiba uma única linha, a quantidade de assinaturas falsas encontradas.
*/
public class Exerc1 {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n;

        do {
            n = Integer.parseInt(in.readLine());

            if (n >= 1 && n <= 50) {
                Aluno[] turma = lerAssinaturas(n);
                int m = Integer.parseInt(in.readLine());

                if (m >= 0 && m <= n) {
                    verificaAssinaturas(turma, m);
                }
            }
        } while (n != 0);
    }

    private static void verificaAssinaturas(Aluno[] turma, int m) throws IOException {
        int assinaturasInvalidas = 0;

        for (int i = 0; i < m; i++) {
            Aluno testa = lerAluno(in.readLine());

            if (assinaturaInvalida(turma, testa)) {
                assinaturasInvalidas++;
            }
        }
        System.out.println(assinaturasInvalidas);
    }

    private static boolean assinaturaInvalida(Aluno[] turma, Aluno testa) {
        for (Aluno aluno: turma) {
            if (aluno.equals(testa)
                    && !aluno.getAssinatura().equals(testa.getAssinatura())) {
                return true;
            }
        }
        return false;
    }

    private static Aluno lerAluno(String texto) throws IOException {
        String []dados = texto.split(" ");
        String nome = dados[0];
        String assinatura = dados[1];
        return new Aluno(nome, assinatura);
    }

    private static Aluno[] lerAssinaturas(int n) throws IOException {
        Aluno []turma = new Aluno[n];

        for (int i = 0; i < n; i++) {
            String []dados = in.readLine().split(" ");
            String nome = dados[0];
            String assinatura = dados[1];

            turma[i] = new Aluno(nome, assinatura);
        }
        return turma;
    }
}
