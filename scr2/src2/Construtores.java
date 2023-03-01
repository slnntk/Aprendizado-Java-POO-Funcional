/*import java.util.Arrays;
import java.util.Scanner;

public class Construtores {
    public static void main(String[] args) {
        new visualizadorProdutos(new cadastroProdutos());

    }

}

class visualizadorProdutos{

    public visualizadorProdutos(cadastroProdutos c) {
        for (int i = 0; i < c.getQtdProdutos(); i++){
            System.out.println(Arrays.toString(c.getP()));
        }
    }
}

class cadastroProdutos{
    Scanner sc = new Scanner(System.in);
    Produto[] p;
    private int qtdProdutos;

    public cadastroProdutos() {
        System.out.println("Numero de produtos: ");
        this.qtdProdutos = sc.nextInt();
        Produto[] p = new Produto[qtdProdutos];
        for (int i = 0;i < qtdProdutos;i++){
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Price: ");
            float preco = sc.nextFloat();
            System.out.print("qtdEstoque: ");
            int estoque = sc.nextInt();
            p[i] = new Produto(nome, preco, estoque);
            setP(p[i]);
        }
    }

    public Produto[] getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = new Produto[]{p};
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
}

class Produto{

    private String nome;
    private float preco;
    private int qtd;

    public Produto(String nome, float preco, int qtd) {
        setNome(nome);
        setPreco(preco);
        setQtd(qtd);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + getNome() + '\'' +
                ", preco=" + getPreco() +
                ", qtd=" + getQtd() +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
 */
