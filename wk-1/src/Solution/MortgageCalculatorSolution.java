package Solution;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculatorSolution {

    public static void main(String...args){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float annualInterestRate = 0;
        byte years = 0;
        Scanner scanner = new Scanner(System.in);

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

        while (true) {
            System.out.print("Annual Interest Rate: ");
            if (scanner.hasNextFloat()) {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate > 0 && annualInterestRate <= 30)  // Assuming a realistic max interest rate of 30%
                    break;
                else
                    System.out.println("Enter a positive value up to 30.");
            } else {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.next(); // Clear invalid input
            }
        }

        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        while (true) {
            System.out.print("Period (Years): ");
            if (scanner.hasNextByte()) {
                years = scanner.nextByte();
                if (years > 0 && years <= 100)  // Assuming a maximum loan period of 100 years
                    break;
                else
                    System.out.println("Enter a value between 1 and 100.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Clear invalid input
            }
        }

        int numberOfPayments = years * MONTHS_IN_YEAR;

        // Calculate mortgage
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
