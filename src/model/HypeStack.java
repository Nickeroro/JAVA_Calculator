package model;

import java.util.LinkedList;
import java.util.List;

public class HypeStack {

    private final List<String> internalList;

    public HypeStack(List<String> internalList) {
        this.internalList = internalList;
    }

    public HypeStack() {
        this(new LinkedList<>());
    }

    public void push(String string) {
        this.internalList.add(string);
    }

    public void push(ArithmeticOperator operator) {
        push(operator.toString());
    }

    public void push(int operand) {
        push(Integer.toString(operand));
    }

    public String pop() {
        if (this.internalList.isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }
        return this.internalList.remove(this.internalList.size() - 1);
    }

    public String peek() {
        if (this.internalList.isEmpty()) {
            throw new IllegalStateException("Empty stack");
        }
        return this.internalList.get(this.internalList.size() - 1);
    }

    public ArithmeticOperator popOperator() {
        return ArithmeticOperator.fromString(this.pop());
    }

    public int popInt() {
        return Integer.valueOf(this.pop());
    }

    public int size() {
        return this.internalList.size();
    }

    public void clear() {
        this.internalList.clear();
    }

    public void delete() {
        this.pop();
    }

    public boolean isEmpty() {
        return this.internalList.isEmpty();
    }

    @Override
    public String toString() {
        return this.internalList.toString();
    }
}
