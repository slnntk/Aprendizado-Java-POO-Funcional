import java.io.IOException;import java.util.Locale;
import java.util.Scanner;

public class Testes {

        public static void main(String[] args)  throws IOException {
                Scanner sc = new Scanner(System.in);
                sc.useLocale(Locale.ENGLISH);
                Locale.setDefault(new Locale("en", "US"));

                int x=1, y=1;

                while (x != 0 && y != 0){
                        x = sc.nextInt();
                        y = sc.nextInt();

                        if (x > 0 && y > 0)
                                System.out.println("primeiro");
                        if (x < 0 && y > 0)
                                System.out.println("segundo");
                        if (x < 0 && y < 0)
                                System.out.println("terceiro");
                        if (x > 0 && y < 0)
                                System.out.println("quarto");
                }
                sc.close();
        }
}