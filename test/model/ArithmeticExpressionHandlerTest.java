package model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticExpressionHandlerTest {

    @Test
    void isOperand() {
        assertTrue(ArithmeticExpressionHandler.isOperand("1"));
        assertTrue(ArithmeticExpressionHandler.isOperand("+1"));

        assertTrue(ArithmeticExpressionHandler.isOperand("23"));
        assertTrue(ArithmeticExpressionHandler.isOperand("+23"));

        assertTrue(ArithmeticExpressionHandler.isOperand("3399"));
        assertTrue(ArithmeticExpressionHandler.isOperand("+3399"));

        assertTrue(ArithmeticExpressionHandler.isOperand("-33"));
        assertTrue(ArithmeticExpressionHandler.isOperand("-9"));
        assertTrue(ArithmeticExpressionHandler.isOperand("-10005"));
        assertFalse(ArithmeticExpressionHandler.isOperand("+"));
        assertFalse(ArithmeticExpressionHandler.isOperand("-"));
        assertFalse(ArithmeticExpressionHandler.isOperand("x"));
        assertFalse(ArithmeticExpressionHandler.isOperand("/"));
        assertFalse(ArithmeticExpressionHandler.isOperand("%"));
        assertFalse(ArithmeticExpressionHandler.isOperand("="));
        assertFalse(ArithmeticExpressionHandler.isOperand("°%"));
        assertFalse(ArithmeticExpressionHandler.isOperand("a"));
        assertFalse(ArithmeticExpressionHandler.isOperand("+a"));
        assertFalse(ArithmeticExpressionHandler.isOperand("-a"));


    }


    @Test
    void isOperator() {
        assertFalse(ArithmeticExpressionHandler.isOperator("1"));
        assertFalse(ArithmeticExpressionHandler.isOperator("23"));
        assertFalse(ArithmeticExpressionHandler.isOperator("3399"));
        assertFalse(ArithmeticExpressionHandler.isOperator("-33"));
        assertFalse(ArithmeticExpressionHandler.isOperator("-9"));
        assertFalse(ArithmeticExpressionHandler.isOperator("-10005"));
        assertFalse(ArithmeticExpressionHandler.isOperator("-1"));
        assertFalse(ArithmeticExpressionHandler.isOperator("+1"));
        assertFalse(ArithmeticExpressionHandler.isOperator("+3399"));
        assertFalse(ArithmeticExpressionHandler.isOperator("a"));
        assertFalse(ArithmeticExpressionHandler.isOperator("+a"));
        assertFalse(ArithmeticExpressionHandler.isOperator("-a"));

        assertTrue(ArithmeticExpressionHandler.isOperator("+"));
        assertTrue(ArithmeticExpressionHandler.isOperator("-"));
        assertTrue(ArithmeticExpressionHandler.isOperator("x"));
        assertTrue(ArithmeticExpressionHandler.isOperator("/"));
        assertTrue(ArithmeticExpressionHandler.isOperator("%"));

    }

    @Test
    void tokenize() {
        LinkedList<String> results = new LinkedList<>();
        results.add("3");
        results.add("7");
        results.add("+");
        assertEquals(results, ArithmeticExpressionHandler.tokenize("3 7 +"));
        results = new LinkedList<>();
        results.add("3");
        results.add("7");
        results.add("+");
        assertEquals(results, ArithmeticExpressionHandler.tokenize(" 3   7  +  "));
        results = new LinkedList<>();
        results.add("-3");
        results.add("7");
        results.add("+");
        assertEquals(results, ArithmeticExpressionHandler.tokenize("-3 7 +"));
        results = new LinkedList<>();
        results.add("3");
        results.add("-7");
        results.add("x");
        assertEquals(results, ArithmeticExpressionHandler.tokenize("3 -7 x"));
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticExpressionHandler.tokenize("3 -7 &");
        });
    }
}