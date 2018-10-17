package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ControlPane extends VBox {

    private final Button equalButton;
    private final Button clearButton;
    private final Button undoButton;
    private final Button redoButton;
    private final Button saveButton;


    public ControlPane() {
        this.equalButton = new EqualButton("=");
        this.clearButton = new KeyButton("C");
        this.undoButton = new KeyButton("<<");
        this.redoButton = new KeyButton(">>");
        this.saveButton = new KeyButton("M+");

        setPadding(new Insets(10,10,10,10));
        getChildren().addAll(equalButton,clearButton,undoButton,redoButton,saveButton);
    }

    public Button getEqualButton(){return equalButton;}
    public Button getClearButton(){return equalButton;}
    public Button getUndoButton(){return equalButton;}
    public Button getRedoButton(){return equalButton;}
    public Button getSaveButton(){return equalButton;}
}
