import java.util.Locale;
import java.util.Scanner;

public class D1009 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        String nome;
        double salario, vendas, comissao;

        nome = sc.nextLine();
        salario = sc.nextDouble();
        vendas = sc.nextDouble();

        comissao = vendas * 0.15;

        System.out.printf("TOTAL = R$ %.2f%n", salario+comissao);
        sc.close();

    }

}
