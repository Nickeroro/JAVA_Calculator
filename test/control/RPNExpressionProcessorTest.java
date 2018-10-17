package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNExpressionProcessorTest {

    private RPNExpressionProcessor processor;

    @BeforeEach
    void setUp() {
        this.processor = new RPNExpressionProcessor();
    }

    @Test
    void processExpression() {
        this.processor.processExpression("5 4 -");
        assertEquals(1, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 4 +");
        assertEquals(9, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 4 x");
        assertEquals(20, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 4 /");
        assertEquals(1, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 4 x 4 /");
        assertEquals(5, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-5 4 x 4 /");
        assertEquals(-5, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-5 4 8 - x 4 /");
        assertEquals(5, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 -4 8 - x -4 /");
        assertEquals(15, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("5 4 x 7 %");
        assertEquals(6, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("21 4 % 7 x");
        assertEquals(7, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("13 64 %");
        assertEquals(13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-13 64 %");
        assertEquals(-13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("13 -64 %");
        assertEquals(13, this.processor.getResult()); this.processor.reset();
        this.processor.processExpression("-13 -64 %");
        assertEquals(-13, this.processor.getResult()); this.processor.reset();

    }
}