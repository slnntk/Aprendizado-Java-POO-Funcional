import java.io.IOException;
import java.util.Scanner;

public class D1115 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int X, Y;

        do{
            X = sc.nextInt();
            Y = sc.nextInt();
            quadrante(X, Y);
        } while (X != 0 && Y != 0);
        sc.close();
    }

    public static void quadrante(int X, int Y){

        if (X > 0 & Y > 0){
            System.out.println("primeiro");
        }
        else if (X < 0 & Y > 0){
            System.out.println("segundo");
        }
        else if (X < 0 & Y < 0){
            System.out.println("terceiro");
        }
        else if (X > 0 & Y < 0){
            System.out.println("quarto");
        }
    }
}
