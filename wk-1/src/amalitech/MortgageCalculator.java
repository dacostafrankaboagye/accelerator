package amalitech;

import javax.sound.midi.Soundbank;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */

public class MortgageCalculator {

    /**
     * Now It’s time for a small project:
     * Use what you’ve learned in the section and build a mortgage calculator
     * When we run this program we get fews questions:
     * Principal – Amount Of Loan We want to get – $ 100000
     * Annual Interest Rate: 3.92 will be devided by 100 then /12
     * Period(Years)- 30 to be * 12 – number of payments
     * Add Erro Handling!!
     * */
    public static void main(String...args){

        final byte MONTHS_IN_YEAR=12;
        final byte PERCENT=100;
        int principal=0;
        Scanner scanner=new Scanner(System.in);

        //How Could We Add The Error handling??
        while(true) {
            System.out.println("Principal:");
            //The Scope Of variable principle should be declared outside the while block? Why?
            principal = scanner.nextInt();
            if(principal>1000 && principal<=1_000_000)
            break;
            System.out.println("Enter A Value Between 1000 and 1000000");
        }

        //How Can we Add The Error handling Here
        System.out.println("Annual Interest Rate:");
        float annualInterestRate=scanner.nextFloat();
        //We need to avoid any implicit value: 4,6 for code readability? Meaningfull & Descriptive Words
        float monthlyInterest=annualInterestRate/PERCENT/MONTHS_IN_YEAR;

        //How can We Add The Error Handling Here?
        System.out.println("Period(Years):");
        byte years=scanner.nextByte();
        int numberOfPayments=years*MONTHS_IN_YEAR;

        //How can We Add The Error Handling Here?
        double mortgage=principal*(monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))/(Math.pow(1+monthlyInterest,numberOfPayments)-1);
        String mortgageFormatted= NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:"+mortgageFormatted);

        //Challenge #2 - Let's increase the readability of  this code
        //Does this program has a number of problem : Input validation???
        //What if You Pass Unexpected Input??String?? or negative values?
        //It's now time to use <<Conditional statement now come help us to solve this>>

        // Next Challenge: when codes start getting too long, it hurts the maintainability!
        //We need to convert the code into smaller and easier chunks using OOP.
        //Build On This Mortgage Calculator To Enhance The Code Using OOP Best Practices And SOLID Principles















    }
}
