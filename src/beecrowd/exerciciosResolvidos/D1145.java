package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1145 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int x, y;

        do{
             x = sc.nextInt();
             y = sc.nextInt();
        } while (x < 1 || x > 20 || y < x || y > 100000);

        for (int j = 1;j < y+1;){
            for (int i = 1;i < x+1;i++){
                if (i == x){
                    System.out.printf("%d", j);
                    j++;
                }
                else{
                    System.out.printf("%d ", j);
                    j++;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
