package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.scene.input.MouseEvent;

public class Enter extends AbstractButton {

    public Enter() {
        setStyle();
        configureClick();
        this.setText("=");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().DARK_COLOR);
    }


    /**
     * Configures click events.
     */
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            CalculatorManager.getInstance().finish();
            update();
        });
    }

    public void update() {
        super.updateFields();
    }
}
