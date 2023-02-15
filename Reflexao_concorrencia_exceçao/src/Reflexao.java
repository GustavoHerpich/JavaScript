import java.lang.reflect.Field;
public class Reflexao {

    private int teste;

    public static void main(String[] args) {
        teste1();
    }


    public static void teste1() {
        Class<Reflexao> classe = Reflexao.class;


        for (Field atributo : classe.getDeclaredFields()) {
            System.out.println(atributo.getName());
        }

    }
}
