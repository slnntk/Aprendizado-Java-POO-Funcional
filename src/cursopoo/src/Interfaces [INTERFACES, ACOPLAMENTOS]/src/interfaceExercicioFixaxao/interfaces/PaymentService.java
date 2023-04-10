package src.interfaceExercicioFixaxao.interfaces;

public interface PaymentService {

    Double tax(Double amount, int parcelas);

    public Double getTax();


}
