import java.util.Locale;
import java.util.Scanner;

public class D1021 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        double valor = sc.nextDouble();
        double vetor[] = {100, 50, 20, 10, 5, 2, 1, 0.50, 0.25, 0.10, 0.05, 0.01};
        double cedula, resto;

        System.out.println("NOTAS:");
        resto = valor;
        for (int i = 0;i <= 5;i++){
            cedula = resto / vetor[i];
            System.out.printf("%d nota(s) de R$ %.2f%n",(int) cedula, vetor[i]);
            resto = resto % vetor[i];
        }
        System.out.println("MOEDAS:");
        for (int i = 6;i < 12;i++){
            cedula = resto / vetor[i];
            cedula = (int) cedula;
            System.out.printf("%d moeda(s) de R$ %.2f%n", (int) cedula, vetor[i]);
            resto = resto % vetor[i];
        }
        sc.close();
    }

}

