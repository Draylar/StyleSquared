package com.github.draylar;

import com.github.draylar.buttons.characters.Bracket;
import com.github.draylar.buttons.characters.Decimal;
import com.github.draylar.buttons.characters.Root;
import com.github.draylar.buttons.characters.Square;
import com.github.draylar.buttons.numbers.NumberButton;
import com.github.draylar.buttons.numbers.Pi;
import com.github.draylar.buttons.operations.*;
import com.jfoenix.controls.JFXHamburger;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CalculatorScreen extends GridPane {

    // labels for the current equation & answer field near the top of the calculator
    private Label equationField;
    private Label resultField;


    // -------------- SINGLETON PATTERN ---------------- //

    private static CalculatorScreen instance;

    private CalculatorScreen() {
        configureGrid();
        addNumberButtons();
        addOperations();
        addTopLabels();
        addCharacters();
        addHamburger();
        addFunctions();
        this.setGridLinesVisible(false);

        // see comments in main about the title bar for more info
        // configureTitleBar();
    }
    public static CalculatorScreen getInstance() {
        if(instance == null) instance = new CalculatorScreen();
        return instance;
    }


    // ----------------- MECHANICS ------------------ //

    // set up the grid which we put our buttons into
    public void configureGrid() {
        // set up columns
        for(int i = 0; i < Settings.getInstance().CALCULATOR_GRID_WIDTH; i++) {
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setPercentWidth(100 / Settings.getInstance().CALCULATOR_GRID_WIDTH);
            this.getColumnConstraints().add(constraints);
        }

        // set up rows
        for(int i = 0; i < Settings.getInstance().CALCULATOR_GRID_HEIGHT; i++) {
            RowConstraints constraints = new RowConstraints();
            constraints.setPercentHeight(100 / Settings.getInstance().CALCULATOR_GRID_HEIGHT);
            this.getRowConstraints().add(constraints);
        }
    }

    // create the buttons for the numbers
    public void addNumberButtons() {
        for(int i = 0; i < 10; i++) {
            NumberButton numberButton = new NumberButton(i);

            // set the max size so we can let the button fill the cell it is in
            numberButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            // coordinates on grid
            int y = numberButton.positionY - 1;
            int x = numberButton.positionX - 1;

            // add to gridpane
            this.add(numberButton, x, y);
        }

        // add the pi button. I think pi falls under the number category but I might move it later.
        // todo: find a better spot for adding the pi button
        Pi pi = new Pi();
        pi.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(pi, 2, 5);
    }

    // who doesn't like hamburgers? I prefer a juicy lucy with bacon and american cheese on top-- nothing else.
    // really though, this adds the hamburger button to the top left of the screen.
    // todo: add click event to hamburger
    public void addHamburger() {
        JFXHamburger menuButton = new JFXHamburger();
        this.add(menuButton, 0, 0, 1, 1);
    }

    // create buttons for operators
    public void addOperations() {
        Enter enter = new Enter();
        enter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(enter, 3, 9);

        Add add = new Add();
        add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(add, 4, 9);

        Subtract subtract = new Subtract();
        subtract.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(subtract, 4, 8);

        Multiply multiply = new Multiply();
        multiply.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(multiply, 4, 7);

        Divide divide = new Divide();
        divide.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(divide, 4, 6);

        Mod mod = new Mod();
        mod.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(mod, 3, 5);
    }

    // yes, I'm aware clear and abs aren't functions, and log might not be either, but I can't think of a different name for this function.
    // todo: rename function to make more sense
    public void addFunctions() {
        // add the clear button which clears the current answer & equation
        Clear clear = new Clear();
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(clear, 4, 5);

        // add the absolute value button which starts the absolute value function
        AbsoluteValue abs = new AbsoluteValue();
        abs.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(abs, 1, 5);

        // add log button
        Log log = new Log();
        log.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(log, 0, 5);

        // root button which types "sqrt("
        Root root = new Root();
        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(root, 0, 7);
    }

    // add extra buttons such as brackets
    public void addCharacters() {
        Bracket leftBracket = new Bracket(true);
        leftBracket.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(leftBracket, 0, 9);

        Bracket rightBracket = new Bracket(false);
        rightBracket.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(rightBracket, 0, 8);

        Decimal decimal = new Decimal();
        decimal.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(decimal, 1, 9);

        // adds the ^ symbol
        Square square = new Square();
        square.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(square, 0, 6);
    }

    // add the equation and answer labels near the top
    public void addTopLabels() {
        equationField = new Label();
        equationField.setStyle("-fx-font-size: 60px"); // debug purposes
        GridPane.setHalignment(equationField, HPos.RIGHT);
        this.add(equationField, 0, 2, 5, 1);

        resultField = new Label();
        resultField.setStyle("-fx-font-size: 50px"); // debug purposes
        GridPane.setHalignment(resultField, HPos.RIGHT);
        this.add(resultField, 0, 3, 5, 1);
    }

    // updates the answer field to grab the current equation from the CalculatorManager.
    // is called when most buttons are pressed.
    public void updateEquation() {
        equationField.setText(CalculatorManager.getInstance().getCurrentEquation()); // set text
        double width = equationField.getLayoutBounds().getWidth();
        if(width >= Settings.getInstance().SCREEN_WIDTH * .90) { // resize font if needed
            System.out.println(width);
            System.out.println(Settings.getInstance().SCREEN_WIDTH);
            equationField.setStyle("-fx-font-size: " + equationField.getFont().getSize() * .90);
        }
    }

    // update the answer label.
    public void updateAnswer() {
        resultField.setText(CalculatorManager.getInstance().getCurrentAnswer());
    }


    // ------------------- TOP BAR STYLE ------------------------ //

    public void configureTitleBar() {
        TitleControls titleControls = new TitleControls();
        titleControls.setMaxHeight(30);
        GridPane.setValignment(titleControls, VPos.TOP);
        this.add(titleControls, 0, 0, 5, 1);
    }
}
