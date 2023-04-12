package colecoesGenericsAula.application;

import colecoesGenericsAula.services.ConcretPrintService;
import colecoesGenericsAula.services.PrintService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintService printService = new ConcretPrintService();

        System.out.print("How many values? ");int n = sc.nextInt();
        for (int i = 0;i < n;i++){
             printService.addValue(sc.nextInt());
        }
        System.out.printf("First: %d%n", printService.first());
        printService.print();
    }
}
