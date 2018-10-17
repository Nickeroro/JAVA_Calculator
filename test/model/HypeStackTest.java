package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HypeStackTest {

    private HypeStack stack;

    @BeforeEach
    void setUp() {
        this.stack = new HypeStack();
    }

    @AfterEach
    void tearDown() {
        this.stack = null;
    }

    @Test
    void pop() {
        assertThrows(IllegalStateException.class, ()->{this.stack.pop();});
        this.stack.push(3);
        this.stack.push("5");
        this.stack.push(ArithmeticOperator.MULTIPLY);
        assertEquals("x", this.stack.pop());
        assertEquals("5", this.stack.pop());
        assertEquals("3", this.stack.pop());
    }

    @Test
    void peek() {
        assertThrows(IllegalStateException.class, ()->{this.stack.peek();});
        this.stack.push(3);
        this.stack.push("5");
        this.stack.push(ArithmeticOperator.MULTIPLY);
        assertEquals("x", this.stack.peek());
        this.stack.pop();
        assertEquals("5", this.stack.peek());
        this.stack.pop();
        assertEquals("3", this.stack.peek());
    }

}