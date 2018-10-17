package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticOperatorTest {

    @Test
    void getSymbol() {
        assertEquals("+", ArithmeticOperator.PLUS.getSymbol(), "+ operator symbol");
        assertEquals("-", ArithmeticOperator.MINUS.getSymbol(), "- operator symbol");
        assertEquals("x", ArithmeticOperator.MULTIPLY.getSymbol(), "x operator symbol");
        assertEquals("/", ArithmeticOperator.DIVIDE.getSymbol(), "/ operator symbol");
        assertEquals("%", ArithmeticOperator.MODULO.getSymbol(), "% operator symbol");
    }

    @Test
    void getPriority() {
        assertEquals(1, ArithmeticOperator.PLUS.getPriority(), "+ operator priority");
        assertEquals(1, ArithmeticOperator.MINUS.getPriority(), "- operator priority");
        assertEquals(2, ArithmeticOperator.MULTIPLY.getPriority(), "x operator priority");
        assertEquals(2, ArithmeticOperator.DIVIDE.getPriority(), "/ operator priority");
        assertEquals(3, ArithmeticOperator.MODULO.getPriority(), "% operator priority");
    }

    @Test
    void fromString() {
        assertEquals(ArithmeticOperator.PLUS, ArithmeticOperator.fromString("+"), "+ operator from String");
        assertEquals(ArithmeticOperator.MINUS, ArithmeticOperator.fromString("-"), "- operator from String");
        assertEquals(ArithmeticOperator.MULTIPLY, ArithmeticOperator.fromString("x"), "x operator from String");
        assertEquals(ArithmeticOperator.DIVIDE, ArithmeticOperator.fromString("/"), "/ operator from String");
        assertEquals(ArithmeticOperator.MODULO, ArithmeticOperator.fromString("%"), "% operator from String");
    }

}