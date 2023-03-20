package beecrowd;

import java.util.Locale;
import java.util.Scanner;

public class D1012 {

    public static void main(String[] args) {

        final double pi = 3.14159;
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        double A, B, C;

        A = sc.nextDouble();B = sc.nextDouble() ;C = sc.nextDouble();

        System.out.printf("TRIANGULO: %.3f%n", ((A * C))/2);
        System.out.printf("CIRCULO: %.3f%n",(pi * Math.pow(C, 2)));
        System.out.printf("TRAPEZIO: %.3f%n", (((A + B)*C)/2) );
        System.out.printf("QUADRADO: %.3f%n", Math.pow(B, 2));
        System.out.printf("RETANGULO: %.3f%n", A*B);

        sc.close();

    }

}
