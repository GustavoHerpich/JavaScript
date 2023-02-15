public class Tetraedo extends FormaTridimensional {

    private double lado;

    public Tetraedo(double area, double volume, double lado) {
        super(area, volume);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(this.lado, 2) * Math.sqrt(3);
    }

    @Override
    public double calcularVolume() {
        return (Math.pow(this.lado, 3) * Math.sqrt(2))/12;
    }

    @Override
    public String toString() {
        return "Tetraedo{" +
                "lado=" + lado +
                '}';
    }
}
