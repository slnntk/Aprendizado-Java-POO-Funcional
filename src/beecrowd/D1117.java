package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1117 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double nota1, nota2;
            nota1 = sc.nextDouble();
            while (nota1 > 10 || nota1 < 0){
                nota1 = sc.nextDouble();
                System.out.println("nota invalida");
            }
            nota2 = sc.nextDouble();
            while (nota2 > 10 || nota2 < 0){
                nota2 = sc.nextDouble();
                System.out.println("nota invalida");
            }

        System.out.printf("media = %.2f%n", (nota1+nota2)/2);

    }
}
