package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1143 {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " " + (i*i) + " " + (i*i*i));
        }
    }

}