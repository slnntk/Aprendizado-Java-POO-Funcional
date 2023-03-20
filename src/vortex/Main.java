package vortex;

public class Main {
    public static void main(String[] args) {

        //Rainha (6)
        //Rei (5)
        //Torre (4)
        //Cavalo (3)
        //Bispo (2)
        //Peao (1)
        //Vazio (0)

        //Tabuleiro 8x8

        int[][] tabuleiroDeXadrez = {
                {4, 3, 2, 6, 5, 2, 3, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {4, 3, 2, 6, 5, 2, 3, 4}};

        int[] pecasDoXadrez = new int[7];

        for(int i = 0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                pecasDoXadrez[tabuleiroDeXadrez[i][j]]++;
            }
        }

        String[] vetorDeImpressoes = {"Vazio", "Peão", "Bispo", "Cavalo", "Torre", "Rei", "Rainha"};

        for (int i = 1;i < 7;i++){
            System.out.printf("%s: %d peça(s)%n", vetorDeImpressoes[i], pecasDoXadrez[i]);
        }

        /*int[][] tabuleiroDeXadrez = {
                {4, 3, 2, 1, 5, 0, 6, 0},
                {4, 3, 2, 0, 5, 0, 6, 0},
                {4, 3, 0, 0, 5, 0, 6, 0},
                {4, 0, 0, 0, 5, 0, 6, 0},
                {0, 0, 0, 0, 5, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
                }
                */



    }

}
