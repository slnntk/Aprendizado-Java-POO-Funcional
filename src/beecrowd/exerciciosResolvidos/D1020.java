package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1020 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int dias = sc.nextInt();
        int ano,mes,dia;

        ano = dias / 365;
        mes = (dias % 365) / 30;
        dia = (dias % 365) % 30;

        System.out.printf("%d ano(s)%n%d mes(es)%n%d dia(s)%n",ano, mes, dia);


        sc.close();
    }

}

