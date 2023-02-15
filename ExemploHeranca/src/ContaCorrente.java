import java.util.Objects;


public class ContaCorrente extends Conta{
    private int numero_retiradas;

    public ContaCorrente(double saldo, int numero, int numero_retiradas) {
        super(saldo, numero);
        this.numero_retiradas = numero_retiradas;
    }

    public ContaCorrente(int numero, int numero_retiradas) {
        super(numero);
        this.numero_retiradas = numero_retiradas;
    }

    @Override
    public String toString() {
        return "CORRENTE: " + super.toString() +
                " e o meu numero de retiradas é " +
                numero_retiradas;
    }

    @Override
    public void mostra() {
        System.out.println("22222");
    }
}
