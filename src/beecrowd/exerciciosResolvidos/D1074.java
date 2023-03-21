package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D1074 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i < n;i++){
            int temporario = sc.nextInt();
            if (temporario != 0){
                System.out.printf("%s %s%n", ParImpar(temporario),PosNeg(temporario));
            }
            else{
                System.out.println("NULL");
            }

        }
    sc.close();
    }

    public static String PosNeg(int numero){

        if (numero > 0){
            return "POSITIVE";
        }
        else{
            return "NEGATIVE";
        }
    }

    public static String ParImpar(int numero){

        if (numero % 2 == 0){
            return "EVEN";
        }
        else{
            return "ODD";
        }
    }


}