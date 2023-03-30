package beecrowd.exerciciosResolvidos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D1038_2 {

    public static void main(String[] args) {
        new Caixa();
    }
}

class Caixa{

    List<Product> productList = new ArrayList<>(Arrays.asList(
            new Product(1, "Cachorro Quente", 4.00),
            new Product(2, "X-SALADA", 4.50),
            new Product(3, "X-SALADA", 5.00),
            new Product(4,"Torrada Simples",2.00),
            new Product(5, "Refrigerante", 1.50)
    ));

    public Caixa() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Total: R$ %.2f%n", Buy(sc.nextInt(), sc.nextInt()));
    }

    public double Buy(int codigo, int quantidade){
        Lanche lanche = new Lanche(productList.get(codigo-1).getCodigo(), productList.get(codigo-1).getNome(), productList.get(codigo-1).getPreco(), quantidade);
        return lanche.getPreco() * lanche.getQuantidade();
    }

}

class Lanche extends Product{

    private int quantidade;
    public Lanche(int codigo, String nome, Double preco, int quantidade) {
        super(codigo, nome, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}

class Product{

    private int codigo;
    private String nome;
    private Double preco;

    Product(int codigo, String nome, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public Double getPreco() {
        return preco;
    }
}