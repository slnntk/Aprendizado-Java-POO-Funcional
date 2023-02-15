import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class D1071 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[]{sc.nextInt(), sc.nextInt()};
        Arrays.sort(vetor);
        int soma = 0;
        for (int i = vetor[0]+1;i < vetor[1];i++){
            if (i % 2 != 0){
                soma += i;
            }
        }
        System.out.println(soma);
        sc.close();
    }
}
