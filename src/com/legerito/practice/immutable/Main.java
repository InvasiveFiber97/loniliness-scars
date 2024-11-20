package com.legerito.practice.immutable;

import dev.bank.BankAccount;
import dev.bank.BankCustomer;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankCustomer hiten = new BankCustomer("Hiten", 500.00, 10000.00);
        System.out.println(hiten);

        BankCustomer aniket = new BankCustomer("Aniket", 500.00, 10000.00);
        System.out.println(aniket);
    }
}
