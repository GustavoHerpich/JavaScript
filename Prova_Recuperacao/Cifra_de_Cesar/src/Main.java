public class Main {

    public static void main(String[] args) {
        Cifra_Cesar cifra = new Cifra_Cesar("A LIGEIRA RAPOSA MARROM SALTOU SOBRE O CACHORRO CANSADO", 3);
        System.out.println(cifra.getTextoCifrado());
    }
}
