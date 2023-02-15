import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter_Escala_Termometrica {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final int
                OPCAO_CELCIUS = 1,
                OPCAO_FAHRENHEIT = 2,
                OPCAO_KELVIN = 3;

    public static void main(String[] args) throws IOException {

        menu();

    }
    public static void menu() throws IOException {

        System.out.println("Qual a temperatura atual? ");
        double temperatura_atual = Double.parseDouble(br.readLine());
        System.out.println("1 - Celsius\n2 - Fahrenheit\n3 - Kelvin\nQual escala está a temperatura atual? ");
        int tipo_primario = Integer.parseInt(br.readLine());
        System.out.println("1 - Celsius\n2 - Fahrenheit\n3 - Kelvin\nEscolha o tipo de conversão:");
        int tipo_final = Integer.parseInt(br.readLine());

        if (tipo_primario == 1 && tipo_final == 2) {
            System.out.println(Celsius_para_Fahrenheit(temperatura_atual));

        } else if (tipo_primario == 1 && tipo_final == 3) {
            System.out.println(Celsius_para_Kelvin(temperatura_atual));
        } else if (tipo_primario == 2 && tipo_final == 1) {
            System.out.println(Fahrenheit_para_Celsius(temperatura_atual));
        } else if (tipo_primario == 2 && tipo_final == 3) {
            System.out.println(Fahrenheit_para_Kelvin(temperatura_atual));
        } else if (tipo_primario == 3 && tipo_final == 1) {
            System.out.println(Kelvin_para_Celsius(temperatura_atual));
        } else if (tipo_primario == 3 && tipo_final == 2) {
            System.out.println(Kelvin_para_Fahrenheit(temperatura_atual));
        }

    }

    public static double Celsius_para_Fahrenheit(double temperatura) {
        return ((temperatura * 9/5) + 32);

    }
    public static double Celsius_para_Kelvin(double temperatura) {
        return ((temperatura) + 273);
    }
    public static double Fahrenheit_para_Celsius(double temperatura) {
        return (((temperatura - 32) * 5/9));
    }
    public static double Fahrenheit_para_Kelvin(double temperatura) {
        return (((temperatura - 32) * 5/9 + 273));
    }
    public static double Kelvin_para_Celsius(double temperatura) {
        return (temperatura - 273);
    }
    public static double Kelvin_para_Fahrenheit(double temperatura) {
        return (((temperatura - 273) * 9/5 + 32));
    }

}
