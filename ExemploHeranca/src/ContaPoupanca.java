import java.util.Objects;

public class ContaPoupanca extends Conta {
    private double taxa_rendimento;

    public ContaPoupanca(double saldo, int numero, double taxa) {
        super(saldo, numero);
        this.taxa_rendimento = taxa;
    }

    public double getTaxa_rendimento() {
        return taxa_rendimento;
    }

    public void setTaxa_rendimento(double taxa_rendimento) {
        this.taxa_rendimento = taxa_rendimento;
    }

    @Override
    public String toString() {
        return "POUPANÇA: " +
                super.toString() +
                " e a minha taxa_rendimento é " +
                taxa_rendimento;
    }

}
