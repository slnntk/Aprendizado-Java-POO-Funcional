import java.io.IOException;
import java.util.Scanner;

public class D1066 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        int[] vetor = new int[3];

        for (int i = 0;i < 5;i++){
            n = sc.nextInt();
            if (n % 2 == 0){
                vetor[0]++;
            }
            if (n > 0){
                vetor[1]++;
            }
            else if (n < 0){
                vetor[2]++;
            }
        }

        System.out.printf("%d valor(es) par(es)%n" +
                         "%d valor(es) impar(es)%n" +
                         "%d valor(es) positivo(s)%n" +
                         "%d valor(es) negativo(s)%n", vetor[0], 5- vetor[0], vetor[1], vetor[2]);

    }
}
