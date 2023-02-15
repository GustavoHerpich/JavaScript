import java.util.Objects;

public class Cubo extends FormaTridimensional {
    private double lado;

    public Cubo(double lado) {
        super();
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cubo cubo = (Cubo) o;
        return Double.compare(cubo.lado, lado) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lado);
    }

    @Override
    public double calcularArea() {
        return 6 * Math.pow(this.lado, 2);
    }

    @Override
    public double calcularVolume() {
        return Math.pow(lado, 3);
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "lado=" + lado +
                super.toString() +
                '}';
    }
}
