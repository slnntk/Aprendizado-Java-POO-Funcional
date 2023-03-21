package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1045 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double[] vetor = {sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};
        double temp;

        calcular(vetor);
        sc.close();
    }

    public static void calcular(double vetor[]){

        double temp;


        for (int i = 0; i < vetor.length; i++){
            for (int j = 0; j < vetor.length - 1; j++){
                if (vetor[j] < vetor[j+1]){
                    temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                }
            }
        }

        if (vetor[0] >= vetor[1] + vetor[2]) {
            System.out.println("NAO FORMA TRIANGULO");
        }
        else{
            if (vetor[0] * vetor[0] == vetor[1] * vetor[1] + vetor[2] * vetor[2]) {
                System.out.println("TRIANGULO RETANGULO");
            }
            if (vetor[0] * vetor[0] > vetor[1] * vetor[1] + vetor[2] * vetor[2]) {
                System.out.println("TRIANGULO OBTUSANGULO");
            }
            if (vetor[0] * vetor[0] < vetor[1] * vetor[1] + vetor[2] * vetor[2]) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if (vetor[0] == vetor[1] && vetor[1] == vetor[2]) {
                System.out.println("TRIANGULO EQUILATERO");
            }
            else if (vetor[0] == vetor[1] || vetor[1] == vetor[2] || vetor[0] == vetor[2]) {
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}

