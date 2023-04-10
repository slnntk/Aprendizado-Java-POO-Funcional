package src.interfaceExercicioFixaxao.services;

public interface PaymentService {

    double paymentFee(double interest);

    double interest(double amount, int months);


}
