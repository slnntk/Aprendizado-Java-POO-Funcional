package beecrowd;

import java.io.IOException;
import java.util.Scanner;

public class D1073 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 2;i < n+1;i = i + 2) {
            System.out.printf("%d^%d = %d%n", i, 2, (int) Math.pow(i, 2));
        }
        sc.close();
    }
}
