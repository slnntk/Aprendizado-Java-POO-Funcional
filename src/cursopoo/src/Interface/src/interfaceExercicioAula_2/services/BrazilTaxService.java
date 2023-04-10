package src.interfaceExercicioAula_2.services;

import src.interfaceExercicioAula_2.interfaces.TaxService;

public class BrazilTaxService implements TaxService {

    @Override
    public Double tax(Double amount) {
        return (amount <= 100) ? 0.20 : 0.15;
    }
}

