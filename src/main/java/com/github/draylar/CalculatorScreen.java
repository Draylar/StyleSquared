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

    private static CalculatorScreen instance;
    // labels for the current equation & answer field near the top of the calculator
    private Label equationField;


    // -------------- SINGLETON PATTERN ---------------- //
    private Label resultField;

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
        if (instance == null) instance = new CalculatorScreen();
        return instance;
    }


    // ----------------- MECHANICS ------------------ //

    /**
     * Configure the root GridPane with columns.
     */
    private void configureGrid() {
        // set up columns
        for (int i = 0; i < Settings.getInstance().CALCULATOR_GRID_WIDTH; i++) {
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setPercentWidth(100 / Settings.getInstance().CALCULATOR_GRID_WIDTH);
            this.getColumnConstraints().add(constraints);
        }

        // set up rows
        for (int i = 0; i < Settings.getInstance().CALCULATOR_GRID_HEIGHT; i++) {
            RowConstraints constraints = new RowConstraints();
            constraints.setPercentHeight(100 / Settings.getInstance().CALCULATOR_GRID_HEIGHT);
            this.getRowConstraints().add(constraints);
        }
    }


    /**
     * Adds the number buttons to the root GridPane.
     */
    private void addNumberButtons() {
        for (int i = 0; i < 10; i++) {
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
        this.add(pi, 1, 5);
    }


    /**
     * Adds the hamburger menu to the top right of the GridPane.
     */
    private void addHamburger() {
        JFXHamburger menuButton = new JFXHamburger();
        this.add(menuButton, 0, 0, 1, 1);
    }


    /**
     * Adds the operator buttons (+, -, *, /, etc). to the GridPane.
     */
    private void addOperations() {
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
        this.add(mod, 2, 5);
    }


    /**
     * Adds function buttons (abs, log, and some other stuff) to the GridPane.
     */
    private void addFunctions() {
        // add the clear button which clears the current answer & equation
        Clear clear = new Clear();
        clear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(clear, 4, 5);

        // add delete button which removes the last char from the current equation
        Delete delete = new Delete();
        delete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(delete, 3, 5);

        // add the absolute value button which starts the absolute value function
        AbsoluteValue abs = new AbsoluteValue();
        abs.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(abs, 0, 5);

        // root button which types "sqrt("
        Root root = new Root();
        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.add(root, 0, 7);
    }


    /**
     * Adds special characters (braces, decimals) to the GridPane.
     */
    private void addCharacters() {
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


    /**
     * Adds the labels for the current equation and result field to the GridPane.
     */
    private void addTopLabels() {
        equationField = new Label();
        equationField.setStyle("-fx-font-size: 60px"); // debug purposes
        GridPane.setHalignment(equationField, HPos.RIGHT);
        this.add(equationField, 0, 2, 5, 1);

        resultField = new Label();
        resultField.setStyle("-fx-font-size: 50px"); // debug purposes
        GridPane.setHalignment(resultField, HPos.RIGHT);
        this.add(resultField, 0, 3, 5, 1);
    }


    /**
     * Updates the equation field-- grabs it from CalculatorManager. Is called when a button is pressed.
     */
    public void updateEquation() {
        equationField.setText(CalculatorManager.getInstance().getCurrentEquation()); // set text
        updateFontSize();
    }


    /**
     * Updates the font size to fit with the width of the screen. Should be called when something that changes the equation/answer/screen-width happens.
     */
    public void updateFontSize() {
        double width = equationField.getLayoutBounds().getWidth();
        if (width >= Settings.getInstance().SCREEN_WIDTH * .90) { // resize font if needed
            System.out.println(Settings.getInstance().SCREEN_WIDTH);
            System.out.println(width);
            System.out.println("");
            equationField.setStyle("-fx-font-size: " + equationField.getFont().getSize() * .90);
        }
    }


    /**
     * Updates the answer field.
     */
    public void updateAnswer() {
        resultField.setText(CalculatorManager.getInstance().getCurrentAnswer());
    }


    // ------------------- TOP BAR STYLE ------------------------ //

    /**
     * Configures the custom title bar.
     */
    private void configureTitleBar() {
        TitleControls titleControls = new TitleControls();
        titleControls.setMaxHeight(30);
        GridPane.setValignment(titleControls, VPos.TOP);
        this.add(titleControls, 0, 0, 5, 1);
    }
}
