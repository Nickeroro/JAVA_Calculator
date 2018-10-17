<table>
    <tr>
        <td>TALEC-BENARD Nicolas</td>
		<td>FIPA_2020 </br>17/10/2018</td>
</table>



## Calculator project



## Introduction



![Sans titre](C:\Users\Keroro\Desktop\Sans titre.bmp)



Le `calculator project` est un projet de calculatrice en JAVA. Cette calculatrice permet à l'utilisateur d'éffectuer differents calculs, mais lui offre également la possibilité de calculer en mode `RPN` ou `Infix`.



------

### FXCalculator 

Dans un premier temps nous allons regarder `FXCalculator` . C'est en quelque sort le main de notre progamme.

```Java
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
```



Première chose à noter: Notre classe  `FXCalculator` hérite de  `Application`, classe JAVA qui est elle même qui hérite de `JavaFX`.

```java
Public class FXCalculator extends Application { ... }
```



Ensuite nous assigons a des variables des "tailles": LARGE, MEDIUM et SMALL qui nous servirons plus tard.

```java
 	static public final int SMALL = 5;
    static public final int MEDIUM = 10;
    static public final int LARGE = 20;
```



Notre "RootPane" est constitué de plusieurs "Panes" qui sont deux Hbox et une Vbox

```java
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
```

Dans toutes ces Panes, se trouvent nous boutons, nos `RadioBouttons`, notre `registre M`, le fond, ainsi que le `TextFeild` et le `Label`.



La méthode pour créer la fenêtre et lancer le code se trouve ci-dessous:


```java
@Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createRootPane(), 520, 375);
        primaryStage.setTitle("Calculator Project");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
```



