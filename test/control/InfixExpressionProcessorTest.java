package control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfixExpressionProcessorTest {

    private InfixExpressionProcessor processor;

    @BeforeEach
    void setUp() {
        this.processor = new InfixExpressionProcessor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void processExpression() {
        this.processor.processExpression("5 - 4");
        assertEquals(1, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 + 4");
        assertEquals(9, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 x 4");
        assertEquals(20, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 / 4");
        assertEquals(1, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 x 4 / 4");
        assertEquals(5, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-5 x 4 / 4");
        assertEquals(-5, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("4 - 8 x -5");
        assertEquals(44, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-4 - 8 x 5");
        assertEquals(-44, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 x 4  % 7");
        assertEquals(20, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("21 % 4 x 7 ");
        assertEquals(7, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("13 % 64");
        assertEquals(13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-13 % 64 ");
        assertEquals(-13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("13 % -64 ");
        assertEquals(13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-13 % -64");
        assertEquals(-13, this.processor.getResult()); this.processor.reset();
    }
}