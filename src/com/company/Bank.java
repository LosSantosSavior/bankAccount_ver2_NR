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

    public void doBanking() {
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
                case 3:
                    Customer current = selectCustomer(menuReader);
                    break;
                default:
                    System.out.println("Please choose one of the menu options:");
            }
        }
    }

    private Customer selectCustomer(Scanner reader) {

    }

    private void addCustomer(Scanner inputReader) {
        System.out.print("What is the new customer's name?");
        inputReader.nextLine(); //eat the orphan newLine from previous nextInt call
        var customerName = inputReader.nextLine();
        System.out.print("What is the new customer's tax ID (SSN)?");
        var taxID = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxID);
        allCustomers.add(newCustomer);
    }

    private void printMenu() {
        System.out.println("What would you like to do next? (select a number from the options below)");
        System.out.println("[1] Exit the program\n[2] Add a customer\n[3] Select customer by ID");
        System.out.print("Enter a choice:");
    }
}
