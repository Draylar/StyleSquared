package com.github.draylar.buttons.numbers;

import com.github.draylar.CalculatorManager;
import com.github.draylar.CalculatorScreen;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class NumberButton extends AbstractButton {

    public int value;
    public int positionX;
    public int positionY;

    public NumberButton(int number) {
        this.value = number;
        if (number == 0) { positionX = 3; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT; }
        else if(number == 1) { positionX = 2; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 1; }
        else if (number == 2) { positionX = 3; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 1; }
        else if (number == 3) { positionX = 4; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 1; }
        else if (number == 4) { positionX = 2; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 2; }
        else if (number == 5) { positionX = 3; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 2; }
        else if (number == 6) { positionX = 4; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 2; }
        else if (number == 7) { positionX = 2; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 3; }
        else if (number == 8) { positionX = 3; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 3; }
        else if (number == 9) { positionX = 4; positionY = Settings.getInstance().CALCULATOR_GRID_HEIGHT - 3; }

        setStyle();
        configureClick();

        this.setText(Integer.toString(value));
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().DARK_COLOR);
    }

    // setup click events for the buttons
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().pressNumber(value);
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
