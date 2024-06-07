package lst;

public class OitoDamas {

    private static final int N = 8;
    private static int[][] tabuleiro = new int[N][N];
    private static int contadorTentativas = 0;

    public static void main(String[] args) {
        if (resolverProblema()) {
            imprimirTabuleiro();
            System.out.println("Contador de tentativas: " + contadorTentativas);
        } else {
            System.out.println("Não há solução");
        }
    }

    private static boolean resolverProblema() {
        return colocarDama(0);
    }

    private static boolean colocarDama(int coluna) {
        if (coluna >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            contadorTentativas++;
            if (ehSeguro(i, coluna)) {
                tabuleiro[i][coluna] = 1;
                System.out.println("Colocou a dama!");
                imprimirTabuleiro();

                if (colocarDama(coluna + 1)) {
                    return true;
                }

                tabuleiro[i][coluna] = 0;
                System.out.println("Tirou a dama!");
                imprimirTabuleiro();
            }
        }

        return false;
    }

    private static boolean ehSeguro(int linha, int coluna) {
        for (int i = 0; i < coluna; i++) {
            if (tabuleiro[linha][i] == 1) {
                return false;
            }
        }

        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        for (int i = linha, j = coluna; i < N && j >= 0; i++, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void imprimirTabuleiro() {
        System.out.println("     a b c d e f g h");
        System.out.println("     _ _ _ _ _ _ _ _");
        for (int i = 0; i < N; i++) {
            System.out.print((8 - i) + " |  ");
            for (int j = 0; j < N; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.print(" | " + (8 - i));
            System.out.println();
        }
        System.out.println("     _ _ _ _ _ _ _ _");
        System.out.println("     a b c d e f g h");
        System.out.println("\n");
    }
}
