package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1133 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int al=0, gs=0, ds=0;
        int n;
        do{
            n = sc.nextInt();
            if (n == 1){
                al+= 1;
            }
            else if (n == 2){
                gs+= 1;
            }
            else if (n == 3){
                ds += 1;
            }
        } while (n != 4);
        System.out.println("MUITO OBRIGADO");
        System.out.printf("Alcool: %d%n", al);
        System.out.printf("Gasolina: %d%n", gs);
        System.out.printf("Diesel: %d%n", ds);
    }
}
