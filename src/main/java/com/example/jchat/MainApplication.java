package com.example.jchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApplication extends Application {

    public static Parent loginRoot;
    public static Parent signUpRoot;

    public static Scene loginScene;
    public static Scene signUpScene;

    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws IOException {


        GuiColors guiColors = new GuiColors();

        int screenWidth = 400;
        int screenHeight = 600;

        // Root Setup
        loginRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
        signUpRoot = FXMLLoader.load(getClass().getResource("signup-screen.fxml"));

        // Scene setup
        loginScene = new Scene(loginRoot, screenWidth, screenHeight);
        signUpScene = new Scene(signUpRoot, screenWidth, screenHeight);

        // Stylesheet setup
        loginScene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());


        // Create a stage and then set the scene
        mainStage = new Stage();
        mainStage.setScene(loginScene);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
