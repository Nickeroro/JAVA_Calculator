package view.fx;

import javafx.scene.control.Button;

public class FixedSizeButton extends Button {

    public FixedSizeButton(String text){
        super(text);

        setPrefSize(50, 40);
        setStyle("-fx-text-fill: #45ff00; -fx-background-color: #1e1e1e; -fx-border-color: #45ff00; -fx-border-width: 2");
    }
}
