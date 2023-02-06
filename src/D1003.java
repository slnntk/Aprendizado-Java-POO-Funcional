import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1003 {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int A, B, SOMA;

        A = Integer.parseInt(in.readLine());
        B = Integer.parseInt(in.readLine());

        SOMA = A + B;

        System.out.printf("SOMA = %d\n", SOMA);

    }

}
