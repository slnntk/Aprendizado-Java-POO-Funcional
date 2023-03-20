package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1064 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        double media = 0;
        double temporario;
        int contador = 0;

        for (int i = 0;i < 6;i++){
            temporario = sc.nextDouble();
            if (temporario > 0){
                media += temporario;
                contador++;
            }
            else{

            }
        }

        System.out.printf("%d valores positivos%n%.1f%n", contador, media/contador);

        sc.close();
    }
}
