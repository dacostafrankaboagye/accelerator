package amalitech;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class JavaTypes {

    /**
     * 1. Variables and Constants
     * 2. Primitive and Reference Types
     * 3. Casting
     * 4. Numbers, Strings and Arrays
     * 5. Read Input
     * 6. Build A mortgage calculator on your own
     * 7. Pay Attention!! Are you ready!!
     */
    public static void main(String...args){
        //Slide #1
        //Topic "variables"
        //Variables Declaration & Assignment
        //Remember you can assign variables in one line as well: int age=30,temperature=20
        int age=30;//in the machine memmory the jvm allocates 4 bytes
        //byte myFatherAge=30;//the best
        //Assign a new number to check if the number in the memory changes
        age=35;
        System.out.println(age);

        //Slide #2:
        int myAge=30;
        int herAge=myAge;
        System.out.println(herAge);

        //Slide #3: Primitive Types - Stores Simple Values - Reference Type Stores Complex Objects
        /**
         * byte takes 1 byte of memory-values range is [-127,127]
         * short takes 2 bytes of memory - values range is[-32k,32k]
         * int takes 4 bytes of memory - values range is[-2B,2B]
         * long takes 8 bytes of memory - values range is [-2B,2B]
         * float takes 4 bytes of memory - values range is [-2B,2B]
         * double takes 8 bytes of memory - values range is [-2B,2B]
         * char takes 2 bytes of memory
         * boolean takes 1 byte of memory
         */

        byte myFatherAge=12;
        //remember when adding a bigger number above 2B, 3_123_456_789,then the compiler fires a bug due to memory size allocation issue
        int viewsCount=123_456_789;
        //Remember: by default java compiler only recognizes a decimal number as a double, when using a float we need to tell the compiler to understand by adding F or f
        //But usng F capital would make the code more readable!
        float price=10.99F;
        char letter='A';
        boolean isEligible=false;

        //Slide #5: Reference Types - Examples date, mail message as objects -
        // We need to learn from IntellijSense & Tool Tip Box- to understand the built-in code organization: packages, classes, and members(fields, and methods)
        //Example: Date is a class found in package: java.util
        //Memory is allocated and released by Java Runtime Environment
        //When Dealing with reference, we need to allocate memory
        //We need to understand how to navigate a java program code: classes, class members etc..
        //When using double quotes - the compiler understands it as it is

        Date now=new Date();
        System.out.println("now");

        //Slide #6: Primitive Types Vs Reference Types - Let's Understand First Primitive Data Types
        //Memory Management
        //Let's consider x and y  parameters - inside an object
        //What do you think is the output??1 or 2

        byte x=1;
        byte y=x;
        x=2;
        System.out.println("Checking The Value In Y:"+y);
       System.out.println("Checking The Value In Y:"+x);
       // Slider #7:Primitive Types Vs Reference Types - Let's Understand then Reference Data Types: Point(1,1)
        //Let's consider the address is the pointer memory is 100, point 1 & point 2 are pointing to the same  memory address
       Point point1 =new Point(1,1);
       Point point2=point1;//Here when we assign point 1 to point 2 we're actu
       point1.x=2;

       System.out.println("Checking Point 2 Data:"+point2);

        //Slide #8: Primitive Types Vs Reference Types - Let's Understand String
        //Consider An example of a String Object. Pay attention to the message:"New String Is Redundant!! Warning"
        String message=new String("Hello World");
        System.out.println(message);

        //Slide #9: Primitive Types Vs Reference Types - Let's Understand String
        String messageTwo="Hello World";
        System.out.println(messageTwo);

        //Let's understand how to manipulate a string value using built-in method?
        String messageThree="Hello World"+"!!";
        System.out.println(messageThree);

        //Let's apply use method:endsWith(string)
        System.out.println(messageThree.endsWith("!!"));

        //Let's apply use method:startsWith(string)
        System.out.println(messageThree.startsWith("!!"));

        //Let's apply use method:indeOf(string)
        System.out.println(messageThree.indexOf("!!"));

        //Let's apply use method:indeOf(string) - checking a different string pattern
        System.out.println(messageThree.indexOf("gilbert"));

        //Let's apply use method:replace(string) - checking a different string pattern
        //Remember - String are immutable!
        System.out.println(messageThree.replace("!","*"));

        //Let's apply use method:toLowerCase();
        System.out.println(messageThree.toLowerCase());
        System.out.println(messageThree);

        ////Let's apply use method:trim() -
        //Remember - when you're collecting input from the user form -
        //all input from input fields are generally string - how do you manipulate them when they contain spaces?
        System.out.println(messageThree.trim());
        System.out.println(messageThree);

        //Special Character - Let's understand escape sequences: "Hello "Gilbert" - do you see any error?;
        //Using the back slach we’ve escaped the double quotes:
        String messageFour="Hello \" Gilbert";
        System.out.println(messageFour);

        //Another Example:
        String messageFive="Hello \" Gilbert\"";
        System.out.println(messageFive);

        //Another Example:Root URL: C:\Windows\...
        String rootUrl="c:\\Windows\\...";
        System.out.println(rootUrl);

        //Let's use new line \n
        String rootUrlTwo="c:\nWindows\\...";
        System.out.println(rootUrlTwo);

        //Let's use Tab \n
        String rootUrlThree="c:\tWindows\\...";
        System.out.println(rootUrlThree);

        //Slide #10: Primitive Types Vs Reference Types - Let's Understand Arrays
        //Primitive Number -int
        int number=1;

        //Array Object - Reference Types -int array - do you see any error: requesting initialization? int[] numbers=1; what if you add :numbers[10]=2;

        int[] numbers=new int[5];
        numbers[0]=1;
        numbers[1]=2;
        //Returning Array memory address
        System.out.println(numbers);

        //Returning Array Values by using Arrays Class under java.util - Did you check if this package has been imported??
        //In Java When Methods in one class have similar method name but different parameters types, this is called: Method Overloading!
        //Note, for fixed  length array, we can use one of the collection classes- "Arrays" to view the value
        System.out.println(Arrays.toString(numbers));

        //When you know exactly the value before initialization you could use direct assignment?
        int[] arrayOfNumbers={1,2,3,4,5,1,4};

        //Using Built Field: length to check the number of value inside an array:

        System.out.println(arrayOfNumbers.length);

        //Slide #11: Primitive Types Vs Reference Types - Let's Understand Multi-dimensional Arrays
        //Example: Data for qeues, matrix, and scientific computations - Do you see any error when you assign:another dimension:new int[2][3][5]

        int [][] mutliDimensionalArray=new int[2][3];

        //returning Address value
        System.out.println(mutliDimensionalArray);

        //To Check the Value - we need to use deeptoString Method inside Class: Arrays
        System.out.println(Arrays.deepToString(mutliDimensionalArray));

        //Let's Assign Some values:
        mutliDimensionalArray[0][0]=1;

        //By Initialization
        int [][] mutliDimensionalArrayTwo={{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(mutliDimensionalArrayTwo));

        //Slide #12: Constants
        //Variable can change – what about the constant? do you notice any error when trying to change the PI?pi=1
        //Remember by convention: constant should be written in CAPITAL CASE PI instead of pi

        final float PI=3.14F;

        //pi=1

        //Slide #13: Arithmetic Expressions
        //What is an Arithmetic Expression? +*/ : and % - just a piece of code that produces value
        int result =10+3;
        System.out.println(result);
        //Note - when you usng division and data type :int, the result is always an integer with no decimal points?
        //What if you need a decimal points?- Explicit Casting? do you any casting expresion error:(double)10/3 or (double)10/(double)3;
        double resultTwo=(double)10/(double)3;
        System.out.println(resultTwo);

        //Slide #14: Operands & Operators _ Increment and Decrement Operators -
        // using prefix
        int counter=1;
        counter++;
        System.out.println(counter);

        // using postfix - is the result 1 or 2?
        int counterTwo=1;
        int counterThree=counterTwo++;

        System.out.println(counterTwo);
        System.out.println(counterThree);

        //Using prefix - is the result 1 or 2?
        int counterFour=1;
        int counterFive=++counterFour;

        System.out.println(counterFour);
        System.out.println(counterFive);

        //To be Continued in the next Session
        //Augmented or compiled assigned operators
        int counterSix=1;
        counterSix=counterSix+2;
        counterSix+=2;
        System.out.println(counterSix);

       //Slide #15: Order Of Operations
        // Note that - Multiplication and division have higher priority
        //In order to change the order - we need to use paranthesis
        //The order priority is : (), */ +-

        int counterSeven=10+3*2;
        System.out.println(counterSeven);

        int counterEight=(10+3)*2;
        System.out.println(counterEight);

        //Slide #16: Casting - Casting and type conversion
        //Just reflect?How many bytes do we have in a short variable?
        //Implicit casting - automatic casting -
        //Integer is less precise than a double
        short a=1;
        int b=a+2;
        System.out.println(b);

        //Explicit Casting
        //byte?>short>int>long>float>double
        double c=1.1;
        double d=c+2;//2.0
        System.out.println(d);

        //Explicit Casting
        //byte?>short>int>long>float>double
        //In case there is no tendency to lose any data?

        double e=1.1;
        double f=c+2;
        System.out.println(d);

        //If there is possibility to lose some data points, we need to consider
        //to explicitly cast to the desired data type?
        //Remember - Only compatible types can be considered for casting

        double g=1.1;
        int h=(int)c+2;
        System.out.println(h);

        //Implicit Casting -
        //For Incompatible Types - Example: String to Number
        //We need to use primitive data types Wrapper Classes to cast. Do you notice an error:int l=(int)i+2;
        //Do you find this relevant to when you collect user input from web form??
        String i="1.1";
        //int l=Integer.parseInt(i)+2; //Do you realize an error here?
        double k=Double.parseDouble(i)+2;
        System.out.println(k);

        //Slide #17: Math Classes
        //In Java We have Math Class under Package:java.lang
        //Let's use Java Math Class Method: round()

        int resultFive=Math.round(1.1F);
        System.out.println(resultFive);

        //Let's use Java Math Class Method: ceil() - next possible value
        int resultSix=(int)Math.ceil(1.1F);
        System.out.println(resultSix);

        //Let's use Java Math Class Method: floor() - previous possible value
        int resultSeven=(int)Math.floor(1.1F);
        System.out.println(resultSeven);


        //Let's use Java Math Class Method: max() -
        int resultEight=Math.max(1,2);
        System.out.println(resultEight);

        //Let's use Java Math Class Method: min() -
        int resultNine=Math.min(1,2);
        System.out.println(resultNine);

        //Let's use Java Math Class Method: random() - returning value between 0 & 1
        double resultTen=Math.random();
        System.out.println(resultTen);


        //Let's use Java Math Class Method: random() - returning value between 1 & 100
        double resultEleven=Math.random()*100;
        System.out.println(resultEleven);

        //Let's use Java Math Class Method: random() & Round()-
        double resultTwelve=Math.round(Math.random()*100);
        System.out.println(resultTwelve);

        //Let's use Java Math Class Method: random() & Round() & cast the result to an int
        int resultThirteen=(int)Math.round(Math.random()*100);
        System.out.println(resultThirteen);

        //Let's use Java Math Class Method: random() & Remove Round() & cast the result to an int
        int resultFourteen=(int)(Math.random()*100);
        System.out.println(resultFourteen);

      //Slide #18: Formatting Numbers- $1,234,567  100%, Using Class: NumberFormat - under Java.text package
        //NumberFormat is abstract ?? What does that mean -
        //We're unable to instantiate any object from an abstract class using new operator
        //We can use Factory Methods: NumberFormat.getCurrencyInstance()

        NumberFormat currency=NumberFormat.getCurrencyInstance();
        String resultFifteen=currency.format(123456.781);
        System.out.println(resultFifteen);

        //We can use Factory Methods: NumberFormat.getPercentInstance()
        //What is method chaining?
        NumberFormat percent=NumberFormat.getPercentInstance();
        String resultSixteen=percent.format(0.1);
        System.out.println(resultSixteen);

        //What is method chaining?
        String resultSeventeen=NumberFormat.getPercentInstance().format(0.1);
        System.out.println(resultSeventeen);

        //Slide #19: Reading Input
        //how can we read input from terminal, or other source: file, etc..
        //Let's understand which class that support reading user input
        //Let's read from terminal/console - to that - we're using a class Scanner from package : Java.util

        Scanner scanner=new Scanner(System.in);
        //Defining in which type are we receiving user input?
        //String
        //scanner.next();
        //byte
        System.out.println("Age:");
        byte myMomAge=scanner.nextByte();
        System.out.println("You're "+myMomAge);

        //What if A user pass in a decimal number?
        // Do you notice an error? and Why?

        //A user enters a name:
        //Reflect on whether a user add spaces mixed with name? How is the output processed?Only  the first name is displayed
        Scanner scannerTwo=new Scanner(System.in);
        System.out.println("Name:");
        String name=scannerTwo.next();
        System.out.println("My Name: "+name);


        //A user enters a name:
        //Overcomming this--> How is the output processed?Only  the first name is displayed
        Scanner scannerThree=new Scanner(System.in);
        System.out.println("Lastname:");
        String myLastName=scannerThree.nextLine();
        System.out.println("My Lastname: "+myLastName);

        System.out.println("");




























































































































    }


}
