package src.interfaceExercicioAula_2.services;

import src.interfaceExercicioAula_2.entities.CarRental;
import src.interfaceExercicioAula_2.entities.Invoice;
import src.interfaceExercicioAula_2.interfaces.TaxService;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental cr){
        double duration = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
        double hours = duration / 60;
        double basicPayment = (hours <= 12) ? pricePerHour * Math.ceil(hours) : pricePerDay * (Math.ceil(hours / 24));

        double tax = taxService.tax(basicPayment);
        cr.setInvoice(new Invoice(basicPayment, tax));
    }

}
