package com.github.draylar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // stage and scene-- can be retrieved with getStage() and getScene().
    // the secondary stage is kept so we can reference our primaryStage in other classes.
    private static Stage stage = new Stage();
    private static Scene scene;

    /**
     * Returns the current stage being used.
     *
     * @return the current stage
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Returns the current scene.
     *
     * @return the current scene
     */
    public static Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // configure stage & scene. The scene takes in the default calculator screen as well as the width and height from our settings class.
        stage = primaryStage;
        scene = new Scene(CalculatorScreen.getInstance(), Settings.getInstance().SCREEN_WIDTH, Settings.getInstance().SCREEN_HEIGHT);

        // when you enable this and a couple other commented out areas, you can get a custom title bar. might be used later.
        // todo: add custom title bar functionality.
        // primaryStage.initStyle(StageStyle.UNDECORATED);

        configureSizeListener();

        primaryStage.setTitle("Style Squared");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Sets up a listener which updates the settings based on window resize.
     */
    public void configureSizeListener() {
        stage.widthProperty().addListener((observable, oldValue, newValue) -> {
            Settings.getInstance().SCREEN_WIDTH = newValue.intValue();
        });

        stage.heightProperty().addListener((observable, oldValue, newValue) -> {
            Settings.getInstance().SCREEN_HEIGHT = newValue.intValue();
        });
    }
}
