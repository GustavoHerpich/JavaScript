public class Employee {

    private String nome;
    private String sobrenome;
    private double salario_mensal;
    private double salario_anual;

    public Employee(String nome, String sobrenome, double salario_mensal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.setSalario_mensal(salario_mensal);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalario_mensal() {
        return salario_mensal;
    }

    public void setSalario_mensal(double salario_mensal) {
        if (salario_mensal < 0) {
            return;
        }
        this.salario_mensal = salario_mensal;
    }

    public double salario_anual() {
        return (salario_mensal * 12);
    }
}
