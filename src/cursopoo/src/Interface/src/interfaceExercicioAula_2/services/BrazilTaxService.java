package src.interfaceExercicioAula_2.services;

public class BrazilTaxService {

    private Double tax;

    public BrazilTaxService() {
    }
    public BrazilTaxService(Double tax) {
        this.tax = tax;
    }

    public Double tax(Double amount){
        return (amount <= 100) ? 0.20 : 0.15;
    }

    public Double getTax() {
        return tax;
    }
}

