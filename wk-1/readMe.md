# Java Upskilling Training

Welcome to the Java Foundational Upskilling Training program(Week 2)! This training is designed to provide developers with a deep understanding of Java's foundational concepts, syntax, and best practices. I've utilized IntelliJ to guide you through key takeaways and summarize essential training notes. The following sections cover the core aspects of the training:

## Table of Contents

1. [Understanding The Anatomy Of Java](#understanding-the-anatomy-of-java)
2. [Control Flows](#control-flows)
3. [Iteration Master](#iteration-master)
4. [Java Types](#java-types)
5. [Mortgage Calculator](#mortgagecalculator)

## Understanding The Anatomy Of Java

```java
/**
 * Key Takeaways & Summary:
 * 1. Understanding The Anatomy Of Java
 * 2. ReturnTypes: void.
 * 3. A program should at least have 1 function
 * 4. A function cannot stand for itself
 * 5. A class contains a group of related functions
 * 6. Class Example: AnatomyOfJava
 * 7. Method Name: main - with a reserved keyword
 * 8. Access Modifier determines accessibility: Public, private
 * 9. PascalNamingConvention - For naming Classes
 * 10. CamelNamingConvention - For naming Methods & Variables
 * 11. First Java Program
 */

public class AnatomyOfJava {

    /**
     * Java Code Execution & Compilation
     * Note: to be a good program requires knowing how to write good code - Outstanding program vs. average programmer
     * What are the various techniques professional programmers use to write clean code and make their code clean and maintainable
     * How to find and fix errors
     * How to package the application for deployment so that others can use them
     */

    public static void main(String[] args) {
        System.out.println("Agenda Items:");
        System.out.println("1. Types");
        System.out.println("2. Control Flow");
        System.out.println("3. Clean Coding");
        System.out.println("4. Finding and Fixing Errors");
        System.out.println("4. Packaging Your Application");
    }
}
```
## Control Flows

```java
/**
 * Key Things To Know at Foundational Core Java Level:
 * 1. Comparison Operators
 * 2. Logical Operators
 * 3. Conditional Statement
 * 4. Loops
 */

public class ControlFlows {

    public static void main(String... args) {
        // Slide #20: Let's dive into Conditional Operators
        // Boolean operation & inequality operation
        // Are we comparing x & y here?
        int x = 1;
        int y = 1;
        System.out.println(x == y);

        // Are we comparing x & y here?
        System.out.println(x != y);
        System.out.println(x < y);

        // Slide #21: Logical Operators
        int a = 1;
        int b = 2;
        System.out.println(a <= b);

        int temperature = 12;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        boolean hasHighIncome = false;
        boolean hasGoodCredit = true;
        // boolean isEligible= hasHighIncome || hasGoodCredit;

        // Let's add another variable: hasCriminalRecord
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible);

        // Slide #22: If Statement
        /**
         * Pseudocode - Algorithm - Problem Solving
         * 1. If temp is greater than 30
         * it's a hot day
         * Drink plenty of water
         * Otherwise, if it's been 20 and 30
         * It's a nice day
         * Otherwise
         * It's cold
         * */
        int temp = 32;

        if (temp > 30) {
            System.out.println("It's a hot day");
            System.out.println("Drink Water");
            // We can remove : && temp<=30
        } else if (temp > 20) {
            System.out.println("Beautiful Day");
        } else {
            System.out.println("Cold Day");
        }

        // Slide #23: Simplifying If Statement
        // Any observed Error - Declaration is not Allowed under a function?
        int income = 120_000;
        // How Can we Improve the code as Professional Developer??
        // Add an initial value

        boolean hasHigherIncome = income > 100_000;

        /*
        // Remove this code for better clean
        if(income>100_000)
            hasHigherIncome=true;
         */
        /*
        remove this for unnecessary code
        else
            hasHigherIncome=false;
            */

        // System.out.println(hasHigherIncome); What is a variable scope???

        // Can we improve the code using the ternary operation??
        // Example: #1
        int incomeTwo = 120_000;
        String className;
        if (incomeTwo > 100_000)
            className = "First";
        else
            className = "Economy";

        // Example: #1
        int incomeThree = 120_000;
        String classNameTwo = "Economy";
        if (incomeThree > 100_000)
            classNameTwo = "First";

        // Example: #2
        int incomeFour = 120_000;
        String classNameFour = incomeThree > 100_000 ? "First" : "Economy";

        // Slide #24: Switch Statement
        // Example #1:
        String role = "Admin";
        if (role == "Admin") {
            System.out.println("You're An Admin");
        } else if (role == "Moderator") {
            System.out.println("You're An Administrator");
        } else {
            System.out.println("You're A guest");
        }

        // Example #2:

        switch (role) {
            case "Admin":
                System.out.println("You're An Admin");
                break;
            case "Moderator":
                System.out.println("You're A Moderator");
                break;
            default:
                System.out.println("You're A Guest");
        }
    }
```


## Iteration Master
```java
import java.util.Scanner;

/**
 * Slide #30: For Loops
 *
 * Example #1:
 * - Printing "Hello World" five times.
 *
 * Example #2: Using For Loop - having A prior Knowledge on the number of iterations??
 * - Printing "Hello World" with loop index.
 * - Using a For Loop in reverse order.
 *
 * Slide #31: While Loops
 *
 * - Using a While Loop to take user input until "quit" is entered.
 *
 * Slide #32: Do While Loops
 *
 * - Using a Do While Loop to take user input until "quit" is entered.
 *
 * Slide #33: Break & Continue
 *
 * - Using Break & Continue statements in a While Loop based on user input.
 *
 * Slide #34: For Each Loop
 *
 * - Using a For Loop and For Each Loop to iterate over an array of fruits.
 *
 */

public class IterationMaster {
    public static void main(String... args) {
        // Slide #30: For Loops

        // Example #1:
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        // Example #2: Using For Loop - having A prior Knowledge on the number of iterations??
        for (int i = 0; i <= 5; i++) {
            System.out.println("Hello World:" + i);
        }

        // Example #2: Using For Loop - having A prior Knowledge on the number of iterations?? Reverse Order
        for (int i = 5; i > 0; i--) {
            System.out.println("Hello World:" + i);
        }

        // Slide #31: While Loops
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("quit")) {
            System.out.println("Input:");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }

        // Slide #32: Do While Loops
        String inputTwo = "";
        do {
            Scanner scannerTwo = new Scanner(System.in);
            inputTwo = scannerTwo.next().toLowerCase();
            System.out.println(inputTwo);
        } while (!inputTwo.equals("quit"));

        // Slide #33: Break & Continue
        String inputThree = "";
        Scanner scannerThree = new Scanner(System.in);
        while (true) {
            System.out.println("Input:");
            inputThree = scannerThree.next().toLowerCase();
            if (inputThree.equals("pass"))
                continue;
            if (inputThree.equals("quit"))
                break;
            System.out.println(inputThree);
        }

        // Slide #34: For Each Loop
        String[] fruits = {"Apple", "Mango", "Orange"};

        // Example #1: Using For Loop
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Fruit:" + fruits[i]);
        }

        // Using For Each Loop
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
```

## Java Types

```java
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * 1. Variables and Constants
 * 2. Primitive and Reference Types
 * 3. Casting
 * 4. Numbers, Strings, and Arrays
 * 5. Read Input
 * 6. Build A mortgage calculator on your own
 * 7. Pay Attention!! Are you ready!!
 */
public class JavaTypes {

    public static void main(String... args) {
        // Slide #1
        // Topic "variables"
        // Variables Declaration & Assignment
        // Remember you can assign variables in one line as well: int age=30,temperature=20
        int age = 30;
        // Assign a new number to check if the number in the memory changes
        age = 35;
        System.out.println(age);

        // Slide #2:
        int myAge = 30;
        int herAge = myAge;
        System.out.println(herAge);

        // Slide #3: Primitive Types - Stores Simple Values - Reference Type Stores Complex Objects
        /**
         * byte takes 1 byte of memory-values range is [-127,127]
         * short takes 2 bytes of memory - values range is[-31k,32k]
         * int takes 4 bytes of memory - values range is[-2B,2B]
         * long takes 8 bytes of memory - values range is [-2B,2B]
         * float takes 4 bytes of memory - values range is [-2B,2B]
         * double takes 8 bytes of memory - values range is [-2B,2B]
         * char takes 4 bytes of memory
         * boolean takes 1 byte of memory
         */

        byte myFatherAge = 30;
        // remember when adding a bigger number above 2B, 3_123_456_789,then the compiler fires a bug due to memory size allocation issue
        int viewsCount = 123_456_789;
        // Remember: by default java compiler only recognizes a decimal number as a double,
        // when using a float we need to tell the compiler to understand by adding F or f
        // But using F capital would make the code more readable!
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = false;

        // Slide #5: Reference Types - Examples date, mail message as objects -
        // We need to learn from IntellijSense & Tool Tip Box- to understand the built-in code organization:
        // packages, classes, and members(fields, and methods)
        // Example: Date is a class found in package: java.util
        // Memory is allocated and released by Java Runtime Environment
        // When Dealing with reference, we need to allocate memory
        // We need to understand how to navigate a java program code: classes, class members etc..
        // When using double quotes - the compiler understands it as it is

        Date now = new Date();
        System.out.println(now);

        // Slide #6: Primitive Types Vs Reference Types - Let's Understand First Primitive Data Types
        // Memory Management
        // Let's consider x and y parameters - inside an object
        // What do you think is the output??1 or 2

        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y);

        // Slider #7:Primitive Types Vs Reference Types - Let's Understand then Reference Data Types: Point(1,1)
        // Let's consider the address is the pointer memory is 100,
        // point 1 & point 2 are pointing to the same memory address
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        System.out.println(point2);

        // Slide #8: Primitive Types Vs Reference Types - Let's Understand String
        // Consider An example of a String Object.
        // Pay attention to the message:"New String Is Redundant!! Warning"
        String message = new String("Hello World");
        System.out.println(message);

        // Slide #9: Primitive Types Vs Reference Types - Let's Understand String
        String messageTwo = "Hello World";
        System.out.println(messageTwo);

        // Let's understand how to manipulate a string value using built-in method?
        String messageThree = "Hello World" + "!!";
        System.out.println(messageThree);

        // Let's apply use method:endsWith(string)
        System.out.println(messageThree.endsWith("!!"));

        // Let's apply use method:startsWith(string)
        System.out.println(messageThree.startsWith("!!"));

        // Let's apply use method:indeOf(string)
        System.out.println(messageThree.indexOf("!!"));

        // Let's apply use method:indeOf(string) - checking a different string pattern
        System.out.println(messageThree.indexOf("gilbert"));

        // Let's apply use method:replace(string) - checking a different string pattern
        // Remember - Strings are immutable!
        System.out.println(messageThree.replace("!", "*"));

        // Let's apply use method:toLowerCase();
        System.out.println(messageThree.toLowerCase());
        System.out.println(messageThree);

        //// Let's apply use method:trim() -
        // Remember - when you're collecting input from the user form -
        // all input from input fields is generally a string - how do you manipulate them when they contain spaces?
        System.out.println(messageThree.trim());
        System.out.println(messageThree);

        // Special Character - Let's understand escape sequences: "Hello "Gilbert" - do you see any error?;
        // Using the backslash we’ve escaped the double quotes:
        String messageFour = "Hello \" Gilbert";
        System.out.println(messageFour);

        // Another Example:
        String messageFive = "Hello \" Gilbert\"";
        System.out.println(messageFive);

        // Another Example: Root URL: C:\Windows\...
        String rootUrl = "c:\\Windows\\...";
        System.out.println(rootUrl);

        // Let's use new line \n
        String rootUrlTwo = "c:\nWindows\\...";
        System.out.println(rootUrlTwo);

        // Let's use Tab \n
        String rootUrlThree = "c:\tWindows\\...";
        System.out.println(rootUrlThree);

        // Slide #10: Primitive Types Vs Reference Types - Let's Understand Arrays
        // Primitive Number -int
        int number = 1;

        // Array Object - Reference Types -int array - do you see any error: requesting initialization? int[] numbers=1;
        // what if you add :numbers[10]=2;
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        // Returning Array memory address
        System.out.println(numbers);

        // Returning Array Values by using Arrays Class under java.util -
        // Did you check if this package has been imported??
        // In Java When Methods in one class have a similar method name but different parameter types,
        // this is called: Method Overloading!
        // Note, for fixed length array, we can use one of the collection classes- "Arrays" to view the value
        System.out.println(Arrays.toString(numbers));

        // When you know exactly the value before initialization you could use direct assignment?
        int[] arrayOfNumbers = {1, 2, 3, 4, 5, 1, 4};

        // Using Built Field: length to check the number of values inside an array:
        System.out.println(arrayOfNumbers.length);

        // Slide #11: Primitive Types Vs Reference Types - Let's Understand Multi-dimensional Arrays
        // Example: Data for queues, matrix, and scientific computations - Do you see any error when you assign:
        // another dimension: new int[2][3][5]
        int[][] mutliDimensionalArray = new int[2][3];

        // Returning Address value
        System.out.println(mutliDimensionalArray);

        // To Check the Value - we need to use deepToString Method inside Class: Arrays
        System.out.println(Arrays.deepToString(mutliDimensionalArray));

        // Let's Assign Some values:
        mutliDimensionalArray[0][0] = 1;

        // By Initialization
        int[][] mutliDimensionalArrayTwo = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(mutliDimensionalArrayTwo));

        // Slide #12: Constants
        // Variable can change – what about the constant?
        // Do you notice any error when trying to change the PI? pi=1
        // Remember by convention: constant should be written in CAPITAL CASE PI instead of pi
        final float PI = 3.14F;
        // pi=1

        // Slide #13: Arithmetic Expressions
        // What is an Arithmetic Expression? +*/ : and % - just a piece of code that produces value
        int result = 10 + 3;
        System.out.println(result);
        // Note - when you using division and data type :int, the result is always an integer with no decimal points?
        // What if you need decimal points?- Explicit Casting? do you any casting expression error:(double)10/3 or (double)10/(double)3;
        double resultTwo = (double) 10 / (double) 3;
        System.out.println(resultTwo);

        // Slide #14: Operands & Operators _ Increment and Decrement Operators -
        // using prefix
        int counter = 1;
        counter++;
        System.out.println(counter);

        // using postfix - is the result 1 or 2?
        int counterTwo = 1;
        int counterThree = counterTwo++;
        System.out.println(counterTwo);
        System.out.println(counterThree);

        // Using prefix - is the result 1 or 2?
        int counterFour = 1;
        int counterFive = ++counterFour;
        System.out.println(counterFour);
        System.out.println(counterFive);

        // Augmented or compiled assigned operators
        int counterSix = 1;
        counterSix = counterSix + 2;
        counterSix += 2;
        System.out.println(counterSix);

        // Slide #15: Order Of Operations
        // Note that - Multiplication and division have higher priority
        // In order to change the order - we need to use parenthesis
        // The order priority is: (), */ +-
        int counterSeven = 10 + 3 * 2;
        System.out.println(counterSeven);

        int counterEight = (10 + 3) * 2;
        System.out.println(counterEight);

        // Slide #16: Casting - Casting and type conversion
        // Just reflect? How many bytes do we have in a short variable?
        // Implicit casting - automatic casting -
        // Integer is less precise than a double
        short a = 1;
        int b = a + 2;
        System.out.println(b);

        // Explicit Casting
        // byte?>short>int>long>float>double
        double c = 1.1;
        double d = c + 2;//2.0
        System.out.println(d);

        // Explicit Casting
        // byte?>short>int>long>float>double
        // In case there is no tendency to lose any data?
        double e = 1.1;
        double f = c + 2;
        System.out.println(d);

        // If there is a possibility to lose some data points, we need to consider
        // to explicitly cast to the desired data type?
        // Remember - Only compatible types can be considered for casting
        double g = 1.1;
        int h = (int) c + 2;
        System.out.println(h);

        // Implicit Casting -
        // For Incompatible Types - Example: String to Number
        // We need to use primitive data types Wrapper Classes to cast.
        // Do you notice an error: int l=(int)i+2;
        // Do you find this relevant to when you collect user input from a web form??
        String i = "1.1";
        // int l=Integer.parseInt(i)+2; //Do you realize an error here?
        double k = Double.parseDouble(i) + 2;
        System.out.println(k
        );

        // Slide #17: Math Classes
        // In Java We have Math Class under Package:java.lang
        // Let's use Java Math Class Method: round()

        int resultFive = Math.round(1.1F);
        System.out.println(resultFive);

        // Let's use Java Math Class Method: ceil() - next possible value
        int resultSix = (int) Math.ceil(1.1F);
        System.out.println(resultSix);

        // Let's use Java Math Class Method: floor() - previous possible value
        int resultSeven = (int) Math.floor(1.1F);
        System.out.println(resultSeven);

        // Let's use Java Math Class Method: max() -
        int resultEight = Math.max(1, 2);
        System.out.println(resultEight);

        // Let's use Java Math Class Method: min() -
        int resultNine = Math.min(1, 2);
        System.out.println(resultNine);

        // Let's use Java Math Class Method: random() - returning value between 0 & 1
        double resultTen = Math.random();
        System.out.println(resultTen);

        // Let's use Java Math Class Method: random() - returning value between 1 & 100
        double resultEleven = Math.random() * 100;
        System.out.println(resultEleven);

        // Let's use Java Math Class Method: random() & Round()-
        double resultTwelve = Math.round(Math.random() * 100);
        System.out.println(resultTwelve);

        // Let's use Java Math Class Method: random() & Round() & cast the result to an int
        int resultThirteen = (int) Math.round(Math.random() * 100);
        System.out.println(resultThirteen);

        // Let's use Java Math Class Method: random() & Remove Round() & cast the result to an int
        int resultFourteen = (int) (Math.random() * 100);
        System.out.println(resultFourteen);

        // Slide #18: Formatting Numbers- $1,234,567 100%, Using Class: NumberFormat - under Java.text package
        // NumberFormat is abstract ?? What does that mean -
        // We're unable to instantiate any object from an abstract class using the new operator
        // We can use Factory Methods: NumberFormat.getCurrencyInstance()

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String resultFifteen = currency.format(123456.781);
        System.out.println(resultFifteen);

        // We can use Factory Methods: NumberFormat.getPercentInstance()
        // What is method chaining?
        NumberFormat percent = NumberFormat.getPercentInstance();
        String resultSixteen = percent.format(0.1);
        System.out.println(resultSixteen);

        // What is method chaining?
        String resultSeventeen = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(resultSeventeen);

        // Slide #19: Reading Input
        // how can we read input from the terminal, or other source: file, etc..
        // Let's understand which class that support reading user input
        // Let's read from terminal/console - to that - we're using a class Scanner from package: Java.util

        Scanner scanner = new Scanner(System.in);
        // Defining in which type are we receiving user input?
        // String
        // scanner.next();
        // byte
        System.out.println("Age:");
        byte myMomAge = scanner.nextByte();
        System.out.println("You're " + myMomAge);

        // What if A user passes in a decimal number?
        // Do you notice an error? and Why?

        // A user enters a name:
        // Reflect on whether a user adds spaces mixed with name?
        // How is the output processed? Only the first name is displayed
        Scanner scannerTwo = new Scanner(System.in);
        System.out.println("Name:");
        String name = scannerTwo.next();
        System.out.println("My Name: " + name);

        // A user enters a name:
        // Overcoming this--> How is the output processed? Only the first name is displayed
        Scanner scannerThree = new Scanner(System.in);
        System.out.println("Lastname:");
        String myLastName = scannerThree.nextLine();
        System.out.println("My Lastname: " + myLastName);

        

    }
}
```

## MortgageCalculator

```java
/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal: 100000
 * 2. Annual Interest Rates: 4.2
 * 3. Period(Years): 30
 * 4. Mortgage: $?
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    /**
     * Now It’s time for a small project:
     * Use what you’ve learned in the section and build a mortgage calculator
     * When we run this program we get a few questions:
     * Principal – Amount Of Loan We want to get – $ 100000
     * Annual Interest Rate: 3.92 will be divided by 100 then /12
     * Period(Years)- 30 to be * 12 – number of payments
     * Add Error Handling!!
     */
    public static void main(String... args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        Scanner scanner = new Scanner(System.in);

        // How Could We Add The Error handling??
        while (true) {
            System.out.println("Principal:");
            // The Scope Of variable principle should be declared outside the while block? Why?
            principal = scanner.nextInt();
            if (principal > 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter A Value Between 1000 and 1000000");
        }

        // How Can we Add The Error handling Here
        System.out.println("Annual Interest Rate:");
        float annualInterestRate = scanner.nextFloat();
        // We need to avoid any implicit value: 4,6 for code readability? Meaningful & Descriptive Words
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        // How can We Add The Error Handling Here?
        System.out.println("Period(Years):");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        // How can We Add The Error Handling Here?
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);

        // Challenge #2 - Let's increase the readability of this code
        // Does this program have a number of problems: Input validation???
        // What if You Pass Unexpected Input??String?? or negative values?
        // It's now time to use <<Conditional statement now come help us to solve this>>

        // Next Challenge: when codes start getting too long, it hurts the maintainability!
        // We need to convert the code into smaller and easier chunks using OOP.
        // Build On This Mortgage Calculator To Enhance The Code Using OOP Best Practices And SOLID Principles
    }
}






    
  
}

    
    
    
    
  
}
```