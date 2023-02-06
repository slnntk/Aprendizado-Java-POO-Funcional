import java.util.Locale;
import java.util.Scanner;

public class D1151 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Fibonacci f1 = new Fibonacci();
    }
}

class Fibonacci{

    private int nTermos;

    Scanner sc = new Scanner(System.in);

    public Fibonacci() {
        do{
            nTermos = sc.nextInt();
        } while (nTermos < 0 || nTermos >= 46);
        setnTermos(nTermos);
        calcularFibo(getnTermos());
    }

    public void calcularFibo(int numerodetermos){

        int fibo[] = new int[3];
        fibo[0] = 0;
        fibo[1] = 1;

        System.out.print(fibo[0] + " " + fibo[1] + " ");

        for (int i = 0; i < numerodetermos-2; i++) {
            fibo[2] = fibo[1] + fibo[0];
            fibo[0] = fibo[1];
            fibo[1] = fibo[2];
            if (i == numerodetermos - 3)
            System.out.println(fibo[2]);
            else{
                System.out.print(fibo[2] + " ");
            }
        }
    }

    public int getnTermos() {
        return nTermos;
    }

    public void setnTermos(int nTermos) {
        this.nTermos = nTermos;
    }
}

