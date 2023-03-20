package beecrowd;

import java.util.Scanner;

public class D1013 {

    public static void main(String[] args) {

        Scanner  sc = new Scanner(System.in);
        int[] vetor = new int[3];

        for (int i = 0;i < 3;i++){
            vetor[i] = sc.nextInt();
        }

        int maior = vetor[0];
        for (int i = 0;i < 3;i++){
            if (maior <= vetor[i]) {
                maior = vetor[i];
            }
        }

        System.out.printf("%d eh o maior%n", maior);

    }

}
