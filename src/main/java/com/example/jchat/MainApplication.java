package com.example.jchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public static Parent chatroomRoot;
    public static Parent dashboardRoot;
    public static Parent reportedLogsRoot;
    public static Parent modifyPermissionsRoot;
    public static Parent openRoomsRoot;
    public static Parent suspendAccessRoot;
    public static Parent viewMembersRoot;

    public static Scene loginScene;
    public static Scene signUpScene;
    public static Scene chatroomScene;
    public static Scene dashboardScene;
    public static Scene reportedLogsScene;
    public static Scene modifyPermissionsScene;
    public static Scene openRoomsScene;
    public static Scene suspendAccessScene;
    public static Scene viewMembersScene;

    public static Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {

        String strxd = "Hi there my guy 24.456.677.234 socketInfo";
        String[] strArr = strxd.split(" ");
        System.out.println(strArr[strArr.length-2]);

        GuiColors guiColors = new GuiColors();
        int preScreenWidth = 400, preScreenHeight = 600;
        int dashWidth = 1280, dashHeight = 960;

        // Root Setup
        loginRoot = FXMLLoader.load(getClass().getResource("login-screen.fxml"));
        signUpRoot = FXMLLoader.load(getClass().getResource("signup-screen.fxml"));
        chatroomRoot = FXMLLoader.load(getClass().getResource("chatroom.fxml"));
        dashboardRoot = FXMLLoader.load(getClass().getResource("dashboard-screen.fxml"));
        modifyPermissionsRoot = FXMLLoader.load(getClass().getResource("modifypermissions-screen.fxml"));
        openRoomsRoot = FXMLLoader.load(getClass().getResource("openrooms-screen.fxml"));
        suspendAccessRoot = FXMLLoader.load(getClass().getResource("suspendaccess-screen.fxml"));
        viewMembersRoot = FXMLLoader.load(getClass().getResource("viewmembers-screen.fxml"));
        reportedLogsRoot = FXMLLoader.load(getClass().getResource("reportedlogs-screen.fxml"));

        // Scene setup
        loginScene = new Scene(loginRoot, preScreenWidth, preScreenHeight);
        signUpScene = new Scene(signUpRoot, preScreenWidth, preScreenHeight);
        dashboardScene = new Scene(dashboardRoot,dashWidth, dashHeight);
        chatroomScene = new Scene(chatroomRoot, dashWidth, dashHeight);
        reportedLogsScene = new Scene(reportedLogsRoot, dashWidth, dashHeight);
        modifyPermissionsScene = new Scene(modifyPermissionsRoot, dashWidth, dashHeight);
        openRoomsScene = new Scene(openRoomsRoot, dashWidth, dashHeight);
        suspendAccessScene = new Scene(suspendAccessRoot, dashWidth, dashHeight);
        viewMembersScene = new Scene(viewMembersRoot, dashWidth, dashHeight);

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
