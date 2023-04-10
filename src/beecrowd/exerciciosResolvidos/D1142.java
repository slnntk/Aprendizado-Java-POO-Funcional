package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1142 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 4 * n; i++) {
            if (i % 4 == 0){
                System.out.printf("PUM%n");
            }
            else{
                System.out.printf("%d ", i);
            }
        }
    }
}