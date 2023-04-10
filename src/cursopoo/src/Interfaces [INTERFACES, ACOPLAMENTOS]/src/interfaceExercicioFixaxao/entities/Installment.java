package src.interfaceExercicioFixaxao.entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private LocalDate date;
    private final double ammout;

    public Installment(LocalDate date, double ammout) {
        this.date = date;
        this.ammout = ammout;
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyy")) +
                " - " + ammout;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
