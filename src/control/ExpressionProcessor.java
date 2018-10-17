package control;

public interface ExpressionProcessor {
    void processExpression(String exp);
    boolean hasResult();
    int getResult();
    void reset();
}
