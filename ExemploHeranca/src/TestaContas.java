public class TestaContas {
    public static void main(String[] args) {
        Conta x, y;

        x = new ContaCorrente(100,1,0);
        y = new ContaPoupanca(500,2,1.5);

        System.out.println(x);
        System.out.println(y);

        x.mostra();
        y.mostra();
    }
}
