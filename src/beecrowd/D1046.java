package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1046 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int horainicial = sc.nextInt();
        int horafinal = sc.nextInt();

        if (horainicial >= horafinal){
            System.out.printf("O JOGO DUROU %d HORA(S)%n", (horafinal+24) - horainicial);
        }
        else{
            System.out.printf("O JOGO DUROU %d HORA(S)%n", horafinal - horainicial);
        }
        sc.close();
    }
}

