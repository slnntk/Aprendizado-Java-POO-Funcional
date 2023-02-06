import java.util.Locale;
import java.util.Scanner;

public class D1165 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numeroTestes;

        do{
            numeroTestes = sc.nextInt();
        } while (numeroTestes <= 1 || numeroTestes >= 100);

        int temporario = 0;
        int contador = 0;

        for (int j = 0;j < numeroTestes;j++){
            contador = 0;
            temporario = sc.nextInt();
            for (int i = 1;i <= temporario;i++){
                if (temporario % i == 0){
                    contador = contador + 1;
                }
            }
            if (contador > 2){
                System.out.printf("%d nao eh primo%n", temporario);
            }
            else if (contador == 2){
                System.out.printf("%d eh primo%n", temporario);
            }
        }
    }
}

