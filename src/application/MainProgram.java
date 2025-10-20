package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class MainProgram {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("=== Enter account data ===");
            System.out.print("Account Number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Account Holder: ");
            sc.nextLine(); // limpar o buffer
            String accountHolder = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.print("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc = new Account(accountNumber, accountHolder, balance, withdrawLimit);

            System.out.println();
            System.out.println("=== Account Summary ===");
            System.out.println(acc);

            System.out.print("Enter amount for withdraw: ");
            double withdraw = sc.nextDouble();

            acc.withdraw(withdraw);

            System.out.println();
            System.out.printf("New Balance: %.2f%n", acc.getBalance());

        } 
        catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("Input error: please enter valid numeric values.");
        } 
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } 
        finally {
            sc.close();
        }
    }
}
