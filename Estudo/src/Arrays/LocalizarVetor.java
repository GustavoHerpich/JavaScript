package Arrays;

public class LocalizarVetor {

    public static boolean localizar(int []array, int valor) {
        for (int x : array) {
            if (x == valor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int listaValores[] = {10, 20, 30, 40};

        if (localizar(listaValores, 40)) {
            System.out.println("Valor encontrado");
        } else {
            System.out.println("Não foi desta vez!");
        }
    }
}
