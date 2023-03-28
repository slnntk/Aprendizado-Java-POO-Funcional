package excecoesFixaxao;

import java.io.Serial;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                withdraw(sc, a);
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
            System.out.print("Initial balance: ");Double balance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");Double withdrawlimit = sc.nextDouble();
            System.out.println(number + "" + holder + "" + balance + "" + withdrawlimit);
            accountList.add(new Account(number, holder, balance, withdrawlimit));
    }

    public void withdraw(Scanner sc, Account account){
        System.out.println("Enter amount for withdraw: ");Double withdraw = sc.nextDouble();
        account.withdraw(withdraw);
    }

}

class Account{

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
        deposit(balance);
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double ammount){
        this.balance = ammount + getBalance();
    }

    public void withdraw(double ammount){

        if (ammount > balance){
            throw new DomainException("Insufficient balance for withdraw of this amount");
        }
        if (ammount > withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }

        this.balance = balance - ammount;
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
