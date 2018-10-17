package model;

public class RPNArithmeticProcessor {

    private HypeStack stack;
    public boolean hasResult;

    public RPNArithmeticProcessor(HypeStack stack) {
        this.stack = stack;
        this.hasResult = false;
    }

    public RPNArithmeticProcessor() {
        this(new HypeStack());
    }

    public HypeStack getStack() {
        return this.stack;
    }

    public void reset(){
            this.getStack().clear();
            this.hasResult = false;
    }

    public int compute() { // pile avec au sommet un operateur
        ArithmeticOperator operator = ArithmeticOperator.fromString(this.stack.pop());
        int rhs = this.stack.popInt(); //right hand style
        int lhs = this.stack.popInt(); //left hand style
        int result = 0;
        switch (operator) {
            case PLUS:
                result = lhs + rhs;
                break;
            case MINUS:
                result = lhs - rhs;
                break;
            case MULTIPLY:
                result = lhs * rhs;
                break;
            case DIVIDE:
                result = lhs / rhs;
                break;
            case MODULO:
                result = lhs % rhs;
                break;
        }
        return result;
    }

    public void processNextToken(String tk) {
        //si operande on empile
        //si operateur
            //sommet doit etre nombre
            //si la taille de la pile > 1
        //alors j'appelle processNextToken(compute()) #recurcivite
        if (ArithmeticExpressionHandler.isOperand(tk))
            this.stack.push(tk);
        else {
            if (ArithmeticExpressionHandler.isOperator(tk) && this.stack.size() > 1 && ArithmeticExpressionHandler.isOperand(this.stack.peek())) {
                this.stack.push(tk);
                this.processNextToken(String.valueOf(this.compute()));
            }
            else {
                throw new IllegalArgumentException("Check the token (might be invalid) \n" +
                        "Check if the stack is superior to 2 \n" +
                        "Check is the stack peek is an operand not an orperator");
            }
        }
    }
}