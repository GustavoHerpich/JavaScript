public class Contador {

    private int contar = 0;

    public void Zerar(int contar) {
        this.contar = 0;
    }

    public void incremento(int contar) {
        this.contar = contar += 1;
    }

    public int getContar() {
        return contar;
    }

    public void setContar(int contar) {
        this.contar = contar;
    }
}
