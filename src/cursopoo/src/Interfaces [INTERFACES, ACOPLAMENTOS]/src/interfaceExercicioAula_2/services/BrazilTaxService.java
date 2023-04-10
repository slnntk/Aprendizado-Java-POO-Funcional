package src.interfaceExercicioAula_2.services;

import src.interfaceExercicioAula_2.interfaces.TaxService;

public class BrazilTaxService implements TaxService {

    @Override
    public Double tax(Double amount) {
        return (amount <= 200) ? amount * 0.20 : amount * 0.15;
    }
}

