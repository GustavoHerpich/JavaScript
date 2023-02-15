package Exercicio1;

public class Professor {

    private String nome;
    private String areaAtuacao;
    private int salaAtendimento;

    public Professor(String nome, String areaAtuacao, int salaAtendimento) {
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        setSalaAtendimento(salaAtendimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public int getSalaAtendimento() {
        return salaAtendimento;
    }

    public void setSalaAtendimento(int salaAtendimento) {
        if (salaAtendimento >= 1 && salaAtendimento <= 400) {
            this.salaAtendimento = salaAtendimento;
        }
    }

}

