package view.console;


import control.InfixExpressionProcessor;

public class InfixSimpleConsole extends SimpleConsole {

    public InfixSimpleConsole() {
        super(new InfixExpressionProcessor());
    }

    public static void main(String[] args) {
        SimpleConsole console = new InfixSimpleConsole();
        console.start();
    }

    @Override
    protected void computeAndPrintResult() {
        try {
            this.processor.processExpression(this.lastInput);
            if (this.processor.hasResult()) {
                System.out.println(this.processor.getResult());
                this.processor.reset();
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception, that's exceptional!");
            e.printStackTrace();
        }
    }
}