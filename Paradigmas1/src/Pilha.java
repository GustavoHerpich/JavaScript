public class Pilha extends EstruturaDeDados {
    private Object [] dadosEmpilhados = new  Object[100];
    private int tamanhaAtual = 0;
    public void inserir(Object informacao) {
        this.dadosEmpilhados[tamanhaAtual] = informacao;
        this.tamanhaAtual ++;
    }

    public int getTamanhaAtual() {
        return tamanhaAtual;
    }

    public void remover(){
        this.tamanhaAtual = this.tamanhaAtual -1;
    }

    @Override
    public void getTamanhoAtual() {

    }
}
