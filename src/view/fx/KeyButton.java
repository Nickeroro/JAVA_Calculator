package view.fx;

import control.ExpressionProcessor;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class KeyButton extends FixedSizeButton {

    public ExpressionProcessor processor;

    public KeyButton(String text) {
        super(text);
        setOnAction(this::keyBehavior);
    }


    public void keyBehavior(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        switch (value) {
            case "Del":
                IOPane.input.setText(IOPane.input.getText(0, IOPane.input.getLength() - 1));
                break;
            case "_":
                IOPane.input.appendText(" ");
                break;
            case "C":
                IOPane.input.clear();
                break;
            case "<<":
                IOPane.input.undo();
                break;
            case ">>":
                IOPane.input.redo();
                break;
            //IOPane.output.setText(IOPane.input.getText());
            //IOPane.output.setText(this.processor.getResult());
            default:
                IOPane.input.appendText(value);
                break;
        }
    }


}