package src.interfaceDefaultMethodesAula.entities;

import java.security.InvalidParameterException;

public interface InteresestService {

    default Double payment(double amount, int months){
        if (months < 1){
            throw new InvalidParameterException("Months must be greater than zero");
        }
       return amount * Math.pow(1 +  getInterestRate(), months);
    }

    double getInterestRate();

}
