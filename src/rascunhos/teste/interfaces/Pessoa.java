package rascunhos.teste.interfaces;

public abstract class Pessoa implements Comparable<Pessoa>{

    private String name;
    private String email;
    private Double baseSalary;

    public Pessoa(String name, String email, Double baseSalary) {
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "," + email + "," +  String.format("%.2f", baseSalary);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
