package com.github.draylar;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

// experimental custom title bar controls, may be added at a later date.
// the current problem with this is that Windows' window resizing and auto-expanding/snapping doesn't work.
// there are solutions in the form of extra libraries which I may look into later.

public class TitleControls extends HBox {

    // 3 buttons on the top-right of the window
    private JFXButton close = new JFXButton();
    private JFXButton minimize = new JFXButton();
    private JFXButton expand = new JFXButton();

    public TitleControls() {
        setStyle();
        configurePresses();
        this.getChildren().addAll(minimize, expand, close);
    }


    /**
     * Configures style of the pane.
     */
    private void setStyle() {
        close.setPrefWidth(25);
        minimize.setPrefWidth(25);
        expand.setPrefWidth(25);

        this.setAlignment(Pos.CENTER_RIGHT);
        this.setStyle("-fx-background-color: " + Settings.getInstance().MIDDLE_COLOR);

        /* close.setStyle("-fx-background-color: blue");
        minimize.setStyle("-fx-background-color: blue");
        expand.setStyle("-fx-background-color: blue"); */

        close.setText("X");
        minimize.setText("--");
        expand.setText("☐");
    }


    /**
     * Configures button presses.
     */
    private void configurePresses() {
        final Delta dragDelta = new Delta();
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            dragDelta.x = Main.getStage().getX() - e.getScreenX();
            dragDelta.y = Main.getStage().getY() - e.getScreenY();
        });

        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            Main.getStage().setX(e.getScreenX() + dragDelta.x);
            Main.getStage().setY(e.getScreenY() + dragDelta.y);
        });
    }
}

// class to keep track of window position
class Delta {
    double x;
    double y;
}
