package amalitech;

/**
 * Key Things To Know at Foundational Core Java Level:
 * 1. Comparison Operators
 * 2. Logical Operators
 * 3. Conditional Statement
 * 4. Loops
 *
 * */
public class ControlFlows {

    public static  void main(String...args){
        //Slide #20:Let's dive into Conditional Operators
        //Bolean operation & inequality operation
        //Are we comparing x & y here?
        int x=1;
        int y=1;
        System.out.println(x==y);

        //Are we comparing x & y here?
        System.out.println(x!=y);
        System.out.println(x<y);

        //Slide #21:Logical Operators
        int a=1;
        int b=2;
        System.out.println(a<=b);

        int temperature=12;
        boolean isWarm=temperature>20 && temperature <30;
        System.out.println(isWarm);

        boolean hasHighIncome=false;
        boolean hasGoodCredit=true;
        //boolean isEligible= hasHighIncome || hasGoodCredit;

        //Let's add another variable: hasCriminalRecord
        boolean hasCriminalRecord=false;
        boolean isEligible= (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        System.out.println(isEligible);


        //Slide #22:If Statement
        /**
         * Pseudocode - Algorithm -Problem Solving
         * 1. If temp is greater than 30
         * it's a hot day
         * Drink plenty of water
         * Otherwise, if it's been 20 and 30
         * It's a nice day
         * Otherwise
         * It's cold
         * */
        int temp=32;

        if(temp>30) {
            System.out.println("It's a hot day");
            System.out.println("Drink Water");
            //We can remove : && temp<=30
        }else if(temp>20){
            System.out.println("Beautiful Day");
        }else{
            System.out.println("Cold Day");
        }

        //Slide #23:Simplifying If Statement
        //Any observed Error - Declaration is not Allowed under a function?
        int income=120_000;
        //How Can we Improve the code as Professional Developer??
        //Add an initial value

        boolean hasHigherIncome=income>100_000;

        /*
        //Remove this code for better clean
        if(income>100_000)
            hasHigherIncome=true;
         */
        /*
        remove this for unnecessary code
        else
            hasHigherIncome=false;
            */

        //System.out.println(hasHigherIncome); What is a variable scope???

        //Can we improve the code using ternary operation??
        //Example:#1
        int incomeTwo=120_000;
        String className;
        if(incomeTwo>100_000)
            className="First";
        else
            className="Economy";

        //Example:#1
        int incomeThree=120_000;
        String classNameTwo="Economy";
        if(incomeThree>100_000)
            classNameTwo="First";

        //Example:#2
        int incomeFour=120_000;
        String classNameFour=incomeThree>100_000?"First":"Economy";

        //Slide #24:Switch Statement
        //Example #1:
        String role="Admin";
        if(role=="Admin"){
            System.out.println("You're An Admin");
        }else if(role=="Moderator"){
            System.out.println("You're An Administrator");
        }else{
            System.out.println("You're A guest");
        }

        //Example #2:

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
}
