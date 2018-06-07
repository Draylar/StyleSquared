package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.scene.input.MouseEvent;

public class Divide extends AbstractButton {

    public Divide() {
        setStyle();
        configureClick();
        this.setText("\\");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().LIGHT_COLOR);
    }


    /**
     * Configures click events.
     */
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            CalculatorManager.getInstance().divide();
            update();
        });
    }

    public void update() {
        super.updateFields();
    }
}
