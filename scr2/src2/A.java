import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Partida(sc);
        sc.close();
    }
}

class Vencedor {

    private String vencedorDoRound;

    public Vencedor(Jogador[] jogadores) {
        this.vencedorDoRound = resultado(jogadores[0], jogadores[1]);
        System.out.println(getVencedorDoRound());
    }

    public String getVencedorDoRound() {
        return vencedorDoRound;
    }

    private String resultado(Jogador j, Jogador m){
        if (j.getPontos() >= m.getPontos()){
            return  j.getNome();
        }
        else {
            return  m.getNome();
        }
    }
}

class Jogador{

    private String nome;
    private int pontos;

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

}

class Round {
    private Jogador jogador1;
    private Jogador jogador2;

    public Round(Scanner sc){
        this.jogador1 = criarJogador("JOAO", sc);
        this.jogador2 = criarJogador("MARIA", sc);
        new Vencedor(getJogadores());
    }

    private Jogador criarJogador(String nome, Scanner sc) {
        int pontos = 0;
        for(int i = 0; i < 3; i++){
            pontos += sc.nextInt() * sc.nextInt();
        }
        return new Jogador(nome, pontos);
    }

    public Jogador[] getJogadores() {
        Jogador[] jogadores = new Jogador[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;
        return jogadores;
    }
}


class Partida{

    public Partida(Scanner sc){
        int n = sc.nextInt();
        for (int i = 0;i < n;i++){
            new Round(sc);
        }
    }
}
