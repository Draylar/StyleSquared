package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.scene.input.MouseEvent;

public class Mod extends AbstractButton {

    public Mod() {
        setStyle();
        configureClick();
        this.setText("%");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().MIDDLE_COLOR);
    }


    /**
     * Configures click events.
     */
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            CalculatorManager.getInstance().mod();
            update();
        });
    }

    public void update() {
        super.updateFields();
    }
}
