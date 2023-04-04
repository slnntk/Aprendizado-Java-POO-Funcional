package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Scanner;

public class D3401 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int goiabeiras = sc.nextInt();
        int saltomax = sc.nextInt();

        int n = 0;
        boolean finish = true;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        while (n < goiabeiras){
            int x = sc.nextInt();
            int y = sc.nextInt();
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
            finish = canJump(maxX, minX, saltomax);
            n++;
        }
        System.out.println(finish(finish));


    }
    public static boolean canJump(int n1, int n2, int salto){
        return n2 - n1 <= salto;
    }

    public static String finish(boolean jumping){
        String temp;
        if (jumping){
            temp = "S";
        }
        else{
            temp = "N";
        }
        return temp;
    }

}


