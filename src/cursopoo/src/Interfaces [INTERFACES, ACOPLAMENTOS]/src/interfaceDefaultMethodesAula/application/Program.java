package src.interfaceDefaultMethodesAula.application;

import src.interfaceDefaultMethodesAula.entities.BrazilianInterestService;
import src.interfaceDefaultMethodesAula.entities.ConcretInterestService;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Amount: ");double amount = sc.nextInt();
        System.out.print("Months: ");int months = sc.nextInt();
        ConcretInterestService interestService = new BrazilianInterestService();
        System.out.printf("Payment after %d months:%n%.2f",months, interestService.payment(amount, months));
    }
}
