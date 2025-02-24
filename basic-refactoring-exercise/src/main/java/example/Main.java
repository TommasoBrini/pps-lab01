package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    private static final int FIRST_HOLDER_ID = 1;
    private static final int INITIAL_BALANCE = 0;
    private static final int FIRST_DEPOSIT = 100;
    private static final int FIRST_WITHDRAW = 30;
    private static final int SECOND_WITHDRAW = 80;


    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", FIRST_HOLDER_ID);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), FIRST_WITHDRAW);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), SECOND_WITHDRAW);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
