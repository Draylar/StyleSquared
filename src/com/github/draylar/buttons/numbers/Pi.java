package com.github.draylar.buttons.numbers;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Pi extends AbstractButton {

    public Pi() {
        setStyle();
        configureClick();
        this.setText("π");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().MIDDLE_COLOR);
    }

    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().pi();
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
