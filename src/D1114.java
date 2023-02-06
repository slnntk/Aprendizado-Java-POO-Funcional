import java.util.Locale;
import java.util.Scanner;

public class D1114 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            input = sc.nextInt();
            if (input != 2002) {
                System.out.println("Senha Invalida");
            }
        } while (input != 2002 );

        System.out.println("Acesso Permitido");
        sc.close();
    }
}