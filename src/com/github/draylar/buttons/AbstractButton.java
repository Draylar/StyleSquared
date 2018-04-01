package com.github.draylar.buttons;

import com.github.draylar.CalculatorScreen;
import com.jfoenix.controls.JFXButton;

// abstract class for buttons.
// the main purpose of this is to not only give button classes consistency, but to also automatically update the equation and answer fields when a button is pressed.

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
