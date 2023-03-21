package beecrowd.exerciciosResolvidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1008 {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int numero, horas;
        double valor;

        numero = Integer.parseInt(in.readLine());
        horas = Integer.parseInt(in.readLine());
        valor = Double.parseDouble(in.readLine());

        System.out.println("NUMBER = "+numero);
        System.out.printf("SALARY = U$ %.2f\n", valor*horas);

    }

}

