package beecrowd;

import java.util.Locale;
import java.util.Scanner;

public class D1010 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int cod, num, cod2, num2;
        double valor, valor2, total;

        cod = sc.nextInt();
        num = sc.nextInt();
        valor = sc.nextDouble();

        cod2 = sc.nextInt();
        num2 = sc.nextInt();
        valor2 = sc.nextDouble();

        total = num * valor + num2 * valor2;
        System.out.printf("VALOR A PAGAR: R$ %.2f%n", total);

    }

}
