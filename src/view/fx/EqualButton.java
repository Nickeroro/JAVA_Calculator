package view.fx;

import control.ExpressionProcessor;
import control.InfixExpressionProcessor;
import control.RPNExpressionProcessor;
import javafx.event.ActionEvent;

public class EqualButton extends FixedSizeButton {


    protected ExpressionProcessor processor;

    public EqualButton(String text) {
        super(text);
        setOnAction(this::computeResult);

    }

    private void computeResult(ActionEvent ae) {
        if (ModePane.infixButton.isSelected()) {
            this.processor = new InfixExpressionProcessor();
        } else {
            this.processor = new RPNExpressionProcessor();
        }

        try {
            this.processor.processExpression(IOPane.input.getText());
            IOPane.output.setText(String.valueOf(this.processor.getResult()));

        } catch (Exception e) {
            IOPane.output.setText("Oops!");
            e.printStackTrace();
        }
    }
}



/*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
@Override
public void handle(KeyEvent keyEvent) {
        handleEvent(keyEvent);
        }
        });

public void handleEvent(KeyEvent e){
        String type = e.getEventType().getName();
        KeyCode keyCode = e.getCode();
        System.out.println(type+"CODE:"+keyCode.getName());
        if (e.getEventType() == KeyEvent.KEY_PRESSED && e.getCode() == KeyCode.ENTER)
        }    */