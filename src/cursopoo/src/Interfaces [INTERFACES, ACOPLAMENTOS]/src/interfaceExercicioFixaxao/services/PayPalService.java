package src.interfaceExercicioFixaxao.services;

import src.interfaceExercicioFixaxao.interfaces.PaymentService;

public class PayPalService implements PaymentService {

    private static int parcela = 0;

    public PayPalService() {
        parcela++;
    }

    @Override
    public Double tax(Double amount) {
        double temp = amount + amount * 0.01 * parcela;
        return temp * (1 + 0.02);
    }
}
