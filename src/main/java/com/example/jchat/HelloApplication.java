package com.example.jchat;

import com.example.jchat.GuiColors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
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

        Group root = new Group();
        Group groot = new Group();
        GuiColors guiColors = new GuiColors();

        int screenWidth = 400;
        int screenHeight = 600;

        Scene scene = new Scene(root, screenWidth, screenHeight, guiColors.colorMap.get(GuiColors.Colors.LIGHT_BLUE));
        Scene scene_blue = new Scene(groot, 900, 1000, guiColors.colorMap.get(GuiColors.Colors.BLUE));

        // This will allow us to use a style sheet for looks
        System.out.println(System.getProperty("user.dir"));
        scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());

        Stage stage = new Stage();


        // Put the items here
        Text text = new Text();
        TextField login = new TextField();
        TextField pass = new TextField();
        Button submit = new Button();


        root.getChildren().addAll(login, pass, text, submit);
        stage.setTitle("JChat");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


        // Logo Area
        text.setFill(Color.WHITE);
        text.setText("JChat");
        text.setWrappingWidth(265);
        text.setId("logo");
        text.setX((screenWidth/2)-(text.getWrappingWidth()/2));
        text.setY(150); // from david
        // asdflkajsdflkj
        // something



        // Login Box
        login.setPromptText("Enter Login");
        login.setId("textbox");
        login.setPrefWidth(200);
        login.setPrefHeight(40);
        login.setLayoutX((screenWidth/2)-(login.getPrefWidth()/2));
        login.setLayoutY(325);
        System.out.println(login.getId());


        // Password Box
        pass.setPromptText("Enter password");
        pass.setId("textbox");
        pass.setPrefWidth(200);
        pass.setPrefHeight(40);
        pass.setLayoutX((screenWidth/2)-(pass.getPrefWidth()/2));
        pass.setLayoutY(400);

        // Button
        submit.setText("Login");
        submit.setId("submit");
        submit.setPrefWidth(150);
        submit.setPrefHeight(20);
        submit.setLayoutX((screenWidth/2)-(submit.getPrefWidth()/2));
        submit.setLayoutY(500);

        // When Button Pressed
        submit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                // Eventually Check SQL Database to make sure user EXISTS!
                stage.setScene(scene_blue);
                stage.show();
//                System.out.println(login.getText());
//                System.out.println(pass.getText());


            }
        });






    }

    public static void main(String[] args) {
        launch();
    }
}
