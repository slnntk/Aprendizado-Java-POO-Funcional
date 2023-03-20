package beecrowd;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class D1099 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] vetor = new int[2];
        for (int i = 0;i < N;i++){
            int soma = 0;
               vetor[0] = sc.nextInt();
               vetor[1] = sc.nextInt();
               Arrays.sort(vetor);
               for (int j = vetor[0]+1;j < vetor[1];j++){
                   if (j % 2 != 0){
                       soma += j;
                   }
               }
            System.out.println(soma);
        }
        sc.close();
    }

}