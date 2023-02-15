import java.util.Objects;

public class Triangulo extends FormaBidimensional {
    private double base;
    private double altura;

    public Triangulo(double area, double base, double altura) {
        super(area);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangulo triangulo = (Triangulo) o;
        return Double.compare(triangulo.base, base) == 0 && Double.compare(triangulo.altura, altura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), base, altura);
    }

    @Override
    public double calcularArea() {
        return (this.base * this.altura)/2;
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}
