public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Gustavo", "Herpich", 100);
        Employee emp2 = new Employee("Julia", "Fontanella", 2000);
        System.out.println("R$" + emp1.salario_anual());
        System.out.println("Aumento de 10%");
        System.out.println("R$" + emp1.salario_anual() * 1.1);
    }
}
