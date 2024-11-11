package Solution.Challenge2;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String... args) {
        int principal = getPrincipal();
        float annualInterestRate = getAnnualInterestRate();
        byte years = getYears();

        Loan loan = new Loan(principal, annualInterestRate, years);

        String mortgageFormatted = NumberFormat
                .getCurrencyInstance()
                .format(loan.calculateMortgage());
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    // Method to get principal with input validation
    private static int getPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int principal;
        while (true) {
            System.out.print("Principal ($1,000 - $1,000,000): ");
            if (scanner.hasNextInt()) {
                principal = scanner.nextInt();
                if (principal >= 1000 && principal <= 1_000_000)
                    break;
                else
                    System.out.println("Enter a value between 1,000 and 1,000,000.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return principal;
    }

    // Method to get annual interest rate with input validation
    private static float getAnnualInterestRate() {
        Scanner scanner = new Scanner(System.in);
        float annualInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            if (scanner.hasNextFloat()) {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate > 0 && annualInterestRate <= 30)  // Reasonable max interest rate
                    break;
                else
                    System.out.println("Enter a positive value up to 30.");
            } else {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.next(); // Clear invalid input
            }
        }
        return annualInterestRate;
    }

    // Method to get period (years) with input validation
    private static byte getYears() {
        Scanner scanner = new Scanner(System.in);
        byte years;
        while (true) {
            System.out.print("Period (Years): ");
            if (scanner.hasNextByte()) {
                years = scanner.nextByte();
                if (years > 0 && years <= 100)  // Reasonable max period
                    break;
                else
                    System.out.println("Enter a value between 1 and 100.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Clear invalid input
            }
        }
        return years;
    }
}
