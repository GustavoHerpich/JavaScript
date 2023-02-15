package Exercicio0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exerc0 {

    private static double[] notas = new double[4];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 4; i++) {
            System.out.println("Informe a " + (i + 1) + " nota:");
            notas[i] = Double.parseDouble(bf.readLine());
        }
        imprimeNotas(notas);
        mediaArray(notas);
    }

    public static void imprimeNotas(double[] notas) {
        for (double nota : notas) {
            System.out.println("As notas do aluno sao " + nota);
        }
    }

    public static void mediaArray(double[] notas) {
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        System.out.println("A media eh de: " + (soma/4));
    }
}

