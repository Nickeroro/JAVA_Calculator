package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OpPane extends VBox {
    static private final int MEDIUM = 10;

    private final Button plusButton;
    private final Button minusButton;
    private final Button multButton;
    private final Button divButton;
    private final Button modButton;

    public OpPane() {
        this.plusButton = new KeyButton("+");
        this.minusButton = new KeyButton("-");
        this.multButton = new KeyButton("x");
        this.divButton = new KeyButton("/");
        this.modButton = new KeyButton("%");

        setPadding(new Insets(MEDIUM, MEDIUM, MEDIUM, MEDIUM));
        getChildren().addAll(plusButton,minusButton,multButton,divButton,modButton);
    }

    public Button getPlusButton(){return plusButton;}
    public Button getMinusButton(){return minusButton;}
    public Button getMultButton(){return multButton;}
    public Button getDivButton(){return divButton;}
    public Button getModButton(){return modButton;}

}
