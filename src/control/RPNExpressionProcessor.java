package control;

import model.ArithmeticExpressionHandler;
import model.RPNArithmeticProcessor;

public class RPNExpressionProcessor implements ExpressionProcessor {

    protected final RPNArithmeticProcessor processor;

    public RPNExpressionProcessor() {
        processor = new RPNArithmeticProcessor();
    }


    @Override
    public void processExpression(String exp) {
        try {
            for (String token : ArithmeticExpressionHandler.tokenize(exp))
                this.processor.processNextToken(token);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown token : " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Content of the stack : " + this.processor.getStack());
        } catch (IllegalStateException ex) {
            System.out.println("Content of the stack : " + this.processor.getStack() + " ... to continue");
        }
    }

    @Override
    public boolean hasResult() {
        return this.processor.hasResult;
    }

    @Override
    public int getResult() {
        return Integer.valueOf(this.processor.getStack().peek());
    }

    @Override
    public void reset() {
        this.processor.reset();
    }
}
