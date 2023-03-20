package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1043 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double[] vetor = {sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};

        calcular(vetor);
        sc.close();
    }

    public static void calcular(double[] vetor){
        if ((vetor[0] < (float)(vetor[1]+vetor[2])) && (vetor[1] < (float)(vetor[0]+vetor[2])) && (vetor[2] < (float)(vetor[1]+vetor[0]))){
            System.out.printf("Perimetro = %.1f\n", vetor[1] + vetor[2] + vetor[0]);
        }
        else {
            System.out.printf("Area = %.1f\n",   (((vetor[0] + vetor[1]) * vetor[2]) / 2));
        }
    }
}

