package beecrowd.exerciciosResolvidos;


import java.io.IOException;
import java.util.Scanner;

public class D1132 {

    public static void main(String[] args) throws IOException {

        Scanner  sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int soma = 0;
        for (int i = Math.min(n1, n2);i < Math.max(n1, n2)+1;i++){
            if (i % 13 != 0){
                soma +=i;
            }
        }
        System.out.println(soma);
    }
}
