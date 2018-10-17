package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNArithmeticProcessorTest {

    private RPNArithmeticProcessor processor;

    @BeforeEach
    void setUp() {
        this.processor = new RPNArithmeticProcessor();
    }

    @AfterEach
    void tearDown() {
        this.processor = null;
    }

    @Test
    void processNextToken() {
        this.processor.processNextToken("-5");
        this.processor.processNextToken("8");
        this.processor.processNextToken("+");
        assertEquals("3", this.processor.getStack().peek());
        this.processor.processNextToken("5");
        this.processor.processNextToken("x");
        assertEquals("15", this.processor.getStack().peek());
        this.processor.processNextToken("5");
        this.processor.processNextToken("-");
        assertEquals("10", this.processor.getStack().peek());
        this.processor.processNextToken("10");
        this.processor.processNextToken("/");
        assertEquals("1", this.processor.getStack().peek());
        this.processor.processNextToken("-21");
        this.processor.processNextToken("x");
        assertEquals("-21", this.processor.getStack().peek());
        this.processor.processNextToken("17");
        this.processor.processNextToken("%");
        assertEquals("-4", this.processor.getStack().peek());
        this.processor.processNextToken("-3");
        this.processor.processNextToken("%");
        assertEquals("-1", this.processor.getStack().peek());
        this.processor.processNextToken("-31");
        this.processor.processNextToken("x");
        assertEquals("31", this.processor.getStack().peek());
        this.processor.processNextToken("21");
        this.processor.processNextToken("%");
        assertEquals("10", this.processor.getStack().peek());
        assertThrows(IllegalStateException.class, () -> {
            this.processor.processNextToken("/");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.processor.processNextToken("@");
        });
    }
}