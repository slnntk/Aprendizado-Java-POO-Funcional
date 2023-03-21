package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D3037_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nJogos = sc.nextInt();
        Jogo[] jogos = new Jogo[nJogos];

        for (int i = 0; i < nJogos; i++) {
            jogos[i] = new Jogo(sc);
            jogos[i].jogar();
        }

        sc.close();
    }
}

class Jogo {

    private Jogador[] jogadores;

    public Jogo(Scanner sc) {
        jogadores = new Jogador[2];
        jogadores[0] = new Jogador(sc);
        jogadores[1] = new Jogador(sc);
    }

    public void jogar() {
        int pontosJogador1 = jogadores[0].calcularPontos();
        int pontosJogador2 = jogadores[1].calcularPontos();

        if (pontosJogador1 >= pontosJogador2) {
            System.out.println("JOAO");
        } else if (pontosJogador2 >= pontosJogador1) {
            System.out.println("MARIA");
    }
}

class Jogador {

    private int[] x;
    private int[] d;

    public Jogador(Scanner sc) {
        x = new int[3];
        d = new int[3];
        lerJogadores(sc);
    }

    private void lerJogadores(Scanner sc) {
        int j = 0;
        while (j < 6) {
            int k = j / 2;
            x[k] = sc.nextInt();
            d[k] = sc.nextInt();
            j += 2;
        }
    }

    public int calcularPontos() {
        int pontos = 0;
        for (int i = 0; i < 3; i++) {
            pontos += x[i] * d[i];
        }
        return pontos;
        }
    }
}
