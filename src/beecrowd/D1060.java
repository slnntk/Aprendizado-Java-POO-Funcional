package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1060 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double temp;
        int contador = 0;

        for (int i = 0;i < 6;i++){
            temp = sc.nextDouble();
            if (temp > 0){
                contador++;
            }
        }
        System.out.printf("%d valores positivos%n", contador);
        sc.close();
    }
}

