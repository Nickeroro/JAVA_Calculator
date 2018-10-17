package view.fx;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class IOPane extends VBox {

    private final ModePane modePane;
    static public TextField input;
    static public Label output;

    public IOPane(ModePane modePane) {
        this.modePane = modePane;
        this.input = new TextField();
        this.output = new Label();
        input.setStyle("-fx-control-inner-background: #1e1e1e; -fx-text-fill: #45ff00; -fx-text-box-border: #45ff00");
        output.setStyle("-fx-text-fill: #45ff00");

        setSpacing(FXCalculator.SMALL);
        setPadding(new Insets(FXCalculator.MEDIUM, FXCalculator.MEDIUM, FXCalculator.MEDIUM, FXCalculator.MEDIUM));
        getChildren().addAll(modePane, input, output);
    }

    public ModePane getModePane() {
        return modePane;
    }

    public TextField getInput() {
        return input;
    }

    public Label getOutput() {
        return output;
    }

}