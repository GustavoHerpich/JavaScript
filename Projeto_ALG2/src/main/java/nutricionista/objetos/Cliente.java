package nutricionista.objetos;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    int id;
    String nome;
    String sexo;
    Integer idade;
    String email;
    String celular;
    String endereco;
    ArrayList<Alimentação> alimentação;
    ArrayList<Remédios> remédios;
    ArrayList<nutricionista.objetos.Restrição> restriçãos;

    public Cliente(String nome, String sexo, Integer idade, String email, String celular, String endereco, ArrayList<Alimentação> alimentação, ArrayList<nutricionista.objetos.Remédios> remédios, ArrayList<nutricionista.objetos.Restrição> restriçãos) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.celular = celular;
        this.endereco = endereco;
        this.alimentação = alimentação;
        this.remédios = remédios;
        this.restriçãos = restriçãos;
    }

    public Cliente(String nome, String sexo, Integer idade, String email, String celular, String endereco, ArrayList<Alimentação> alimentação, ArrayList<nutricionista.objetos.Remédios> remédios) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.celular = celular;
        this.endereco = endereco;
        this.alimentação = alimentação;
        this.remédios = remédios;
    }

    public Cliente(String nome, String sexo, Integer idade, String email, String celular, String endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.email = email;
        this.celular = celular;
        this.endereco = endereco;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Alimentação> getAlimentação() {
        return alimentação;
    }

    public void setAlimentação(ArrayList<Alimentação> alimentação) {
        this.alimentação = alimentação;
    }

    public ArrayList<nutricionista.objetos.Remédios> getRemédios() {
        return remédios;
    }

    public void setRemédios(ArrayList<nutricionista.objetos.Remédios> remédios) {
        this.remédios = remédios;
    }

    public ArrayList<nutricionista.objetos.Restrição> getRestriçãos() {
        return restriçãos;
    }

    public void setRestriçãos(ArrayList<nutricionista.objetos.Restrição> restriçãos) {
        this.restriçãos = restriçãos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "nutricionista.objetos.Cliente{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", celular=" + celular +
                ", endereco='" + endereco + '\'' +
                ", alimentação=" + alimentação +
                ", remédios=" + remédios +
                ", restriçãos=" + restriçãos +
                '}';
    }
}