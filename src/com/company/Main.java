package com.company;

public class Main {

    public static void main(String[] args) {
        var account = new bankAccount();
        var yourAccount = new bankAccount(2000, 0.05f);
        account.deposit(1000);
        var newBalance = account.addInterest();
        var balance = account.addInterest();

        var succeeded = account.withdraw(2000);
        if (succeeded)
            System.out.println("You successfully withdrew money from your account.");
        else
            System.out.println("Failure to withdraw money from your account. Your balance is: " + account.checkBalance());
    }
}
