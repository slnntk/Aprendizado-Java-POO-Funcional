import java.io.IOException;
import java.util.Scanner;

public class D1070 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n;i < n + 12;i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
        sc.close();
    }
}
