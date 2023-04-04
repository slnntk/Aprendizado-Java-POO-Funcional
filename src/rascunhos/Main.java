package rascunhos;

import java.io.Serial;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > 0 && y > 0){
                System.out.println(x*y);
            }
            else{
                throw new IllegalArgumentException("Breadth and height must be positive");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("java.lang.Exception: " + e.getMessage());
        }
    }
}
