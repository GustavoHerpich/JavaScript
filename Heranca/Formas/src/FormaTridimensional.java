import java.util.Objects;

public abstract class FormaTridimensional extends Forma {

    public FormaTridimensional() {
        super();
    }

    public FormaTridimensional(double area, double volume) {
    }

    @Override
    public String toString() {
        return "FormaTridimensional{" +
                "volume=" + calcularVolume() +
                super.toString() + '}';
    }

    public abstract double calcularVolume();
}


