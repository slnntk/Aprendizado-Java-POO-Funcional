package rascunhos.kaique.src;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Empresa empresa = new Empresa();
        Estoque estoque = new Estoque();
        empresa.setEstoque(estoque);
        empresa.setSistema(new Sistema(sc, empresa));
        empresa.setNome("Teste");

    }
}

class Funcionario{

    private String nome;
    private Long id;
    private Empresa empresa;

    public Funcionario(String nome, Long id, Empresa empresa) {
        this.nome = nome;
        this.id = id;
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

class Empresa {

    private String nome;
    private Set<Funcionario> funcionarios = new HashSet<>();
    private Sistema sistema;

    private Estoque estoque;

    public Empresa() {
    }

    public Empresa(String nome, Sistema sistema, Estoque estoque) {
        this.nome = nome;
        this.sistema = sistema;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}

class Estoque{

    private Set<Produto> produtos = new HashSet<>();

    public Estoque() {
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void addProducts(Produto p, String name){
        for (Produto produtoLista : produtos){
            if (Objects.equals(produtoLista.getNome(), name)){
                produtoLista.setQuantidade(produtoLista.getQuantidade()+produtoLista.getQuantidade());
                System.out.println("Esse produto teve a quantiade atualizada");
                return;
            }
        }
        produtos.add(p);
        System.out.println("Esse produto foi adicionado");
    }

    public void removeProducts(String name){
        for (Produto produtoLista : produtos){
            if (Objects.equals(produtoLista.getNome(), name)){
                produtos.remove(produtoLista);
                System.out.println("Esse produto foi removido");
                return;
            }
        }
        System.out.println("Esse produto não existe");
    }

    public void removeByQuantidade(String name, int quantidade){
        for (Produto produtoLista : produtos){
            if (Objects.equals(produtoLista.getNome(), name)){
                int temp = produtoLista.getQuantidade() - quantidade;
                if (temp <= 0){
                    produtoLista.setQuantidade(0);
                }
                else{
                    produtoLista.setQuantidade(produtoLista.getQuantidade() - quantidade);
                }
                System.out.println("Esse produto teve a quantidade alterada, houve retirada !");
                return;
            }
        }
        System.out.println("Esse produto não existe");
    }

    public void addByQuantidade(String name, int quantidade){
        for (Produto produtoLista : produtos){
            if (Objects.equals(produtoLista.getNome(), name)){
                int temp = produtoLista.getQuantidade() + quantidade;
                if (quantidade <= 0){
                    return;
                }
                else{
                    produtoLista.setQuantidade(produtoLista.getQuantidade() + quantidade);
                }
                System.out.println("Esse produto teve a quantidade alterada, foi adicionado !");
                return;
            }
        }
        System.out.println("Esse produto não existe");
    }
}

class Produto{

    private String nome;
    private Double preco;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

class Sistema implements SistemaInterface{

    private Empresa empresa;

    public Sistema(Scanner sc, Empresa empresa) {
        this.empresa = empresa;
        int i = 10;
        do{
            System.out.println("-------------------------------------");
            System.out.println("Digite 1 para adicionar um produto: ");
            System.out.println("Digite 2 para remover um produto: ");
            System.out.println("Digite 3 para reduzir quantidade de um produto: ");
            System.out.println("Digite 4 para adicionar quantidade de um produto: ");
            System.out.println("Digite 6 para finalizar o programa: ");
            System.out.println("-------------------------------------");

            i = sc.nextInt();
            funcoesSistema(i, sc);
            empresa.getEstoque().getProdutos().forEach(System.out::println);
        }while (i != 6);

    }

    private void funcoesSistema(int numero, Scanner sc){
        switch (numero) {
            case 1:
                System.out.println("Digite o produto a ser adicionado: ");
                System.out.print("Nome: ");
                String nome = sc.next();
                System.out.print("Preço: ");
                Double preco = sc.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = sc.nextInt();
                empresa.getEstoque().addProducts(new Produto(nome, preco, quantidade), nome);
                break;
            case 2:
                System.out.println("Digite o nome do produto a ser removido:");
                System.out.print("Nome: ");
                nome = sc.next();
                empresa.getEstoque().removeProducts(nome);
                break;
            case 3:
                System.out.println("Digite o nome do produto e a quantidade a ser removida:");
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Quantidade: ");
                quantidade = sc.nextInt();
                empresa.getEstoque().removeByQuantidade(nome, quantidade);
                break;
            case 4:
                System.out.println("Digite o nome do produto e a quantidade a ser adicionado:");
                System.out.print("Nome: ");
                nome = sc.next();
                System.out.print("Quantidade: ");
                quantidade = sc.nextInt();
                empresa.getEstoque().addByQuantidade(nome, quantidade);
                break;
            case 5:
                System.out.println("Número 5");
                break;
            case 6:
                System.out.println("Número 6");
                break;
            default:
                System.out.println("Número inválido");
        }
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public void insert(Produto produto) {
        empresa.getEstoque().addProducts(produto, produto.getNome());
    }

    @Override
    public void delete(Produto produto) {
        empresa.getEstoque().removeProducts(produto.getNome());
    }

    @Override
    public void removeByQuantidade(Produto produto, int quantidade) {
        empresa.getEstoque().removeByQuantidade(produto.getNome(), quantidade);
    }

    @Override
    public void addByQuantidade(Produto produto, int quantidade) {
        empresa.getEstoque().removeByQuantidade(produto.getNome(), quantidade);
    }

}

interface SistemaInterface{

    void insert(Produto produto);
    void delete(Produto produto);

    void removeByQuantidade(Produto produto, int quantidade);

    void addByQuantidade(Produto produto, int quantidade);

}