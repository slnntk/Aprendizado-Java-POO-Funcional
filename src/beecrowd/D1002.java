package beecrowd;

import java.util.Scanner;

public class D1002 {
    public static void main(String[] args) {
        final double pi = 3.14159;
        double area,raio;

        Scanner sc = new Scanner(System.in);
        raio = Double.parseDouble(sc.next());

        area = pi * (raio * raio);
        System.out.printf("A=%.4f\n", area);

    }
}

