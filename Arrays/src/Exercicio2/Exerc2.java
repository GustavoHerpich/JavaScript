package Exercicio2;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Exerc2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduza a letra: ");
            String caracter = bf.readLine();
            String listaVogais[] = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w",
                    "x", "y", "z"};
            String[] arr = caracter.split("");
            for (String caracterA : arr) {
                for (String caracterB : listaVogais) {
                    if (caracterA.charAt(0) == caracterB.charAt(0)) {
                        System.out.println(caracterA);
                    }
                }

            }

        }
    }
}