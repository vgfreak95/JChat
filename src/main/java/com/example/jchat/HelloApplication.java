package com.example.jchat;

import com.example.jchat.GuiColors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.BindException;
import java.util.Scanner;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        GuiColors guiColors = new GuiColors();

        int screenWidth = 400;
        int screenHeight = 600;

        Parent fxRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));

        Scene scene = new Scene(fxRoot, screenWidth, screenHeight);

        // This will allow us to use a style sheet for looks
        scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());

        // Create a stage and then set the scene
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
