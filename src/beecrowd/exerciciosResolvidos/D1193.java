package beecrowd.exerciciosResolvidos;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class D1193 {

    public static void main(String[] args) throws IOException  {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int nTestes = sc.nextInt();
        int dec;
        String teste;

        String[] quebragalho = new String[2];

        for (int i = 0; i < nTestes; i++) {

            do {
                do {
                    teste = sc.nextLine();
                } while (teste.length() < 4);

                String[] quebrandogalho = teste.split(" ");
                quebragalho[0] = quebrandogalho[0];
                quebragalho[1] = quebrandogalho[1];

            } while (quebragalho[0].length() * 8 > 8 && !quebragalho[1].equalsIgnoreCase("bin") && !quebragalho[1].equalsIgnoreCase("hex") && !quebragalho[1].equalsIgnoreCase("dec"));

            System.out.printf("Case %d:%n", i + 1);

            switch (quebragalho[1]) {
                case "bin" -> {
                    // Para converter um número binário para decimal:
                    dec = Integer.parseInt(quebragalho[0], 2);
                    System.out.println(dec + " dec");
                    // Para converter um número binário para hexadecimal:
                    System.out.println(Integer.toString(dec, 16) + " hex\n");

                }
                case "dec" -> {
                    dec = Integer.parseInt(quebragalho[0]);
                    //Para converter um número decimal para hexadecimal://
                    System.out.println(Integer.toString(dec, 16) + " hex");
                    // Para converter um número decimal para binário://
                    System.out.println(Integer.toString(dec, 2) + " bin\n");
                }
                case "hex" -> {
                    dec = Integer.parseInt(quebragalho[0], 16);
                    System.out.println(dec + " dec");
                    System.out.println(Integer.toString(dec, 2) + " bin\n");
                }
            }
        }
    }
}
