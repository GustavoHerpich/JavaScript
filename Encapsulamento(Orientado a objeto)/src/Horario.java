public class Horario {

    private int segundo;
    private int minuto;
    private int hora;


    public void exibir() {
        System.out.println(hora + ':' + minuto + ':' + segundo);
    }

    public int CaclularSegundos() {
        return ((hora * 3600) + (minuto * 60) + (segundo));
    }
}
