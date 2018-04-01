package com.github.draylar.buttons.operations;

import com.github.draylar.CalculatorManager;
import com.github.draylar.CalculatorScreen;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AbsoluteValue extends AbstractButton {

    public AbsoluteValue() {
        setStyle();
        configureClick();
        this.setText("Abs");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().MIDDLE_COLOR);
    }

    // setup click events for enter
    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}