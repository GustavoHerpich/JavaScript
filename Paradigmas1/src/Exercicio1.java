public class Exercicio1 {
    public static void main(String[] args) {
        String informacao;
        String informacao2;
        Persistidor salvador;
        Persistidor persistidor2;

        informacao = "Informação";
        informacao2 = "Informação";

        if (informacao == informacao2) {
            System.out.println("Inf eh igual a inf2");
        }

        //salvador = new Persistidor();

        //persistidor2 = new Persistidor();

        //if (salvador == persistidor2) {
            //System.out.println("Sao iguais");
        //} else {
            //System.out.println("Sao diferentes");
        //}

        String infomacao;
        int infotmacaoInt;
        Persistidor persistidor;

        infomacao = "Informação";
        infotmacaoInt = 2;

        persistidor = new Persistidor(new Fila());

        persistidor.salvar(informacao);
        persistidor.salvar(infotmacaoInt);

        System.out.println(persistidor.quantidadeDadosSalvos());
    }
}
