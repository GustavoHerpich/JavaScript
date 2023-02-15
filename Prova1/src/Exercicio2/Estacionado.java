package Exercicio2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Precisamos registrar a vaga
//selecionada, a hora de entrada e a hora de saída do
//estacionamento. O valor pago é calculado a partir da
//diferença entre os horários (o valor unitário da hora deve ser
//um atributo também).
public class Estacionado {
    private static final double VALOR_HORA = 3.50;

    private Carro carro;
    private int horaEntrada, horaSaida;
    private double valorPago;
    private String vaga;

    public boolean estaLivre() {
        return carro == null;
    }

    public void liberaVaga() {
        carro = null;
        setValorPago();
        setHoraSaida();
        horaEntrada = 0;
    }

    public Estacionado(Carro carro, String vaga) {
        setCarro(carro);
        setVaga(vaga);
        setHoraEntrada();
    }

    public Estacionado(String vaga) {
        setCarro(null);
        setVaga(vaga);
    }

    public Carro getCarro() {
        return carro;
    }

    public double getValorPago() {
        return valorPago;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public String getVaga() {
        return vaga;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void setHoraEntrada() {
        LocalDateTime now = LocalDateTime.now();
        this.horaEntrada = now.getHour();
    }

    public void setHoraSaida() {
        LocalDateTime now = LocalDateTime.now();
        this.horaSaida = now.getHour();
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public void setValorPago() {
        if (this.horaSaida != 0 && this.horaEntrada != 0) {
            this.valorPago = (this.horaSaida - this.horaEntrada) * VALOR_HORA;
        }
    }

    @Override
    public String toString() {
        return "Estacionado{" +
                "carro=" + carro +
                ", horaEntrada=" + horaEntrada +
                ", horaSaida=" + horaSaida +
                ", valorPago=" + valorPago +
                ", vaga='" + vaga + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estacionado)) return false;

        Estacionado that = (Estacionado) o;

        if (getCarro() != null ? !getCarro().equals(that.getCarro()) : that.getCarro() != null) return false;
        return getVaga() != null ? getVaga().equals(that.getVaga()) : that.getVaga() == null;
    }

    @Override
    public int hashCode() {
        int result = getCarro() != null ? getCarro().hashCode() : 0;
        result = 31 * result + (getVaga() != null ? getVaga().hashCode() : 0);
        return result;
    }
}
