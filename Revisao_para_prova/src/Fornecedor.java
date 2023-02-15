public class Fornecedor extends Pessoa implements Apresentacao {
    private Double valorCredito;
    private Double valorDivida;


    public Fornecedor(String nome){
        super(nome);
    }
    public Fornecedor(String nome, Double valorCredito, Double valorDivida) {
        super(nome);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    public Fornecedor(String nome, String endereco, String telefone, Double valorCredito, Double valorDivida) {
        super(nome, endereco, telefone);
        this.valorCredito = valorCredito;
        this.valorDivida = valorDivida;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(Double valorDivida) {
        this.valorDivida = valorDivida;
    }
    public Double obterSaldo() {
        return valorCredito - valorDivida;
    }

    public void apresentar() {
        System.out.println(this.nome + " " + obterSaldo());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "valorCredito=" + valorCredito +
                ", valorDivida=" + valorDivida +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
