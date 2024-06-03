package lst;


public class OitoDamas {

    private static final int N = 8;//                             Custo (Comparações) | Número de Vezes | Complexidade de Espaço
    private static int[][] tabuleiro = new int[N][N];                 // 0                    | 1                 | O(N^2)
    private static int contadorTentativas = 0;                        // 0                    | 1                 | O(1)

    public static void main(String[] args) {
        if (resolverProblema()) {                                     // 1                    | 1                 | O(1)
            imprimirTabuleiro();
            System.out.println("Contador de tentativas: " + contadorTentativas);
        } else {
            System.out.println("Não há solução");                     // 1                    | 1                 | O(1)
        }
    }

    private static boolean resolverProblema() {
        return colocarDama(0);                                 // 0                    | 1                 | O(N)
    }

    private static boolean colocarDama(int coluna) {
        if (coluna >= N) {                                            // 1                    | N+1               | O(1)
            return true;// todas as damas foram colocadas
        }

        for (int i = 0; i < N; i++) {                                 // 1                    | N+1        | O(1)
            contadorTentativas++;                                     // 0                    | N                 | O(1)
            if (ehSeguro(i, coluna)) {                                // 1                    | N                 | O(N)
                tabuleiro[i][coluna] = 1;                             // 0                    | N                 | O(1)
                System.out.println("Colocou a dama!");
                imprimirTabuleiro();

                if (colocarDama(coluna + 1)) {                 // 1                    | N                 | O(N)
                    return true;
                }

                tabuleiro[i][coluna] = 0;                             // 0                    | N                 | O(1)
                System.out.println("Tirou a dama!");
                imprimirTabuleiro();
            }
        }

        return false;// se a dama não pode ser colocada em nenhuma linha nesta coluna
    }

    private static boolean ehSeguro(int linha, int coluna) {
        // Verifica a linha à esquerda
        for (int i = 0; i < coluna; i++) {                            // 1                    | N                 | O(1)
            if (tabuleiro[linha][i] == 1) {                           // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a diagonal superior à esquerda
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) { // 1                    | N                 | O(1)
            if (tabuleiro[i][j] == 1) {                               // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a diagonal inferior à esquerda
        for (int i = linha, j = coluna; i < N && j >= 0; i++, j--) {  // 1                    | N                 | O(1)
            if (tabuleiro[i][j] == 1) {                               // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a mesma linha à esquerda
        for (int i = coluna - 1; i >= 0; i--) {                       // 1                    | N                 | O(1)
            if (tabuleiro[linha][i] == 1) {                           // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a mesma linha à direita
        for (int i = coluna + 1; i < N; i++) {                        // 1                    | N                 | O(1)
            if (tabuleiro[linha][i] == 1) {                           // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a diagonal superior à direita
        for (int i = linha, j = coluna; i >= 0 && j < N; i--, j++) {  // 1                    | N                 | O(1)
            if (tabuleiro[i][j] == 1) {                               // 1                    | N                 | O(1)
                return false;
            }
        }

        // Verifica a diagonal inferior à direita
        for (int i = linha, j = coluna; i < N && j < N; i++, j++) {   // 1                    | N                 | O(1)
            if (tabuleiro[i][j] == 1) {                               // 1                    | N                 | O(1)
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
