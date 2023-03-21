package polimorfismoContas;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1001, "Alex", 1000.0);
        Account account1 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);

        account.withdraw(50.0);
        account1.withdraw(50.0);

        System.out.println(account.getBalance());
        System.out.println(account1.getBalance());
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
        return "polimorfismoContas.BusinessAccount{" +
                "loanLimit=" + loanLimit +
                ", balance=" + balance +
                "} " + super.toString();
    }
}

class Account{

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
        return "polimorfismoContas.Account{" +
                "number=" + number +
                ", holder='" + holder + '\'' +
                ", balance=" + balance +
                '}';
    }
}