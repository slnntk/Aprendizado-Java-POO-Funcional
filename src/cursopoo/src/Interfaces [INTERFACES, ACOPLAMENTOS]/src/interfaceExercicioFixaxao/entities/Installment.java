package src.interfaceExercicioFixaxao.entities;

import src.interfaceExercicioFixaxao.services.PayPalService;

import java.time.LocalDateTime;

public class Installment {

    private LocalDateTime date;
    private final double ammout;

    public Installment(LocalDateTime date, double ammout) {
        this.date = date;
        this.ammout = new PayPalService().tax(ammout);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmmout() {
        return ammout;
    }
}
