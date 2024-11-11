package Solution;

import java.util.Scanner;

public class FizzBuzzChallengeSolution {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Number:");
        int numberThree = scanner.nextInt();
        printFizzBuzz(numberThree);  // Use of a reusable method to reduce code repetition
    }

    // DRY principle: A single method to handle FizzBuzz logic
    private static void printFizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {  // Most specific condition first
            System.out.println("FizzBuzz");
        } else if (number % 5 == 0) {
            System.out.println("Fizz");
        } else if (number % 3 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }
}

