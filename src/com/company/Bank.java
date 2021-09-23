package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<bankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    public Bank()   {
        allAccounts = new ArrayList<bankAccount>();
        allCustomers = new ArrayList<Customer>();

    }

    public void doBanking()  {
        var menuReader = new Scanner(System.in);
        while (true)    {
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice) {
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer();
                    break;
            }
        }
    }

    private void addCustomer() {

    }

    private void printMenu() {
        System.out.println("What would you like to do next? (select a number from the options below)");
        System.out.println("[1] Exit the program\n[2] Add a customer\n[3] (WIP) ");
    }
}
