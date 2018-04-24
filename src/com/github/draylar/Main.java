package com.github.draylar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // stage and scene-- can be retrieved with getStage() and getScene().
    // the secondary stage is kept so we can reference our primaryStage in other classes.
    private static Stage stage = new Stage();
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // configure stage & scene. The scene takes in the default calculator screen as well as the width and height from our settings class.
        stage = primaryStage;
        scene = new Scene(CalculatorScreen.getInstance(), Settings.getInstance().SCREEN_WIDTH, Settings.getInstance().SCREEN_HEIGHT);

        // when you enable this and a couple other commented out areas, you can get a custom title bar. might be used later.
        // todo: add custom title bar functionality.
        // primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setTitle("Style Squared");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Returns the current stage being used.
     * @return
     */
    public static Stage getStage() { return stage; }

    /**
     * Returns the current scene.
     * @return
     */
    public static Scene getScene() { return scene; }

    public static void main(String[] args) {
        launch(args);
    }
}
