public class InvoiceTest {

    public static void main(String[] args) {
        Invoice I1 = new Invoice("4T5Y", "Longa e pequena",-1, -15.8);

        Invoice.total_peças += 1;

        System.out.println(I1.getNumero_peca());
        System.out.println(I1.getDescricao_peca());
        System.out.println(I1.getQuant_item());
        System.out.println(I1.getPreco_item());
        System.out.println(I1.getInvoiceAmount());



    }
}
