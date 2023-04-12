package src.interfaceDefaultMethodesAula.entities;

public class ConcretInterestService implements InteresestService{

    double interestRate;

    public ConcretInterestService(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

}
