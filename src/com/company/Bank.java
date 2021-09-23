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
                    addCustomer(menuReader);
                    break;
            }
        }
    }

    private void addCustomer(Scanner inputReader) {
        System.out.print("What is the new customer's name?");
        var customerName = inputReader.nextLine();
        System.out.print("What is the new customer's tax ID (SSN)?");
        var taxID = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxID);
        allCustomers.add(newCustomer);
    }

    private void printMenu() {
        System.out.println("What would you like to do next? (select a number from the options below)");
        System.out.println("[1] Exit the program\n[2] Add a customer\n[3] (WIP) ");
        System.out.print("Enter a choice:");
    }
}
