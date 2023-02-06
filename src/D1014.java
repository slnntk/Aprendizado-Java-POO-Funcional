import java.util.Locale;
import java.util.Scanner;

public class D1014 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int distancia; double combustivel;
        distancia = sc.nextInt();
        combustivel  = sc.nextDouble();

        System.out.printf("%.3f km/l%n", (double) distancia/combustivel);
        sc.close();

    }

}
