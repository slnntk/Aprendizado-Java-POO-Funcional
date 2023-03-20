package beecrowd;

import java.util.Scanner;

public class D3037_REFEITA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Partida(sc);
        sc.close();
    }
}

class Vencedor{

    private String vencedorDoRound;

    public Vencedor(int pontosJoao, int pontosMaria) {
        this.vencedorDoRound = resultado(pontosJoao, pontosMaria);
    }
    public String getVencedorDoRound() {
        return vencedorDoRound;
    }

    private String resultado(int pontosJoao, int pontosMaria){
        if (pontosJoao >= pontosMaria){
            return  "JOAO";
        }
        else {
            return  "MARIA";
        }
    }
}

class Round {

    private int pontosMaria;
    private int pontosJoao;

    public Round(Scanner sc){
        round(sc);
    }

    private void round(Scanner sc){
        pontosJoao = 0;
        pontosMaria = 0;
        for(int i = 0;i < 3;i++){
            pontosJoao += sc.nextInt() * sc.nextInt();
        }
        for(int i = 0;i < 3;i++){
            pontosMaria += sc.nextInt() * sc.nextInt();
        }
    }

    public int getPontosMaria() {
        return pontosMaria;
    }

    public int getPontosJoao() {
        return pontosJoao;
    }
}

class Partida{

    public Partida(Scanner sc){
        int n = sc.nextInt();
        for (int i = 0;i < n;i++){
            Round round = new Round(sc);
            Vencedor vencedor = new Vencedor(round.getPontosJoao(), round.getPontosMaria());
            System.out.println(vencedor.getVencedorDoRound());
        }
    }
}
