package beecrowd;

import java.util.Locale;
import java.util.Scanner;

public class D1017 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        int tempo, velocidade;

        tempo = sc.nextInt();
        velocidade = sc.nextInt();
        System.out.printf("%.3f%n", (float) (velocidade * tempo) / 12);

    }
}
