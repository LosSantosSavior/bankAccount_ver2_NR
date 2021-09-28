package com.company;
import java.util.ArrayList;
import java.util.Optional;
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
                    Optional<Customer> current = selectCustomer(menuReader);
                    if (current.isPresent())
                        doCustomerMenu(menuReader, current.get());
                    else
                        System.out.println("No such customer with that ID exists.");
                    break;
                default:
                    System.out.println("Please choose one of the menu options:");
            }
        }
    }

    private void doCustomerMenu(Scanner menuReader, Customer currentCustomer) {
        while(true) {
            printCustomerMenu();
            int customerChoice = menuReader.nextInt();
            switch (customerChoice) {
                case 1:
                    openCustomerAccount(menuReader, currentCustomer);
                    break;
                case 2:
                    closeCustomerAccount(menuReader, currentCustomer);
                    break;
                case 3:
                    Optional<Customer> current = selectCustomer(menuReader);
                    if (current.isPresent())
                        doCustomerMenu(menuReader, current.get());
                    else
                        System.out.println("No customer with that ID exists.");
                    break;
                case 4:
                    doYearlyMaintenance();
                    break;
                default:
                    System.out.println("Invalid input, please choose one of the options listed above.");
            }
        }
    }

    private void doYearlyMaintenance() {
        //for each account - call addInterest and then print account info
        for (var currentAccount:allAccounts)    {
            currentAccount.addInterest();
            System.out.println("Account ID " +currentAccount.getAccountID()+ " has a balance of " +currentAccount.checkBalance());
        }
    }

    private void closeCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        //ask the user what account number to close
        System.out.println("Removing account...");
        System.out.println("Which account ID would you like to close?");
        var accountNum = menuReader.nextInt();
        //call close account on the customer passing that number
        Optional<bankAccount> accountToClose = currentCustomer.closeAccount(accountNum);
        //if the close succeeded remove the account from allAccounts
        if (accountToClose.isPresent())   {
            allAccounts.remove(accountToClose.get());
        }
    }

    private void openCustomerAccount(Scanner menuReader, Customer currentCustomer) {
        //ask the user how much money the starting deposit is
        System.out.println("Creating new account...");
        System.out.println("How much money would you like your starting deposit to be?");
        var initialDeposit = menuReader.nextDouble();
        //call open account on the customer
        var newAccount = currentCustomer.openAccount(initialDeposit);
        //add the new account to allAccounts
        allAccounts.add(newAccount);
    }

    private void printCustomerMenu() {
        System.out.println("=====================================================");
        System.out.println("What do you want to do with this customer?");
        System.out.println("[1] Open new account\n[2] Close an account\n[3] Return to main menu");
        System.out.println("=====================================================");
        System.out.print("Enter choice: ");
    }

    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.println("Customer ID of customer to select:");
        var IDToFind = reader.nextInt();
        for (var currentCustomers: allCustomers)    {
            if (currentCustomers.getID() == IDToFind)
                return Optional.of(currentCustomers);
        }
        return Optional.empty();
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
        System.out.println("=========================================================================");
        System.out.println("What would you like to do next? (select a number from the options below)");
        System.out.println("[1] Exit the program\n[2] Add a customer\n[3] Select customer by ID\n[4] Do the yearly maintenance and show all accounts");
        System.out.print("Enter a choice:");
    }
}
