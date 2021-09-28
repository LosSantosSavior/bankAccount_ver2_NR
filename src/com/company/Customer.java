package com.company;
import java.util.ArrayList;
import java.util.Optional;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<bankAccount> accounts;

    public Customer(String customerName, int taxID)   {
        customerID = taxID;
        name = customerName;
    }

    private Optional<bankAccount> closeAccount(int accountNumber)    {
        for (var account:accounts)  {
            if(account.getAccountID() == accountNumber) {
                System.out.println("Retrieving account with ID " +accountNumber+ " from customer " +name);
                accounts.remove(account);
                return Optional.of(account);
            }
        }
        System.out.println("Account with account ID " +accountNumber+ " is not "+name+ "'s account");
        return Optional.empty();
    }

    public boolean openAccount(double initialDeposit)   {
        var newAccount = new bankAccount();
        newAccount.deposit(initialDeposit);
        var didSucceed = accounts.add(newAccount);
        return didSucceed;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return customerID;
    }

}
