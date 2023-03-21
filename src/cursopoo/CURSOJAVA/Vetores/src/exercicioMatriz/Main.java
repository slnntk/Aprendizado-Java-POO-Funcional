package exercicioMatriz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matriz = lerMatriz(n, sc);
        imprimir(listaDiagonal(matriz), numerosNeg(matriz));
    }

    public static void imprimir(List<Integer> lista, int nNegativos){
        System.out.println("Diagonal principal:");
        for (Integer i : lista) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println("Numeros negativos: " + nNegativos);
    }

    public static int[][] lerMatriz(int n, Scanner sc) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }

    public static List<Integer> listaDiagonal(int[][] matriz) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    lista.add(matriz[i][j]);
                }
            }
        }
        return lista;
    }

    public static int numerosNeg(int[][] matriz) {
        int count = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
