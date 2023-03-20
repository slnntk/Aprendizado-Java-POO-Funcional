package rascunhos;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Funcionario f1 = new Funcionario(sc.nextLine(), sc.nextDouble(), sc.nextDouble());
        f1.AumentoDeSalario(sc);
    }
}

class Funcionario{

    private String nome;
    private double salario;
    private double tax;

    public Funcionario(String nome, double salario, double tax) {
        setNome(nome);
        setSalario(salario);
        setTax(tax);
        setSalario(salario - tax);
        System.out.printf("Salario liquido do %s, R$: %.2f%n",getNome(), getSalario());
    }

    public void AumentoDeSalario(Scanner sc){
        System.out.println("Quantos % deve ser aumentado do salario?");
        setSalario(((getSalario()+getTax())/sc.nextDouble())+getSalario());
        System.out.printf("Salario Atualizado: %s, R$ %.2f", getNome(), getSalario());
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
