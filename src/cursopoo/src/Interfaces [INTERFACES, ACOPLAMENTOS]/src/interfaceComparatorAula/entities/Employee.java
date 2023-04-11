package src.interfaceComparatorAula.entities;

public class Employee implements  Comparable<Employee>{

    private final String name;
    private final String lastname;
    private final Double salary;

    public Employee(String name, String lastname, Double salary) {
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }
}
