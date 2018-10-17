package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class NumPane extends GridPane {

    private final Button[] digitButtons;
    private final Button spaceButton;
    private final Button delButton;

    public NumPane() {
        this.digitButtons = new KeyButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new KeyButton(Integer.toString(i));
        }
        this.spaceButton = new KeyButton("_");
        this.delButton = new KeyButton("Del");

        setPadding(new Insets(FXCalculator.MEDIUM, FXCalculator.MEDIUM, FXCalculator.MEDIUM, FXCalculator.MEDIUM));
        addRow(0, digitButtons[7], digitButtons[8], digitButtons[9]);
        addRow(1, digitButtons[4], digitButtons[5], digitButtons[6]);
        addRow(2, digitButtons[1], digitButtons[2], digitButtons[3]);
        addRow(3, digitButtons[0], spaceButton, delButton);
    }

    public Button[] getDigitButtons() {
        return digitButtons;
    }

    public Button getSpaceButton() {
        return spaceButton;
    }

    public Button getDelButton() {
        return delButton;
    }
}