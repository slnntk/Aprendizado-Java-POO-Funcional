package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1036 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        float a, b, c;

        a = sc.nextFloat();
        b = sc.nextFloat();
        c = sc.nextFloat();

        float delta = b*b - 4*a*c;

        if (delta < 0 || a == 0) {
            System.out.println("Impossivel calcular");
        } else {
            float raizPos = (float) (-b + Math.sqrt(delta)) / (2 * a);
            float raizNeg = (float) (-b - Math.sqrt(delta)) / (2 * a);

            System.out.printf("R1 = %.5f%n" +
                    "R2 = %.5f%n", raizPos, raizNeg);
        }
    }
}