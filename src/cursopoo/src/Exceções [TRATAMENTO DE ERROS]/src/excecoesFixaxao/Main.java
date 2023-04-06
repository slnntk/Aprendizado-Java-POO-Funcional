package excecoesFixaxao;

import java.io.Serial;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        new Banco();
    }
}

class DomainException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }

}

class Banco {

    private List<Account> accountList = new ArrayList<>();

    public Banco() {
        Scanner sc = new Scanner(System.in);
        try {
            createAccount(sc);
            for (Account a : accountList){
                a.withdraw(sc.nextInt());
                System.out.printf("New balance: %.2f", a.getBalance());
            }
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid inputs");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index fail search");
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }

    public void createAccount(Scanner sc) {
            System.out.println("Enter account data");
            System.out.print("Nummber: ");Integer number = sc.nextInt();
            System.out.print("Holder: ");sc.nextLine();String holder = sc.nextLine();
            System.out.print("Initial balance: b ");Double balance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");Double withdrawlimit = sc.nextDouble();
            accountList.add(new Account(number, holder, balance, withdrawlimit));
    }

}

class Account{

    private Integer number;
    private String holder;
    private Double balance = 0.0;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        deposit(balance);
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double ammount){
        this.balance += ammount;
    }

    public void withdraw(int ammount){
        System.out.println("Enter amount for withdraw: ");
        if (ammount > getBalance()){
            throw new DomainException("Insufficient balance for withdraw of this amount");
        }
        if (ammount > getWithdrawLimit()){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        this.balance -= ammount;
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

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
}
