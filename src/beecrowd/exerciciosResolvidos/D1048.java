package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1048 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double tempinicial = sc.nextDouble();
        double temp = tempinicial;

        if (temp > 0 & temp <= 400){
            temp *= 1.15;
        }
        else if (temp > 400 & temp <= 800){
            temp *= 1.12;
        }
        else if (temp > 800 & temp <= 1200){
            temp *= 1.10;
        }
        else if (temp > 1200 & temp <= 2000){
            temp *= 1.07;
        }
        else{
            temp *= 1.04;
        }
        System.out.printf("Novo salario: %.2f%n" +
                          "Reajuste ganho: %.2f%n" +
                          "Em percentual: %.0f %%%n", temp, temp - tempinicial, (temp/tempinicial * 100) - 100);
        sc.close();
    }
}

