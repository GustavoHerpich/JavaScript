public class Invoice {

    private String numero_peca;
    private String descricao_peca;
    private int quant_item;
    private double preco_item;
    public static int total_peças = 0;

    public Invoice(String numero_peca, String descricao_peca, int quant_item, double preco_item) {
        this.numero_peca = numero_peca;
        this.descricao_peca = descricao_peca;
        setQuant_item(quant_item);
        setPreco_item(preco_item);
    }

    public String getNumero_peca() {
        return numero_peca;
    }

    public void setNumero_peca(String numero_peca) {
        this.numero_peca = numero_peca;
    }

    public String getDescricao_peca() {
        return descricao_peca;
    }

    public void setDescricao_peca(String descricao_peca) {
        this.descricao_peca = descricao_peca;
    }

    public int getQuant_item() {
        return quant_item;
    }

    public void setQuant_item(int quant_item) {
        if (quant_item < 0) {
            this.quant_item = 0;
        } else
        this.quant_item = quant_item;
    }

    public double getPreco_item() {
        return preco_item;
    }

    public void setPreco_item(double preco_item) {
        if (preco_item < 0) {
            this.preco_item = 0.0;
        } else
        this.preco_item = preco_item;
    }

    double getInvoiceAmount() {
        double valor_fatura = (quant_item * preco_item);
        return (valor_fatura);
    }


}
