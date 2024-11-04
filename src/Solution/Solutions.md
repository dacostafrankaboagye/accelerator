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