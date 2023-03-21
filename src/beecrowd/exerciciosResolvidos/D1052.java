package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1052 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[][] meses = {
                {"1", "January"},
                {"2", "February"},
                {"3", "March"},
                {"4", "April"},
                {"5", "May"},
                {"6", "June"},
                {"7", "July"},
                {"8", "August"},
                {"9", "September"},
                {"10", "October"},
                {"11", "November"},
                {"12", "December"}
        };

        for (int i = 0;i < 12;i++){
            if (n == Integer.parseInt(meses[i][0])){
                System.out.println(meses[i][1]);
                break;
            }
        }
    }
}
