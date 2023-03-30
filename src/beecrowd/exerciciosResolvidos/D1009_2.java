package beecrowd.exerciciosResolvidos;


import java.util.Locale;
import java.util.Scanner;

public class D1009_2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        new Contabilidade(sc);
    }
}

class Contabilidade{

    private Vendedor vendedor;

    public Contabilidade(Scanner sc) {
        this.vendedor = new Vendedor(sc.next(), sc.nextDouble(),sc);
        System.out.printf("TOTAL = R$ %.2f%n", (double) arrecadacaoTotal());
    }

    public double arrecadacaoTotal(){
        return vendedor.getVendas().totalVendas() + vendedor.getSalary();
    }

}

class Vendedor{

    private String name;
    private double salary;
    private Vendas vendas;

    public Vendedor(String name, double salary, Scanner sc) {
        this.name = name;
        this.salary = salary;
        this.vendas = new Vendas(sc.nextDouble());
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Vendas getVendas() {
        return vendas;
    }

}

class Vendas{

    private double vendasMontante;
    private final double comissao = 0.15;

    public Vendas(double vendasMontante) {
        this.vendasMontante = vendasMontante;
    }

    public double totalVendas(){
        return vendasMontante *= comissao;
    }

    public double getVendasMontante() {
        return vendasMontante;
    }

    public double getComissao() {
        return comissao;
    }
}