public class Persistidor {

    private IEstruturavel estruturaDeDados;
    public Persistidor(IEstruturavel estruturaDeDados) {
        this.estruturaDeDados = estruturaDeDados;
    }

    public void salvar(Object informacao) {
        estruturaDeDados.inserir(informacao);
    }

    public int quantidadeDadosSalvos(){
        return this.estruturaDeDados.getTamanhaAtual();
    }
}
