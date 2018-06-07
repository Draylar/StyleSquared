package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.scene.input.MouseEvent;

public class Delete extends AbstractButton {

    public Delete() {
        setStyle();
        configureClick();
        this.setText("Del");
    }

    @Override
    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().MIDDLE_COLOR);
    }


    /**
     * Configures click events.
     */
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            // sets the current equation to the current equation without the last char.
            CalculatorManager calculatorManager = CalculatorManager.getInstance();
            calculatorManager.setCurrentEquation(calculatorManager.getCurrentEquation().substring(0, calculatorManager.getCurrentEquation().length() - 1));
            update();
        });
    }


    @Override
    public void update() {
        super.updateFields();
    }
}
