import java.util.Objects;

public class Conta {
    protected int numero;
    protected double saldo;

    public Conta(double saldo, int numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public Conta(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void mostra() {
        System.out.println("1111");
    }

    @Override
    public String toString() {
        return "Meu saldo é " + saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return conta.numero == numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(saldo);
    }
}
