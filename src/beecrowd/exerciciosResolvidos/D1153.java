package beecrowd.exerciciosResolvidos;

import java.util.Locale;
import java.util.Scanner;

public class D1153 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Fatorial f1 = new Fatorial();
    }
}

class Fatorial {

    int N;
    Scanner sc = new Scanner(System.in);

    public Fatorial() {

        do {
            N = sc.nextInt();
        } while (N < 0 || N >= 13);
        setN(N);
        CalcularFatorial(N);
    }

    public int CalcularFatorial(int Numero){
        int resultado = 1;
        for (int i = 1;i <= Numero;i++){
            resultado *= i;
        }
        System.out.println(resultado);
        return resultado;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }
}

