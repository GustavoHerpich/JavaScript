import java.util.Objects;

public class Aluno {
    String nome;
    double nota1;
    double nota2;
    double nota3;
    double notaExame;
    double mediaFinal;


    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.mediaFinal = calculaMediaFinal(nota1, nota2, nota3);
        this.notaExame = notaExame;

    }

    public Double calculaMediaFinal(double nota1, double nota2, double nota3) {
        double media = (nota1 + nota2 + nota3)/3;
        return media;
    }

    public Boolean passeiOUnao() {
        if (this.mediaFinal >= 6) return true;
        return false;
    }

}
