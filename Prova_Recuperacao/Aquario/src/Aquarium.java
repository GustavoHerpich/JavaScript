import java.util.ArrayList;
import java.util.Objects;

public class Aquarium {
    private Double comprimento, largura, altura;
    private ArrayList<Fish> lista_Peixes;
    private static final int capacidade_inicial = 10;

    public Aquarium(Double comprimento, Double largura, Double altura) {
        if (comprimento <= 0 || largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Dimensões inválidas para um aquário");
        }
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.lista_Peixes = new ArrayList<>(capacidade_inicial);
    }
    public Aquarium() {
        this.comprimento = 500.00;
        this.largura = 100.00;
        this.altura = 200.00;
        this.lista_Peixes = new ArrayList<>(capacidade_inicial);
    }

    public Boolean adiciona_Peixe(Fish fish) {
        if (this.lista_Peixes.size() == capacidade_inicial) {
            return false;
        }
        for (Fish f : this.lista_Peixes) {
            if (f.getNome().equals(fish.getNome())) {
                return false;
            }
        }
        this.lista_Peixes.add(fish);
        return true;
    }
    public Boolean remove_Peixe(String nome) {
        for (Fish fish: this.lista_Peixes) {
            if (fish.getNome().equals(nome)) {
                this.lista_Peixes.remove(fish);
                return true;
            }
        } return false;
    }

    public ArrayList<String> pega_lista_Alimento() {
        ArrayList<String> lista_Alimento = new ArrayList<>();
        for (Fish fish: this.lista_Peixes) {
            String especie = fish.getEspecie();
            if (Objects.equals(especie, "Colisa")) {
                lista_Alimento.add("Pallets");
            } else if (Objects.equals(especie, "Coridora")) {
                lista_Alimento.add("spirulina");
            } else if (Objects.equals(especie, "Kinguio")) {
                lista_Alimento.add("farinha de camarão");
            } else if (Objects.equals(especie, "Molinésia")) {
                lista_Alimento.add("farinha de soja");
            } else if (Objects.equals(especie, "arco-íris")) {
                lista_Alimento.add("farinha de lula");
            } else {
                lista_Alimento.add("pellets");
            }
        }
        return lista_Alimento;
    }
    public Double volume() {
        return (this.comprimento * this.largura * this.altura);
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public ArrayList<Fish> getLista_Peixes() {
        return lista_Peixes;
    }

    public void setLista_Peixes(ArrayList<Fish> lista_Peixes) {
        this.lista_Peixes = lista_Peixes;
    }
}
