package com.github.draylar.buttons.characters;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Square extends AbstractButton {

    public Square() {
        setStyle();
        configureClick();
        this.setText("x²");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().LIGHT_COLOR);
    }

    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().square();
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
