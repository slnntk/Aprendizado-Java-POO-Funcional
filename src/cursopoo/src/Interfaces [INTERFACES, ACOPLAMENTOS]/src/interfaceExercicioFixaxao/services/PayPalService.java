package src.interfaceExercicioFixaxao.services;

public class PayPalService implements PaymentService {

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount * (1 + FEE_PERCENTAGE);
    }

    @Override
    public double interest(double amount, int months) {
        return amount + amount * MONTHLY_INTEREST * months;
    }

}
