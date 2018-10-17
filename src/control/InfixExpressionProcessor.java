package control;

import model.ArithmeticExpressionHandler;

public class InfixExpressionProcessor extends RPNExpressionProcessor  {

    public InfixExpressionProcessor() {
        super();
    }

    @Override
    public void processExpression(String exp) {
        String convertedExp = "";
        try {
            convertedExp = ArithmeticExpressionHandler.convertInfix2RPN(exp);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        if (convertedExp.length() > 0) {
            try {
                for (String token : ArithmeticExpressionHandler.tokenize(convertedExp))
                    this.processor.processNextToken(token);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown token : " + e.getMessage());
            }
        }
    }

}