package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
public class D1050 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] vetor = new String[][]{
                {"61", "Brasilia"}, {"71", "Salvador"},
                {"11", "Sao Paulo"}, {"21", "Rio de Janeiro"},
                {"32", "Juiz de Fora"}, {"19", "Campinas"},
                {"27", "Vitoria"}, {"31", "Belo Horizone"}
        };

        for (int i = 0;i < 8;i++){
            if (n == Integer.parseInt(vetor[i][0])){
                System.out.println(vetor[i][1]);
                System.exit(0);
            }
        }
        System.out.println("DDD nao cadastrado");
        sc.close();
    }
}