package view.fx;

import control.ExpressionProcessor;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class ModePane extends HBox {

    protected ExpressionProcessor processor;

    public static RadioButton infixButton;
    public static RadioButton rpnButton;



    public ModePane() {
        this.infixButton = new RadioButton("Infix");
        this.rpnButton = new RadioButton("RPN");
        infixButton.setStyle("-fx-text-fill: #45ff00");
        rpnButton.setStyle("-fx-text-fill: #45ff00");
        ToggleGroup modeButtonGroup = new ToggleGroup();
        infixButton.setToggleGroup(modeButtonGroup);
        rpnButton.setToggleGroup(modeButtonGroup);

        infixButton.setSelected(true);

        setPadding(new Insets(10,10,10,10));
        getChildren().addAll(infixButton,rpnButton);
    }

    public RadioButton getInfixButton() {
        return infixButton;
    }

    public RadioButton getRpnButton() {
        return rpnButton;
    }

}