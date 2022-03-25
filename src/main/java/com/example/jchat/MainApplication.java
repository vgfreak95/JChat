package com.example.jchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        GuiColors guiColors = new GuiColors();

        int screenWidth = 400;
        int screenHeight = 600;

        Parent loginRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
        Parent signUpRoot = FXMLLoader.load(getClass().getResource("dashboard-screen.fxml"));

        Scene loginScene = new Scene(loginRoot, screenWidth, screenHeight);
        Scene signUpScene = new Scene(signUpRoot, screenWidth, screenHeight);

        // This will allow us to use a style sheet for looks
        loginScene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());

        // Create a stage and then set the scene
        Stage stage = new Stage();
        stage.setScene(loginScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
