package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1094 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int nCasos = sc.nextInt();
        for (int i = 0;i < nCasos;i++){
            int quantidade = sc.nextInt();
            String nome = String.valueOf(sc.nextLine().toUpperCase().charAt(1));
            if (nome.equals("C")){
                new Coelho(quantidade);
            }
            if (nome.equals("R")){
                new Ratos(quantidade);
            }
            if (nome.equals("S")){
                new Sapos(quantidade);
            }
        }
        Animal a = new Animal(0);
        Coelho c = new Coelho(0);
        Ratos r = new Ratos(0);
        Sapos s = new Sapos(0);
        Relatorio rl = new Relatorio(a, c, r , s);
    }
}

class Relatorio{

    public Relatorio(Animal a, Coelho c, Ratos r, Sapos s) {
        System.out.printf("Total: %d cobaias%n" +
                        "Total de coelhos: %d%n" +
                        "Total de ratos: %d%n" +
                        "Total de sapos: %d%n" +
                        "Percentual de coelhos: %.2f %%%n" +
                        "Percentual de ratos: %.2f %%%n" +
                        "Percentual de sapos: %.2f %%%n", a.getQuantidade(), c.getQtdcolehos(), r.getQtdRatos(), s.getQtdSapos(),
                (float) c.getQtdcolehos() / a.getQuantidade() *  100,
                (float) r.getQtdRatos() / a.getQuantidade()*100,
                (float) s.getQtdSapos() / a.getQuantidade()*100);
    }
}

class Animal{

    private static int quantidade;

    public Animal(int quantidade) {
        setQuantidade(quantidade + getQuantidade());
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

class Coelho extends Animal{

    private static int qtdcolehos;

    public Coelho(int quantidade) {
        super(quantidade);
        setQtdcolehos(getQtdcolehos() + quantidade);
    }

    public int getQtdcolehos() {
        return qtdcolehos;
    }

    public void setQtdcolehos(int qtdcolehos) {
        this.qtdcolehos = qtdcolehos;
    }
}

class Sapos extends Animal{

    private static int qtdSapos;
    public Sapos(int quantidade) {
        super(quantidade);
        setQtdSapos(getQtdSapos() + quantidade);
    }

    public int getQtdSapos() {
        return qtdSapos;
    }

    public void setQtdSapos(int qtdSapos) {
        this.qtdSapos = qtdSapos;
    }
}

class Ratos extends Animal{

    private static int qtdRatos;

    public Ratos(int quantidade) {
        super(quantidade);
        setQtdRatos(getQtdRatos() + quantidade);
    }

    public int getQtdRatos() {
        return qtdRatos;
    }

    public void setQtdRatos(int qtdRatos) {
        this.qtdRatos = qtdRatos;
    }
}