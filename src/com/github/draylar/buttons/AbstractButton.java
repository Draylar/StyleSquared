package com.github.draylar.buttons;

import com.github.draylar.CalculatorScreen;
import com.jfoenix.controls.JFXButton;

/**
 * Abstract class for buttons to extend off.
 */
public abstract class AbstractButton extends JFXButton {

    public AbstractButton() { }

    public abstract void setStyle();

    public abstract void configureClick();

    public abstract void update();

    public void updateFields() {
        CalculatorScreen.getInstance().updateEquation();
        CalculatorScreen.getInstance().updateAnswer();
    }
}
