import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Jogador {

    private int id;
    private String nome;
    private String apelido;
    private java.util.Date dataNascimento;
    private int numero;
    private String posicao;
    private int qualidade;
    private int cartoesA, cartoesV;
    private Boolean suspenso;


    public Jogador(int id, String nome, String apelido, java.util.Date dataNascimento, int numero,
                   String posicao, int qualidade, int cartoesA, int cartoesV) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoesA = cartoesA;
        this.cartoesV = cartoesV;
        getSuspenso();
        aplicarCartao(cartoesA, false);
        aplicarCartao(cartoesV, false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }

    public int getCartoes() {
        return cartoesA + cartoesV;
    }

    public Boolean getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(Boolean suspenso) {
        this.suspenso = suspenso;
    }
    public void aplicarCartao(int quantidade_cartoes, boolean ehVermelho) {
        if (ehVermelho)
            cartoesV += quantidade_cartoes;
        else
            cartoesA += quantidade_cartoes;
        if (cartoesV == 1 || cartoesA >= 5) {
            suspenso = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return numero == jogador.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", numero=" + numero +
                ", posicao='" + posicao + '\'' +
                ", qualidade=" + qualidade +
                ", cartoesA=" + cartoesA +
                ", cartoesV=" + cartoesV +
                ", suspenso=" + suspenso +
                '}';
    }

}
