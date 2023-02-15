import java.util.Objects;

public class Quadrado extends FormaBidimensional {

    private double lado;

    public Quadrado(double area, double lado) {
        super(area);
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
        Quadrado quadrado = (Quadrado) o;
        return Double.compare(quadrado.lado, lado) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lado);
    }


    @Override
    public double calcularArea() {
        return Math.pow(this.lado, 2);
    }

    @Override
    public String toString() {
        return "Quadrado{" +
                "lado=" + lado +
                '}';
    }
}

