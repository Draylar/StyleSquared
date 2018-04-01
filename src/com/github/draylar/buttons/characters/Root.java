package com.github.draylar.buttons.characters;

import com.github.draylar.CalculatorManager;
import com.github.draylar.buttons.AbstractButton;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Root extends AbstractButton {

    public Root() {
        setStyle();
        configureClick();
        this.setText("√");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: #dbdbdb;");
    }

    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().root();
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
