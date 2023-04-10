package src.interfaceExercicioFixaxao.application;

import src.interfaceExercicioFixaxao.entities.Contract;
import src.interfaceExercicioFixaxao.services.ContractServices;
import src.interfaceExercicioFixaxao.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Nº: ");int N = sc.nextInt();sc.nextLine();
        System.out.print("Contract Date: ");LocalDate localDate = LocalDate.parse(sc.nextLine(), dateTimeFormatter);
        System.out.print("Valor do contrato: ");Double value = sc.nextDouble();

        Contract contract = new Contract(localDate, N, value);System.out.print("Meses: ");int meses = sc.nextInt();
        ContractServices contractServices = new ContractServices(new PayPalService());
        contractServices.processContract(contract, meses);

        contract.getAllInstallment();


    }
}

