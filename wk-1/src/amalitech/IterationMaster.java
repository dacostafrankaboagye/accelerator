package amalitech;

import java.util.Scanner;

public class IterationMaster {
    public static  void main(String...args){
        //Slide #30: For Loops

        //Example #1:
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        //Example #2: Using For Loop - having A prio Knowledge on the number of iteration??
        for(int i=0;i<=5;i++){
            System.out.println("Hello World:"+i);
        }


        //Example #2: Using For Loop - having A prio Knowledge on the number of iteration?? Reverse Order
        for(int i=5;i>0;i--){
            System.out.println("Hello World:"+i);
        }

        //Slide #31: While Loops
        String input="";
        Scanner scanner=new Scanner(System.in);
        while(!input.equals("quit")){
            //10 scanner in our memeroy do pollute our memory – bad practices??
            System.out.println("Input:");
            //Scanner scanner=new Scanner(System.in);
            //When a client input UPPER Value??
            input=scanner.next().toLowerCase();
            System.out.println(input);
        }

        //Slide #32: Do While Loops
        String inputTwo="";
        do{
            Scanner scannerTwo=new Scanner(System.in);
            //When a client input UPPER Value??
            inputTwo=scannerTwo.next().toLowerCase();
            System.out.println(inputTwo);

        }while(!inputTwo.equals("quit"));

        //Slide #33: Break & Continue

        String inputThree="";
        Scanner scannerThree=new Scanner(System.in);
        while(true){
            //X scanner in our memory do pollute our memory – bad practices??
            System.out.println("Input:");
            //Scanner scanner=new Scanner(System.in);
            //When a client input UPPER Value??
            inputThree=scannerThree.next().toLowerCase();
            if(inputThree.equals("pass"))
                continue;
            if(inputThree.equals("quit"))
                break;
            System.out.println(input);
        }

        //Slide #34: For Each Loop
        String[] fruits={"Apple","Mango","Orange"};

        //Example #1: Using For Loop
        for(int i=0;i<fruits.length;i++){
            System.out.println("Fruit:"+fruits[i]);
        }

        for(String fruit:fruits){
            System.out.println(fruit);
        }









    }
}
