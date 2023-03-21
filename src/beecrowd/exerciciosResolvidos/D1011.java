package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1011 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        final double pi = 3.14159;
        double raio, volume;

        Scanner sc = new Scanner(System.in);
        raio = sc.nextDouble();

        volume = (4.0/3.0) * pi * Math.pow(raio, 3);

        System.out.printf("VOLUME = %.3f%n", volume);
        sc.close();

    }

}
