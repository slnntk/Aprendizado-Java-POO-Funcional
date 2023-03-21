package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1080 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int temp;
        int pos = 0;
        int maior = 1;
        for (int i = 1;i <= 100;i++){
            temp = sc.nextInt();
            if (temp > maior){
                maior = temp;
                pos = i;
            }
        }
        System.out.printf("%d%n%d%n", maior, pos);
    }
}