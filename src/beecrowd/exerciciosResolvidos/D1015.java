package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1015 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        float[] v1 = new float[4];

        for (int i = 0; i < 4; i++) {
            v1[i] = sc.nextFloat();
        }

        float distancia = (float) Math.sqrt(
                (Math.pow(v1[2] - v1[0], 2)) + (Math.pow(v1[3] - v1[1], 2))
        );
        System.out.printf("%.4f%n", distancia);
    }
}
