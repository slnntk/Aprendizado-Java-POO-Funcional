package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1072 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nNumeros = sc.nextInt();
        int contador = 0;int temporario;

        for (int i = 0;i < nNumeros;i++){
            temporario = sc.nextInt();
            if (temporario >= 10 && temporario <= 20){
                contador++;
            }
        }
        System.out.printf("%d in%n%d out%n", contador, nNumeros-contador);
        sc.close();
    }
}
