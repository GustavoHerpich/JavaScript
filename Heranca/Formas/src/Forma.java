import java.util.Objects;

public abstract class Forma {
    public abstract double calcularArea();

    public Forma() {
    }

    @Override
    public String toString() {
        return "Area:" + calcularArea();
    }
}
