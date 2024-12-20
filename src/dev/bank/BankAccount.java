package dev.bank;

public class BankAccount {

    public enum AccountType { CHECKING, SAVINGS }

    private final AccountType accountType;

    private final double balance;

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(this.accountType, this.balance);
    }
}
