import java.io.IOException;
import java.util.Scanner;


public class D1038 {
        public static void main(String[] args) throws IOException {

                Scanner sc = new Scanner(System.in);

                String[] leitor = sc.nextLine().split(" ");

                Float[][] estoque;
                estoque = new Float[][]{{1f, 2f, 3f, 4f, 5f}, {4.00f, 4.50f, 5.00f, 2.00f, 1.50f}};

                System.out.printf("Total: R$ %.2f%n", estoque[1][Integer.parseInt(leitor[0]) - 1] * Integer.parseInt(leitor[1]));


        }
}
