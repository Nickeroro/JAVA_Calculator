package view.console;

import control.ExpressionProcessor;

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class SimpleConsole {

    protected final ExpressionProcessor processor;
    protected String lastInput;
    private Scanner scanner;

    public SimpleConsole(ExpressionProcessor processor) {
        this.scanner = new Scanner(System.in);
        this.scanner.useDelimiter("\n");
        this.processor = processor;
    }

    public void start() {
        while (getInput()) {
            if (lastInput.trim().toLowerCase().equals("quit")) break;
            if (lastInput.trim().toLowerCase().equals("reset")) this.processor.reset();
            computeAndPrintResult();
        }
    }

    private boolean getInput() {
        System.out.print("\n> ");
        try {
            this.lastInput = this.scanner.next();
            return true;
        } catch (IllegalStateException | NoSuchElementException ex) {
            System.out.println("Can't read line !");
            return false;
        }
    }

    protected abstract void computeAndPrintResult();

}


