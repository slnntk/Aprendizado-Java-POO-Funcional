package src.interfaceExercicioFixaxao.entities;

import src.interfaceExercicioAula_2.interfaces.TaxService;
import src.interfaceExercicioFixaxao.interfaces.PaymentService;

import java.time.LocalDateTime;

public class Invoice {

    private Double basicPayment;
    private PaymentService taxService;
    private LocalDateTime localDateTime;
    private Contract contract;


    public Invoice() {
    }


    public Invoice(Double basicPayment, PaymentService tax, LocalDateTime localDateTime, Contract contract) {
        this.basicPayment = basicPayment;
        this.taxService = tax;
        this.localDateTime = localDateTime;
        this.contract = contract;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public PaymentService getTax() {
        return taxService;
    }

    public void setTax(PaymentService taxService) {
        this.taxService = taxService;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
