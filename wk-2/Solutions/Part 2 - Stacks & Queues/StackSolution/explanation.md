* I added an option to resize, when it is necessary to do so
* Stack methods - `push`, `pop`, `peek`, `runResizeLogic`
* For the calculator
  - I had a postfix expression evaluator
  - some methods you can find are: 
    - `isOperator` : The idea is to pop two elements out of the stack when this is true, in the `evaluatePostfix`
    - `performOperation` : this is where the arithmetic operation is done

```java

For the postfix expression "5 3 + 2 *":

/>> Push 5 and 3 onto the stack.
/>> Encounter the + operator:
    Pop 3 and 5, compute 5 + 3 = 8, and push 8.
/>> Push 2 onto the stack.
/>> Encounter the * operator:
    Pop 2 and 8, compute 8 * 2 = 16, and push 16.
The final result is 16.0.
```