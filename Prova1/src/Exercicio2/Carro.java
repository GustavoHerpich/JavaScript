package Exercicio2;

//Cada carro tem um
//modelo, ano de fabricação e placa.
public class Carro {
    private String modelo, placa;
    private int ano;

    public Carro(String placa) {
        setPlaca(placa);
        setModelo("Não identificado");
        setAno(2022);
    }

    public Carro(String placa, int ano, String modelo) {
        setPlaca(placa);
        setAno(ano);
        setModelo(modelo);
    }

    public int getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", ano=" + ano +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;

        Carro carro = (Carro) o;

        return getPlaca().equals(carro.getPlaca());
    }

    @Override
    public int hashCode() {
        return getPlaca().hashCode();
    }
}
