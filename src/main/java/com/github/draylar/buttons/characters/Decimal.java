package com.github.draylar.buttons.characters;

import com.github.draylar.CalculatorManager;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Decimal extends AbstractButton {

    public Decimal() {
        setStyle();
        configureClick();
        this.setText(".");
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().DARK_COLOR);
    }

    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().decimal();
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
