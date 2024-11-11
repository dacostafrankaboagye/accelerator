# Brainstorming & Solutions
- [fizzbuzz ](#fizzbuzzchallenge)
- [mortgage calculator](#mortgagecalculator)
- [mortgage calculator challenge 2](#mortgagecalculator-challenge-2)
- [Additional Comments](#additional-comments)
- [Acquired Skills](#acquired-skills)


## FizzBuzzChallenge

#### <u> Example #1: What specific problem are in this code? </u>

The condition checking order is incorrect.

It should check for "FizzBuzz" first
because numbers divisible by both 3 and 5 will match 
`number % 5 == 0` and `number % 3 == 0`
before reaching `number % 5 == 0 && number % 3 == 0`.

```java

else if (number % 5 == 0 && number % 3 == 0) 
     // This condition is not going to execute.
    
```

#### <u> Example #2: How can we improve this code? </u>
Place the most specific condition at the top and the most generic at the bottom.

And Yes!. By doing so, we prevent any overlapping conditions and improve readability.

#### <u> Can we apply DRY (Don't Repeat Yourself) principle? </u>
Yes!!, by creating a reusable method that handles the FizzBuzz logic once.
[FizzBuzzChallengeSolution.java](FizzBuzzChallengeSolution.java)

## MortgageCalculator

#### <u>How Could We Add Error Handling? - Principal</u>
Use a loop to prompt for valid input repeatedly until a 
valid principal is entered.
This prevents the program from crashing with unexpected input 
(e.g., non-numeric or out-of-range values).


#### <u>The Scope Of variable principal should be declared outside the while block? Why? </u>
Variables declared inside a block (like `{ }` in the `while` loop)
are limited to that block's scope and are not accessible outside of it.
Declaring `principal` outside the `while` loop ensures that it can be accessed later in the program
(after the loop ends).


#### <u>How Can We Add Error Handling Here? - Rate</u>
Validate annual interest rate input to ensure it's a 
positive float and within a reasonable range.

#### <u> How Can We Add Error Handling Here? - Years</u>
We have to ensure `years` input is a positive number 
within a reasonable range (e.g., 1 to 100).

## MortgageCalculator challenge 2

Main logic is divided into methods such as 
- `getPrincipal`
- `getAnnualInterestRate`
- `getYears`, and 
- `calculateMortgage`. 

I also created a Loan class to encapsulate loan-related data and calculations, 
which enhances the modularity and maintainability of the code.

[Challenge2/MortgageCalculator.java](Challenge2/MortgageCalculator.java)

#### Additional Comments
We could have done something like this for the Error handling for mortgage calculation

```java
double mortgage;
try {
    if (monthlyInterest == 0) {
        throw new ArithmeticException("Monthly interest rate cannot be zero.");
    }
    mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
               (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
} catch (ArithmeticException e) {
    System.out.println("Error in mortgage calculation: " + e.getMessage());
    return;  // Exit the program if calculation fails
}


```

## Acquired Skills
- Input Validation
- Code Modularity
- Use of Constants
- Error Prevention
- Design Principles
- Formatting

