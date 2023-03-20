package rascunhos;

import java.util.Locale;
import java.util.Scanner;

public class Vetor {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new FabricaProdutoos();

    }

}

class FabricaProdutoos{

    public FabricaProdutoos() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Produto[] vetor = new Produto[n];

        for (int i = 0;i < n;i++){
            System.out.print("Nome :");
            String nome = sc.next();
            System.out.print("Preco :");
            double preco = sc.nextDouble();
            vetor[i] = new Produto(nome, preco);
        }

        double soma = 0;
        for (int i = 0;i < n;i++){
            System.out.println(vetor[i].toString());
            soma += vetor[i].getPreco();
        }

        System.out.printf("Media = %.2f",soma/n);

    }
}

class Produto{

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
