package view.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FXCalculator extends Application {

    static public final int SMALL = 5;
    static public final int MEDIUM = 10;
    static public final int LARGE = 20;
    static public final int[] REGISTER_VALUES = {8, 11};

    public static void main(String[] args) {
        launch(args);
    }

    private HBox createRegister(int value) {
        Button loadButton = new FixedSizeButton("M-");
        Label label = new Label(Integer.toString(value));
        HBox register = new HBox();
        register.setSpacing(SMALL);
        register.getChildren().addAll(loadButton, label);
        return register;
    }

    private VBox createRegisterPane() {
        VBox registerPane = new VBox();
        registerPane.setSpacing(SMALL);
        registerPane.setPadding(new Insets(MEDIUM, MEDIUM, MEDIUM, MEDIUM));

        for (int value : REGISTER_VALUES) {
            registerPane.getChildren().add(createRegister(value));
        } return registerPane;
    }

    private HBox createBottomPane() {
        HBox bottomPane = new HBox();
        bottomPane.getChildren().addAll(
                new NumPane(),
                new OpPane(),
                new ControlPane(),
                createRegisterPane()
        );
        return bottomPane;
    }

    private Pane createRootPane(){

        IOPane ioPane = new IOPane(new ModePane());
        StackPane sp = new StackPane();
        Image img = new Image("https://i.imgur.com/oWZGpTU.png");
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(375);
        imgView.setFitWidth(520);
        VBox rootPane = new VBox();
        rootPane.getChildren().addAll(ioPane, createBottomPane());
        sp.getChildren().addAll(imgView, rootPane);
        return sp;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createRootPane(), 520, 375);
        primaryStage.setTitle("Calculator Project");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}