import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new  Sistema(sc);
        sistema.imprimirPagamentos();
    }
}

class Sistema {

    List<Employee> employeeList = new ArrayList<>();

    public Sistema(Scanner sc) {
        System.out.print("Digite o numero de funcionarios: ");
        int nFuncionarios = sc.nextInt();
        for (int i = 1; i <= nFuncionarios; i++) {
            System.out.printf("Funcionario #%d data:%n", i);
            adicionarFuncionario(sc);
        }
    }

    public void imprimirPagamentos(){

        System.out.println("%nPAYMENTS");

        for (Employee funcionarios : employeeList){
            System.out.printf("%s - $ %.2f%n", funcionarios.getName(), funcionarios.payment());
        }

    }

    public void adicionarFuncionario(Scanner sc) {
        System.out.print("Tercerizado (y/n)? ");char tercerizado = sc.next().charAt(0);
        System.out.print("Name: ");String name = sc.next();
        System.out.print("Hours: ");int hours = sc.nextInt();
        System.out.print("Value per hour: ");double value = sc.nextDouble();
        if (tercerizado == 'y') {
            System.out.print("Additional chance: ");
            double adicional = sc.nextDouble();
            employeeList.add(new OutsorcedEmployee(name, hours, value, adicional));
        } else {
            employeeList.add(new Employee(name, hours, value));
        }
    }

    class OutsorcedEmployee extends Employee {

        private Double additionalCharge;


        public OutsorcedEmployee() {
        }

        public OutsorcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
            super(name, hours, valuePerHour);
            this.additionalCharge = additionalCharge;
        }

        @Override
        public final Double payment() {
            return super.payment() + (additionalCharge * 1.10);
        }

        public Double getAdditionalCharge() {
            return additionalCharge;
        }

        public void setAdditionalCharge(Double additionalCharge) {
            this.additionalCharge = additionalCharge;
        }
    }

    class Employee {

        private String name;
        private Integer hours;
        private Double valuePerHour;

        public Employee() {
        }

        public Employee(String name, Integer hours, Double valuePerHour) {
            this.name = name;
            this.hours = hours;
            this.valuePerHour = valuePerHour;
        }

        public Double payment() {
            return hours * valuePerHour;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getHours() {
            return hours;
        }

        public void setHours(Integer hours) {
            this.hours = hours;
        }

        public Double getValuePerHour() {
            return valuePerHour;
        }

        public void setValuePerHour(Double valuePerHour) {
            this.valuePerHour = valuePerHour;
        }
    }
}