import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1116 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Func(sc.nextInt(), sc);

        }

    public static void Func(int numero, Scanner sc){
        for (int i = 0;i < numero;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y == 0){
                System.out.println("divisao impossivel");
            }
            else{
                System.out.printf("%.1f%n", (double) x/y);
            }
        }
        sc.close();
    }
}
