package src.interfaceExercicioAula_2.services;

import src.interfaceExercicioAula_2.entities.CarRental;
import src.interfaceExercicioAula_2.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental cr){

        double hours = Math.ceil(Duration.between(cr.getStart(), cr.getFinish()).toMinutes()) / 60;
        double basicPayment = (hours <= 12) ? pricePerHour * hours : pricePerDay * (hours / 24);

        double tax = taxService.tax(basicPayment);
        cr.setInvoice(new Invoice(basicPayment, tax));


    }

}