Finalement, nous aurons le `main`. (Qui n'est pas utile à tout les IDEs javas.)

```java
public static void main(String[] args) {
    launch(args);
}
```



Nous allons maintenant décortiquer les classes.

![Capture](C:\Users\Keroro\Desktop\Capture.PNG)

------

### ControlPane 



Ici, nous venons créer nos boutons de "controle" c'est à dire `=`,` C`, `<<`, `>>`, ainsi que `M+`:

```java
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
```



Tout ces boutons, en l'occurence le `ControlePane` lui-même hérite d'une `Vbox`. Ils seront donc disposés de manière verticale.

Pour ces boutons nous avons crée une commune, pour le bouton `=` qui effectuera l'opération, nous avons choisis de créer une classe différente.





------

### KeyButton

```java
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
            default:
                IOPane.input.appendText(value);
                break;
        }
    }


}
```

**KeyButton** est donc utilisé pour tout nos boutons sauf le bouton `=`. Celle classe hérite de `FixedSizeButton` que nous décrirons prochainement.

Nous pouvons voir que tout ces boutons ont un comportement "basique" qui est de prendre sa propre valeur et de l'afficher (par exemple ButtonOne affichera '1') et tout cela si une "Action" est détécté. Une action est ici un clic de souris sur le bouton.

Nous pouvons également notre que certains boutons ont des comportements différents:

- `Del` va supprimer le dernier caractère de la chaine de texte situé dans notre `TextFeild`
- `_` va écrire un espace dans notre `TextFeild`
- `C` va éffectuer un `.clear()`, il va effacer notre `TextFeild`
- `>>` et `<<` vont éffectuer réspéctivement un `.redo()` ou un `.undo()`.





------

### FixedSizeButton

```java
package view.fx;

import javafx.scene.control.Button;

public class FixedSizeButton extends Button {

    public FixedSizeButton(String text){
        super(text);

        setPrefSize(50, 40);
        setStyle("-fx-text-fill: #45ff00; -fx-background-color: #1e1e1e; -fx-border-color: #45ff00; -fx-border-width: 2");
    }
}
```

**FixedSizeButton** est une classe mère qui hérite de `Button`, elle sert ici à fixer la même taille et la même couleur pour tout ses boutons filles. (Ici, 50 de largeur, 40 de hauteur avec une couleur verte, de fond gris, avec un contour d'épaisseur 2px et de couleur verte)





------

### EqualButton

```java
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
```

**EqualButton** est un bouton un peu différent des autres, car lui va éffectuer l'opération qui sera affichée sur l'écran (le `TextFeild`). Dans ce bouton nous faisont appel à un `processeur`  précédement crée pour tester la calculatrice dans le prompt. (C'est le bouton `=`.) Cependant il hérite également de `FixedSizeButton`.

Si nous avons une action (un clic) sur celui-ci alors:

- Le programme va venir voir si c'est le RadioBouton `Infix` ou `RPN` qui est séléctioné, nous allons 		choisir le processeur `InfixExpressionProcessor` ou `RPNExpressionProcessor `en fonction de cette sélection. **ATTENTION:** Ici comme`InfixExpressionProcessor` hérite de `RPNExpressionProcessor`, si l'on choisit le processeur Infix, nous pourrons effectuer des opérations RPN...
- Le programme va ensuite récupérer le texte dans le `TextFeild` pour faire le calcul avec `processExpression` du processor.
- Finallement, le programme va afficher dans le `Label` le résultat de cette opération.
- Si il y a un problème, alors le programme va afficher "Oops! " dans le `Label`.





------

### IOPane

```java
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
```

**IOpane** qui hérite d'une `Vbox` est le Pane qui contient l'affichage du calcul stocké dans un `TextFeild` ainsi que le résultat de celui-ci dans un `Label`. 

Le `TextFeild` est le `Label` sont donc positionés sur des lignes verticales, l'un en dessous l'autre.

Le `TextFeild`  aura une couleur de fond noire, du texte et une bordure verte.





------

### ModePane

```java
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
```

**ModePane** qui hérite d'une `HBox` est la Pane qu icontient les deux `Radioboutons` de séléction du mode (`Infix`, `RPN`). Nous pouvons noter que quand le programme se lancera, le bouton `Infix` sera coché.

Ils seront donc disposés de manière horizontale, c'est à dire, l'un à coté de l'autre.





------

### NumPane

```java
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
```

**NumPane** qui hérite d'un `GridPane` est une Pane qui sera une grille. Ici, nous créons nos boutons `1`,` 2`, ....,`8` et `9`. Pour créer ces boutons, nous avons fait le choix d'effectuer une boucle qui les disposeront automatiquement sur la grille. Nous avons également crée deux `Del` et `_` afin de pouvoir réspectivement supprimer le dernier caractère, ou d'écrire un "espace" dans notre `TextFeild`.





------

### OpPane

```java
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
```

**OpPane** est notre dernière classe qui hérite d'une `VBox` et qui contient nos boutons "opérateurs" `+`, `-`, `x`, `/` et `%`. Ces boutons seront disposés de manière verticale dans notre calculatrice.





------

**ATTENTION**: 

Pistes d'améliorations

- Il faudrait que je puisses mieux gérer les messages d'erreurs dans le `label` par exemple, quand une opération `Infix` et faite pendant que le `RadioBouton` `RPN` est séléctionné.
- Il faudrait trouver un autre facon pour créer un processeur `InfixExpressionProcessor` sans le faire hériter de `RPNExpressionProcessor`, de manière à pouvoir également gérer les messages d'erreurs lorsqu'on effectue une opération `RPN` pendant que le `RadioBouton` `Infix` est séléctionné.

- Je n'ai malheureusement pas réussi a gérer les mémoires avec `M+`, `M-`

  Il existe dans `FXCalculator` un `static public final int[] REGISTER_VALUES = {8, 11};`

  Je voulais essayer de me servire de cette liste et venir après apuis d'un bouton, stocker les résultats de l'opération dans celle-ci, s'en servant comme d'une pile.


J'ai également exporté le projet en `.jar` affin de le rendre executable.
(Il est accessible sous: `JAVA_calculator\out\artifacts\JAVA_calculator.jar` )
------

TALEC-BERNARD Nicolas

FIPA2020
