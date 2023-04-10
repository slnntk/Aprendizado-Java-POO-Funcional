package src.interfaceExercicioFixaxao.application;

import src.interfaceExercicioFixaxao.entities.Contract;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.print("Nº: ");int N = sc.nextInt();sc.nextLine();
        System.out.print("Contract Date: ");LocalDateTime localDateTime = LocalDateTime.parse(sc.nextLine() + " 01:01", dateTimeFormatter);
        System.out.print("Valor do contrato: ");Double value = sc.nextDouble();

        Contract contract = new Contract(localDateTime, N, value);
        contract.setContract(contract);


        System.out.print("Meses: ");
        contract.invoiceListCreation(sc.nextInt()); // CRIAÇÃO DAS PRESTAÇÕES.
        System.out.println();
        contract.portionContract(); //IMPRESSÃO DO VALOR DE VENCIMENTO E PREÇO DA PARCELA.

    }
}

