public class ContadorTest {

    public static void main(String[] args) {
        Contador cont = new Contador();
        cont.incremento(1);
        System.out.println(cont.getContar());
        cont.Zerar(1);
        System.out.println(cont.getContar());
    }
}
