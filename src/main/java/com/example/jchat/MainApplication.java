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
    public static Parent chatroomRoot;
    public static Parent dashboardRoot;

    public static Scene loginScene;
    public static Scene signUpScene;
    public static Scene chatroomScene;
    public static Scene dashboardScene;

    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws IOException {


        GuiColors guiColors = new GuiColors();

        int screenWidth = 400;
        int screenHeight = 600;
        int dashWidth = 1080;
        int dashHeight = 960;

        // Root Setup
        loginRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
        signUpRoot = FXMLLoader.load(getClass().getResource("signup-screen.fxml"));
        chatroomRoot = FXMLLoader.load(getClass().getResource("chatroom.fxml"));
        dashboardRoot = FXMLLoader.load(getClass().getResource("dashboard-screen.fxml"));



        // Scene setup
        loginScene = new Scene(loginRoot, screenWidth, screenHeight);
        signUpScene = new Scene(signUpRoot, screenWidth, screenHeight);
        dashboardScene = new Scene(dashboardRoot,dashWidth, dashHeight);
        chatroomScene = new Scene(chatroomRoot, dashWidth, dashHeight);

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
