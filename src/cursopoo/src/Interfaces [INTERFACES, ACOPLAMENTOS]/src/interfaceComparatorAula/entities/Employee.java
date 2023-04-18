package src.interfaceComparatorAula.entities;

public class Employee{

    private final String name;
    private final Double salary;

    public Employee(String name, String lastname, Double salary) {
        this.name = name + " " + lastname;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }
}
