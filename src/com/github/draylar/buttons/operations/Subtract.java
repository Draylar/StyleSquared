package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Subtract extends AbstractButton {

    public Subtract() {
        setStyle();
        configureClick();
        this.setText("-");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().LIGHT_COLOR);
    }


    /**
     * Configures click events.
     */
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().subtract();
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
