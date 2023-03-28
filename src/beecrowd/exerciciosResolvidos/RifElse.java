package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class RifElse {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();

                while (n-- > 0) {
                        int[] pts = {0, 0};
                        for (int i = 0; i < 3; i++) {
                                int x = sc.nextInt();
                                int d = sc.nextInt();
                                pts[0] += x * d;
                        }

                        for (int i = 0; i < 3; i++) {
                                int x = sc.nextInt();
                                int d = sc.nextInt();
                                pts[1] += x * d;
                        }

                        if (pts[0] > pts[1]) {
                                System.out.println("JOAO");
                        } else {
                                System.out.println("MARIA");
                        }
                }

                sc.close();
        }
}
