package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class RifElse {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                sc.close();
                if (n % 2 != 0 ){
                        System.out.println("Weird");
                } else{
                        if (n > 20 || n >= 2 && n <= 5){
                                System.out.println("Not Weird");
                        }
                        else{
                                System.out.println("Weird");
                        }
                }
        }
}
