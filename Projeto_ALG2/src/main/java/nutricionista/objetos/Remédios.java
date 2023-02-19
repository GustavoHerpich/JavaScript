package nutricionista.objetos;

import java.util.Objects;

public class Remédios {

    int id;
    String prescricao;
    double dose_diaria;
    double tempo_total;
    String dia_semana;
    String intervalos;

    public Remédios(String prescricao, double dose_diaria, double tempo_total, String dia_semana, String intervalos) {
        this.prescricao = prescricao;
        this.dose_diaria = dose_diaria;
        this.tempo_total = tempo_total;
        this.dia_semana = dia_semana;
        this.intervalos = intervalos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public double getDose_diaria() {
        return dose_diaria;
    }

    public void setDose_diaria(double dose_diaria) {
        this.dose_diaria = dose_diaria;
    }

    public double getTempo_total() {
        return tempo_total;
    }

    public void setTempo_total(double tempo_total) {
        this.tempo_total = tempo_total;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(String intervalos) {
        this.intervalos = intervalos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remédios remédios = (Remédios) o;
        return id == remédios.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return prescricao;
    }
}
