package rascunhos.teste.entities;

public class User extends Pessoa implements Comparable<Pessoa>{
    public User(String name, String email, Double baseSalary) {
        super(name, email, baseSalary);
    }

    @Override
    public int compareTo(Pessoa o) {
        return 0;
    }
}
