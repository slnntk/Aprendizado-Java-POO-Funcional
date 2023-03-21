package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1067 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0;i < n+1;i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
        sc.close();
    }
}
