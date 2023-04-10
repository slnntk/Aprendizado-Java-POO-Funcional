package src.interfaceExercicioAula.application;

import src.interfaceExercicioAula.entities.Vehicle;
import src.interfaceExercicioAula.entities.CarRental;
import src.interfaceExercicioAula.services.BrazilTaxService;
import src.interfaceExercicioAula.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        dataRental(sc, dtf);
        sc.close();
    }

    public static void dataRental(Scanner sc, DateTimeFormatter dtf){
        System.out.println("Enter with the Car Rental data");

        String model = "Civic";
        System.out.println("Car model: " + model);
        LocalDateTime withdrawDate = LocalDateTime.parse("25/06/2018 10:30", dtf);
        System.out.println("Withdrawal date (dd/MM/yyyy HH:mm): " + withdrawDate);
        LocalDateTime returnDate = LocalDateTime.parse("27/06/2018 11:40", dtf);
        System.out.println("Return date (dd/MM/yyyy HH:mm): " + returnDate);
        Double priceHour = 10.0;
        System.out.println("Enter with hour price: " + priceHour);
        Double priceDay = 130.0;
        System.out.println("Enter with day price: " + priceDay);
        RentalService rentalService = new RentalService(new BrazilTaxService(), priceHour, priceDay);
        CarRental carRental = new CarRental(new Vehicle(model), withdrawDate, returnDate);
        rentalService.processInvoice(carRental);
        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + carRental.getInvoice().getTax());
        System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());
    }

}

/*
Para realidade.

System.out.print("Car model: ");String model = sc.next();
System.out.print("Withdrawal date (dd/MM/yyyy HH:mm): ");LocalDateTime withdrawDate = LocalDateTime.parse(sc.nextLine(), dtf);
System.out.print("Return date (dd/MM/yyyy HH:mm): ");LocalDateTime returnDate = LocalDateTime.parse(sc.nextLine(), dtf);
System.out.print("Enter with hour price: ");Double priceHour = sc.nextDouble();
System.out.print("Enter with day price: ");Double priceDay = sc.nextDouble();

*/

/*
Para testes.

String model = "Civic";
System.out.println("Car model: " + model);
LocalDateTime withdrawDate = LocalDateTime.parse("25/06/2018 10:30", dtf);
System.out.println("Withdrawal date (dd/MM/yyyy HH:mm): " + withdrawDate);
LocalDateTime returnDate = LocalDateTime.parse("27/06/2018 11:40", dtf);
System.out.println("Return date (dd/MM/yyyy HH:mm): " + returnDate);
Double priceHour = 10.0;
System.out.println("Enter with hour price: " + priceHour);
Double priceDay = 130.0;
System.out.println("Enter with day price: " + priceDay);
RentalService rentalService = new RentalService(new BrazilTaxService(), priceHour, priceDay);
CarRental carRental = new CarRental(new Vehicle(model), withdrawDate, returnDate);
rentalService.processInvoice(carRental);
System.out.println("FATURA:");
System.out.println("Pagamento basico: " + carRental.getInvoice().getBasicPayment());
System.out.println("Imposto: " + carRental.getInvoice().getTax());
System.out.println("Pagamento total: " + carRental.getInvoice().getTotalPayment());
 */