import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1044 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int[] vetor = {sc.nextInt(), sc.nextInt()};
        int aux;

        for (int i = 0;i < vetor.length-1;i++){
            for (int j = 0;j < vetor.length-1;j++){
                if (vetor[j] > vetor[j+1]){
                    aux = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }
        if (vetor[1] % vetor[0] == 0){
            System.out.println("Sao Multiplos");
        }
        else{
            System.out.println("Nao sao Multiplos");
        }
        sc.close();
    }
}

