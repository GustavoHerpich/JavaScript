import java.util.Objects;

public class Esfera extends FormaTridimensional {
    private double raio;

    public Esfera(double area, double volume, double raio) {
        super(area, volume);
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
        Esfera esfera = (Esfera) o;
        return Double.compare(esfera.raio, raio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), raio);
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * Math.pow(this.raio, 2);
    }

    @Override
    public double calcularVolume() {
        return (4/3) * Math.PI * Math.pow(this.raio, 2);
    }

    @Override
    public String toString() {
        return "Esfera{" +
                "raio=" + raio +
                '}';
    }
}
