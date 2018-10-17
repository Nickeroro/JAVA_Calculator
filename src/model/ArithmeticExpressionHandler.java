package model;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public final class ArithmeticExpressionHandler {

    /**
     * Utility, static methods to handle arithmetic expressions and tokens.
     * <p>
     * The class itself is declared final with a private constructor so
     * it can't be instantiated nor extended.
     */
    private ArithmeticExpressionHandler() {
    }

    static public boolean isOperator(String token) {
        return token.matches("[-\\+x/%]");
    }

    static public boolean isOperand(String token) {
        return token.matches("[-\\+]?[0-9]+");
    }

    static public List<String> tokenize(String arithmeticExpression) {
        final List<String> result = new LinkedList<>();
        String[] toTokenize = arithmeticExpression.trim().split("\\s+");
        for (String token : toTokenize){
            if (ArithmeticExpressionHandler.isOperator(token) || ArithmeticExpressionHandler.isOperand(token))
                result.add(token);
            else
                throw  new IllegalArgumentException(token);
        }
        return result;
    }

    static public String convertInfix2RPN(String exp) {

        Stack<ArithmeticOperator> operatorStack = new Stack<>();
        List<String> outputTokenList = new LinkedList<>();

        for (String token : tokenize(exp)) {
            // Token is an operand (int)
            if (isOperand(token)) {
                outputTokenList.add(token);
            }
            // Token is an operator
            else if (isOperator(token)) {
                ArithmeticOperator operator = ArithmeticOperator.fromString(token);
                if (operatorStack.isEmpty() || (operator.getPriority() > operatorStack.peek().getPriority()))
                    operatorStack.push(operator);
                else {
                    while (!operatorStack.isEmpty() && operator.getPriority() <= operatorStack.peek().getPriority()) {
                        outputTokenList.add(operatorStack.pop().toString());
                    }
                    operatorStack.push(operator);
                }
            }
            // Token is illegal (not an operand nor an operator)
            else {
                throw new IllegalArgumentException("Could not recognize token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputTokenList.add(operatorStack.pop().toString());
        }
        //System.out.println(outputTokenList);

        if (outputTokenList.size() < 3)
            throw new IllegalStateException("This is an incomplete or false infix expression !");

        StringBuilder output = new StringBuilder();
        for (String token : outputTokenList) {
            output.append(token).append(" ");
        }

        return output.toString().trim();
    }
}
