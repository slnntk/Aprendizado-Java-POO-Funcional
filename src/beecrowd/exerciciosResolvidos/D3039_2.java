package beecrowd.exerciciosResolvidos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D3039_2 {
    public static void main(String[] args) throws IOException {
        new Natal_2();
    }
}

class RelatorioNatal_2{

    public RelatorioNatal_2(int carrinhos, int bonecas) {
        System.out.printf("%d carrinhos%n", carrinhos);
        System.out.printf("%d bonecas%n", bonecas);
    }
}

class Natal_2{

    private final List<Menino_2> Menino_2List = new ArrayList<>();
    private final List<Menina_2> Menina_2List = new ArrayList<>();

    public Natal_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nCrianca_2s = Integer.parseInt(br.readLine());
        separacaoDeBrinquedo_2s(nCrianca_2s, br);
    }

    public void separacaoDeBrinquedo_2s(int nCrianca_2s, BufferedReader br) throws IOException {
        String[] Brinquedo_2s = {"carrinho", "boneca"};
        for (int i = 0; i < nCrianca_2s; i++) {
            String[] linha = br.readLine().split(" ");
            String nome = linha[0];
            char sexo = linha[1].toUpperCase().charAt(0);
            if (sexo == 'M'){
                Menino_2 Menino_2 = new Menino_2(nome);
                Menino_2List.add(Menino_2);
            }
            else if (sexo == 'F'){
                Menina_2 Menina_2 = new Menina_2(nome);
                Menina_2List.add(Menina_2);
            }
        }
        new RelatorioNatal_2(Menino_2List.size(), Menina_2List.size());
    }
}


class Menino_2 extends Crianca_2{

    private Brinquedo_2 Brinquedo_2;
    public Menino_2(String nome) {
        super(nome, 'M');
        this.Brinquedo_2 = new Brinquedo_2("carrinho");
    }

    public Brinquedo_2 getBrinquedo_2() {
        return Brinquedo_2;
    }

    public void setBrinquedo_2(Brinquedo_2 Brinquedo_2) {
        this.Brinquedo_2 = Brinquedo_2;
    }
}

class Menina_2 extends Crianca_2{

    private Brinquedo_2 Brinquedo_2;

    public Menina_2(String nome) {
        super(nome, 'F');
        this.Brinquedo_2 = new Brinquedo_2("boneca");
    }

    public Brinquedo_2 getBrinquedo_2() {
        return Brinquedo_2;
    }

    public void setBrinquedo_2(Brinquedo_2 Brinquedo_2) {
        this.Brinquedo_2 = Brinquedo_2;
    }
}

class Crianca_2{

    private String nome;

    public Crianca_2(String nome, char sexo) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Brinquedo_2{

    private String Brinquedo_2;

    public Brinquedo_2(String Brinquedo_2) {
        this.Brinquedo_2 = Brinquedo_2;
    }

    public String getBrinquedo_2() {
        return Brinquedo_2;
    }

    public void setBrinquedo_2(String Brinquedo_2) {
        this.Brinquedo_2 = Brinquedo_2;
    }
}
