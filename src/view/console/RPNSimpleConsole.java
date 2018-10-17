package view.console;


import control.RPNExpressionProcessor;

public class RPNSimpleConsole extends SimpleConsole {

    public RPNSimpleConsole() {
        super(new RPNExpressionProcessor());
    }

    public static void main(String[] args) {
        SimpleConsole console = new RPNSimpleConsole();
        console.start();
    }

    @Override
    protected void computeAndPrintResult() {
        try {
            this.processor.processExpression(this.lastInput);
            if (this.processor.hasResult()) {
                System.out.println(this.processor.getResult());
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception, that's exceptional!");
            e.printStackTrace();
        }
    }
}