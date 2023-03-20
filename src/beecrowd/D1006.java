package beecrowd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1006 {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        double A, B, C, MEDIA;
        A = Double.parseDouble(in.readLine());
        B = Double.parseDouble(in.readLine());
        C = Double.parseDouble(in.readLine());
        MEDIA = ((A * 2) + (B *3) + (C *5)) / 10;

        System.out.printf("MEDIA = %.1f\n", MEDIA);

    }

}
