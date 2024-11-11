import java.util.Scanner;

public class Calculator {

    public static double evaluatePostfix(String expression) {
        MyStack stack = new MyStack();
        String[] tokens = expression.split(" ");
        for(String token : tokens){
            if(isOperator(token)){
                double operand2 = (double) stack.pop();
                double operand1 = (double) stack.pop();
                double result = performOperation(operand1, operand2, token);

                stack.push(result);

            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return (double) stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static String getPostfixExpressionFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (separate operands and operators by spaces):");
        String expression = scanner.nextLine().trim();

        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        return expression;
    }

    public static void main(String[] args) {
        // String expression = "5 3 + 2 *";
        String expression = getPostfixExpressionFromUser();
        double result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }
}