import java.io.IOException;
import java.util.Scanner;

public class D1078 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Tabuada(sc.nextInt());

    }

    public static void Tabuada(int n){
        for (int i = 1;i <= 10;i++){
            System.out.printf("%d x %d = %d%n", i, n, i * n);
        }
    }
}