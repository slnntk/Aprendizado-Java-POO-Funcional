package beecrowd;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1041 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        pontos(sc.nextDouble(), sc.nextDouble());
        sc.close();
    }
    public static void pontos(double x, double y){
        if (x == 0 && y == 0) {
            System.out.println("Origem");
        } else if (x == 0) {
            System.out.println("Eixo Y");
        } else if (y == 0) {
            System.out.println("Eixo X");
        } else if (y > 0 && x > 0) {
            System.out.println("Q1");
        } else if (y > 0 && x < 0) {
            System.out.println("Q2");
        } else if (y < 0 && x < 0) {
            System.out.println("Q3");
        } else if (y < 0 && x > 0) {
            System.out.println("Q4");
        }
    }
}
