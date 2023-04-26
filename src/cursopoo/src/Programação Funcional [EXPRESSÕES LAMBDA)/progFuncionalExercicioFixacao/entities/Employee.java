package progFuncionalExercicioFixacao.entities;

public class Employee {

    private String name;
    private String email;
    private Double salary;

    public Employee(String name, String email, Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name+","+email+","+String.format("%.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(employee.getEmail()) : employee.getEmail() != null) return false;
        return getSalary() != null ? getSalary().equals(employee.getSalary()) : employee.getSalary() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getSalary() != null ? getSalary().hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }
}
