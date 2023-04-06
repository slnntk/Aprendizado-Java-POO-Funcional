package classesAbstratasAula;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args)  {

        Locale.setDefault(Locale.US);
        List<Account> accountList = new ArrayList<>();

        accountList.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
        accountList.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
        accountList.add(new SavingsAccount(1004, "Bob", 300.0, 0.01));
        accountList.add(new BusinessAccount(1005, "Anna", 500.0, 500.0));

        double sum = 0.0;

        for (Account acc : accountList){
            sum += acc.getBalance();
        }

        System.out.printf("Total balance: %.2f%n", sum);

        for (Account acc : accountList){
            acc.deposit(10.0);
        }

        for (Account acc : accountList){
            System.out.printf("Upadate balance for account [%d]: (R$ %.2f)%n", acc.getNumber(), acc.getBalance());
        }
    }
}

class SavingsAccount extends Account{

    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(Double amount){
        super.withdraw(amount);
        this.balance += 5;
    }

    public void updateBalancee(){
        this.balance += balance * this.interestRate;

    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}

class BusinessAccount extends Account{
    private Double loanLimit;

    public BusinessAccount() {
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount){
        if (amount <= loanLimit){
            deposit(amount-10);
            this.loanLimit = getLoanLimit() - amount;
        }
        else{
            System.out.printf("Limite disponivel %.2f", getLoanLimit());
            System.out.printf("Pedido de emprestimo no valor de %.2f", amount);
            System.out.printf("A empresa não possui limite para tal emprestimo");
        }
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    @Override
    public String toString() {
        return "classesAbstratas.BusinessAccount{" +
                "loanLimit=" + loanLimit +
                ", balance=" + balance +
                "} " + super.toString();
    }
}

abstract class Account{

    private Integer number;
    private String holder;
    protected Double balance;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public void withdraw(Double amount){
        if (amount <= getBalance()){
            balance = (balance - amount)-5;

        }
        else{
            System.out.printf("Você não possui %.2f para retirada%n", amount);
        }
    }

    public void deposit(Double amount){
        if (amount > 0){
            this.balance = amount + getBalance();
        }
        else{
            System.out.printf("Você não pode depositar um numero negativo (%.2f)%n", amount);
        }
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "classesAbstratas.Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}