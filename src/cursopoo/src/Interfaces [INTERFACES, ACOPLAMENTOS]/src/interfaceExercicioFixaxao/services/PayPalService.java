package src.interfaceExercicioFixaxao.services;

import src.interfaceExercicioFixaxao.interfaces.PaymentService;

public class PayPalService implements PaymentService {

    private Double tax;

    public PayPalService(Double amount, int parcela) {
        this.tax = tax(amount, parcela);
    }

    @Override
    public Double tax(Double amount, int parcela) {
        double temp = amount + amount * 0.01 * parcela;
        return temp * (1 + 0.02);
    }

    @Override
    public Double getTax() {
        return this.tax;
    }


}
