package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1065 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x;int contador = 0;

        for (int i = 0;i < 5;i++){
             x = sc.nextInt();
             if (x % 2 == 0){
                 contador++;
             }
        }
        System.out.printf("%d valores pares%n", contador);
       sc.close();
    }
}
