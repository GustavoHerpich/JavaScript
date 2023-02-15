package Arrays;

public class SomaVetor {

    public static int soma(int[] array) {
        int s = 0;

        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        return s;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30};

        System.out.println("Soma: " + soma(array));

    }
}
