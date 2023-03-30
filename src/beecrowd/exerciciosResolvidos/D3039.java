package beecrowd.exerciciosResolvidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D3039 {
    public static void main(String[] args) {
        new Natal();
    }
}

class RelatorioNatal{

    public RelatorioNatal(int carrinhos, int bonecas) {
        System.out.printf("%d carrinhos%n", carrinhos);
        System.out.printf("%d bonecas%n", bonecas);
    }
}

class Natal{

    private List<Menino> meninoList = new ArrayList<>();
    private List<Menina> meninaList = new ArrayList<>();

    public Natal() {
        Scanner sc = new Scanner(System.in);
        int nCriancas = sc.nextInt();
        separacaoDeBrinquedos(nCriancas, sc);
    }

    public void separacaoDeBrinquedos(int nCriancas, Scanner sc){

        for (int i = 0;i < nCriancas;i++){
            String nome = sc.next();
            char sexo = sc.next().toUpperCase().charAt(0);
            if (sexo == 'M'){
                Menino menino = new Menino(nome);
                meninoList.add(menino);
            }
            else if (sexo == 'F'){
                Menina menina = new Menina(nome);
                meninaList.add(menina);
            }
        }
        new RelatorioNatal(meninoList.size(), meninaList.size());
    }
}


class Menino extends Crianca{

    private Brinquedo brinquedo;
    public Menino(String nome) {
        super(nome, Sexo.MASCUNINO);
        this.brinquedo = Brinquedo.CARRINHO;
    }
}

class Menina extends Crianca{

    private Brinquedo brinquedo;

    public Menina(String nome) {
        super(nome, Sexo.FEMININO);
        this.brinquedo = Brinquedo.BONECA;
    }
}

class Crianca{

    private String nome;
    private Sexo sexo;

    public Crianca(String nome, Sexo sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }
}

enum Sexo{

    MASCUNINO,
    FEMININO;

}

enum Brinquedo{

    CARRINHO,
    BONECA;

}
