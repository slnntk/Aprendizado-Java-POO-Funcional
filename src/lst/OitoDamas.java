package lst;

public class OitoDamas {

    private static final int N = 8;                                                                        // custo = 0, vezes = 1
    private static int[][] tabuleiro = new int[N][N];                                                      // custo = 0, vezes = 1
    private static int contadorTentativas = 0;                                                             // custo = 0, vezes = 1

    public static void main(String[] args) {
        if (resolverProblema()) {                                                                          // custo = 1, vezes = 1
            imprimirTabuleiro();                                                                           // custo = 0, vezes = 1
            System.out.println("Contador de tentativas: " +  contadorTentativas);                          // custo = 0, vezes = 1
        } else {
            System.out.println("Não há solução");                                                          // custo = 0, vezes = 1
        }
    }

    private static boolean resolverProblema() {
        return colocarDama(0);                                                                      // custo = 1, vezes = 1
    }

    private static boolean colocarDama(int coluna) {
        if (coluna >= N) {                                                                                 // custo = 1, vezes = N
            return true; // todas as damas foram colocadas
        }

        for (int i = 0; i < N; i++) {                                                                      // custo = 1, vezes = N + 1
            contadorTentativas++;                                                                          // custo = 0, vezes = N
            if (ehSeguro(i, coluna)) {                                                                     // custo = 1, vezes = N
                tabuleiro[i][coluna] = 1;                                                                  // custo = 0, vezes <= N
                System.out.println("Colocou a dama!");                                                     // custo = 0, vezes <= N
                imprimirTabuleiro();                                                                       // custo = 0, vezes <= N

                if (colocarDama(coluna + 1)) {                                                      // custo = 1, vezes <= N
                    return true;
                }

                tabuleiro[i][coluna] = 0;                                                                  // custo = 0, vezes <= N
                System.out.println("Tirou a dama!");                                                       // custo = 0, vezes <= N
                imprimirTabuleiro();                                                                       // custo = 0, vezes <= N
            }
        }

        return false; // se a dama não pode ser colocada em nenhuma linha nesta coluna
    }

    private static boolean ehSeguro(int linha, int coluna) {
        // Verifica a linha à esquerda
        for (int i = 0; i < coluna; i++) {                                                                 // custo = 1, vezes = coluna + 1
            if (tabuleiro[linha][i] == 1) {                                                                // custo = 1, vezes = coluna
                return false;
            }
        }

        // Verifica a diagonal superior à esquerda
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {                                      // custo = 1, vezes = min(linha, coluna) + 1
            if (tabuleiro[i][j] == 1) {                                                                    // custo = 1, vezes = min(linha, coluna)
                return false;
            }
        }

        // Verifica a diagonal inferior à esquerda
        for (int i = linha, j = coluna; i < N && j >= 0; i++, j--) {                                       // custo = 1, vezes = min(N - linha, coluna) + 1
            if (tabuleiro[i][j] == 1) {                                                                    // custo = 1, vezes = min(N - linha, coluna)
                return false;
            }
        }

        return true;                                                                                       // custo = 0, vezes = 1
    }

    private static void imprimirTabuleiro() {
        System.out.println("     a b c d e f g h");                                                        // custo = 0, vezes = 1
        System.out.println("     _ _ _ _ _ _ _ _");                                                        // custo = 0, vezes = 1
        for (int i = 0; i < N; i++) {                                                                      // custo = 0, vezes = N + 1
            System.out.print((8 - i) + " |  ");                                                            // custo = 0, vezes = N
            for (int j = 0; j < N; j++) {                                                                  // custo = 0, vezes = N^2 + N
                System.out.print(tabuleiro[i][j] + " ");                                                   // custo = 0, vezes = N^2
            }
            System.out.print(" | " + (8 - i) );                                                            // custo = 0, vezes = N
            System.out.println();                                                                          // custo = 0, vezes = N
        }
        System.out.println("     _ _ _ _ _ _ _ _");                                                        // custo = 0, vezes = 1
        System.out.println("     a b c d e f g h");                                                        // custo = 0, vezes = 1
        System.out.println("\n");                                                                          // custo = 0, vezes = 1
    }
}
