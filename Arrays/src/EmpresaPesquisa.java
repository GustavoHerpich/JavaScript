import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmpresaPesquisa {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] votes = {};
        while(true){
            System.out.println("Qual o melhor SO?\n" +
                    "1 - WINDOWS SERVER\n" +
                    "2 - UNIX\n" +
                    "3 - LINUX\n" +
                    "4 - NETWARE\n" +
                    "5 - MAC OS\n" +
                    "6 - OUTRO\n" +
                    "(0 - FIM)");
            int option = Integer.parseInt(br.readLine());
            if(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6){
                votes = addOptionToArray(votes, option);
            } else if (option == 0) {
                break;
            } else{
                System.out.println("OPÇÃO INVÁLIDA...");
            }
        }
        getResults(votes);
    }

    private static void getResults(int[] list){
        double soma1 = 0;
        double soma2 = 0;
        double soma3 = 0;
        double soma4 = 0;
        double soma5 = 0;
        double soma6 = 0;

        for (int i :
                list) {
            switch (i){
                case 1:
                    soma1++;
                    break;
                case 2:
                    soma2++;
                    break;
                case 3:
                    soma3++;
                    break;
                case 4:
                    soma4++;
                    break;
                case 5:
                    soma5++;
                    break;
                case 6:
                    soma6++;
                    break;
            }
        }
        System.out.println("SO                       VOTOS         %\n" +
                "--------------           -----        --\n" +
                "Windows Server            " + soma1 + "        " + soma1/ list.length + "\n" +
                "Unix                      " + soma2 + "        " + soma2/ list.length + "\n" +
                "Linux                     " + soma3 + "        " + soma3/ list.length + "\n" +
                "Netware                   " + soma4 + "        " + soma4/ list.length + "\n" +
                "Mac OS                    " + soma5 + "        " + soma5/ list.length + "\n" +
                "Outro                     " + soma6 + "        " + soma6/ list.length + "\n");
    }

    private static int[] addOptionToArray(int[] list, int option){
        int[] newArray = new int[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newArray[i] = list[i];
        }
        newArray[list.length] = option;
        return newArray;
    }
}
