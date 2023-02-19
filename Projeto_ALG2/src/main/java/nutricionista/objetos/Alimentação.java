package nutricionista.objetos;

import java.util.Objects;

public class Alimentação {

    int id;
    String descricao;
    String periodo;
    double grama;
    String dia_semana;

    public Alimentação(String descricao, String periodo, double grama, String dia_semana) {
        this.descricao = descricao;
        this.periodo = periodo;
        this.grama = grama;
        this.dia_semana = dia_semana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getGrama() {
        return grama;
    }

    public void setGrama(double grama) {
        this.grama = grama;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alimentação that = (Alimentação) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return descricao;
    }
}
