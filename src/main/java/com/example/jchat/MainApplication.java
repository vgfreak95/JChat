package com.example.jchat;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
//import com.mysql.cj.jdbc.Driver;


public class MainApplication extends Application {

    public static Connection conn;

    public static Parent loginRoot;
    public static Parent signUpRoot;
    public static Parent dashboardRoot;

    public static Scene signUpScene;
    public static Scene loginScene;
    public static Scene dashboardScene;

    public static Stage mainStage;

    public static int preScreenWidth = 400, preScreenHeight = 600;
    public static int dashWidth = 1280, dashHeight = 960;

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {

        String strxd = "Hi there my guy 24.456.677.234 socketInfo";
        String[] strArr = strxd.split(" ");
        System.out.println(strArr[strArr.length-2]);

        GuiColors guiColors = new GuiColors();

        // Root Setup
        loginRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
        signUpRoot = FXMLLoader.load(getClass().getResource("signup-screen.fxml"));
        dashboardRoot = FXMLLoader.load(getClass().getResource("dashboard-screen.fxml"));

        // Scene setup
        loginScene = new Scene(loginRoot, preScreenWidth, preScreenHeight);
        signUpScene = new Scene(signUpRoot, preScreenWidth, preScreenHeight);
        dashboardScene = new Scene(dashboardRoot,dashWidth, dashHeight);

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
