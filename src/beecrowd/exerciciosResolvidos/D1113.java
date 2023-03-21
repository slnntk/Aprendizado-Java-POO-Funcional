package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1113 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int X, Y;
        do{
             X = sc.nextInt();
             Y = sc.nextInt();
             if (X > Y){
                 System.out.println("Decrescente");
             }
             else if (X < Y){
                 System.out.println("Crescente");
             }
        } while (X != Y);
        sc.close();
    }
}

