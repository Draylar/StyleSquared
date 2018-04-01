package com.github.draylar.buttons.characters;

import com.github.draylar.CalculatorManager;
import com.github.draylar.CalculatorScreen;
import com.github.draylar.Settings;
import com.github.draylar.buttons.AbstractButton;
import com.jfoenix.controls.JFXButton;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Bracket extends AbstractButton {

    String bracketValue;
    boolean isLeftBracket;

    public Bracket(boolean isLeftBracket) {
        setStyle();
        configureClick();

        this.isLeftBracket = isLeftBracket;

        // if the isLeftBracket argument is true, use '(' as our character; otherwise use ')'.
        if(isLeftBracket) {
            this.setText("(");
            bracketValue = "(";
        } else {
            this.setText(")");
            bracketValue = ")";
        }
    }

    public void setStyle() {
        this.setStyle("-fx-background-radius: 0px; -fx-background-color: " + Settings.getInstance().LIGHT_COLOR);
    }

    public void configureClick() {
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CalculatorManager.getInstance().bracket(isLeftBracket);
                update();
            }
        });
    }

    public void update() {
        super.updateFields();
    }
}
