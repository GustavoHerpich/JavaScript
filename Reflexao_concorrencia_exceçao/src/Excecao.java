public class Excecao {


    public static void main(String[] args) {
        testar();

    }
    public static void divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException(" Nao e possivel dividir por zero");
        }
        int result = a / b;
    }

    public static void testar() {
        try {
            divide(10,0);
        } catch (DivisionByZeroException e) {
            System.out.println("Ocorreu um erro" + e.getMessage());
        }

    }
}
