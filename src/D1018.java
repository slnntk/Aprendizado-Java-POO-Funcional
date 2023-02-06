import java.util.Scanner;

public class D1018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        System.out.println(valor);
        int resto;
        int cem,cinquenta,vinte,dez,cinco,dois,um;

        cem = valor / 100;
        System.out.printf("%d nota(s) de R$ 100,00\n", cem);

        resto = valor % 100;

        cinquenta = resto / 50;
        System.out.printf("%d nota(s) de R$ 50,00\n", cinquenta);

        resto = resto % 50;

        vinte = resto / 20;
        System.out.printf("%d nota(s) de R$ 20,00\n", vinte);

        resto = resto % 20;

        dez = resto / 10;
        System.out.printf("%d nota(s) de R$ 10,00\n", dez);

        resto = resto % 10;

        cinco = resto / 5;
        System.out.printf("%d nota(s) de R$ 5,00\n", cinco);

        resto = resto % 5;

        dois = resto / 2;
        System.out.printf("%d nota(s) de R$ 2,00\n", dois);

        resto = resto % 2;

        um = resto;
        System.out.printf("%d nota(s) de R$ 1,00\n", um);
    }

}
