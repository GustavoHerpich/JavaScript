import java.util.Objects;

public class Circulo extends FormaBidimensional {

    private double raio;

    public Circulo(double area, double raio) {
        super(area);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circulo circulo = (Circulo) o;
        return Double.compare(circulo.raio, raio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),this.raio);
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "raio=" + raio +
                '}';
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }
}
