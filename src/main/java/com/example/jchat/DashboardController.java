package com.example.jchat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

// local classes

import java.io.IOException;
import java.sql.SQLException;

public class DashboardController {

    private FXMLLoader openRoomLoader;
    private FXMLLoader modifyPermissionsLoader;
    private FXMLLoader suspendAccessLoader;
    private FXMLLoader viewMembersLoader;
    private FXMLLoader viewReportsLoader;

    @FXML
    protected void onViewOpenRoomsClick() throws SQLException, IOException {
        openRoomLoader = new FXMLLoader(getClass().getResource("openrooms-screen.fxml"));
        Parent openRoomsRoot = openRoomLoader.load();
        Scene openRoomsScene = new Scene(openRoomsRoot, 1280, 960);
        MainApplication.mainStage.setScene(openRoomsScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewReportLogsClick() throws IOException {
        viewReportsLoader = new FXMLLoader(getClass().getResource("reportedlogs-screen"));
        Parent viewReportsRoot = viewReportsLoader.load();
        Scene viewReportsScene = new Scene(viewReportsRoot, 1280, 960);
        MainApplication.mainStage.setScene(viewReportsScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewMembersClick() throws IOException {
        viewMembersLoader = new FXMLLoader(getClass().getResource("viewmembers-screen.fxml"));
        Parent viewMembersRoot = viewMembersLoader.load();
        Scene viewMembersScene = new Scene(viewMembersRoot, 1280, 960);
        MainApplication.mainStage.setScene(viewMembersScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onModifyUserPermissionsClick() throws IOException {
        modifyPermissionsLoader = new FXMLLoader(getClass().getResource("modifypermissions-screen.fxml"));
        Parent modifyPermissionsRoot = modifyPermissionsLoader.load();
        Scene modifyPermissionsScene = new Scene(modifyPermissionsRoot, 1280, 960);
        MainApplication.mainStage.setScene(modifyPermissionsScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onSuspendUserAccess() throws IOException {
        suspendAccessLoader = new FXMLLoader(getClass().getResource("suspendaccess-screen.fxml"));
        Parent suspendAccessRoot = suspendAccessLoader.load();
        Scene suspendAccessScene = new Scene(suspendAccessRoot, 1280, 960);
        MainApplication.mainStage.setScene(suspendAccessScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onReturnToDashboardClick() {
        MainApplication.mainStage.setScene(MainApplication.dashboardScene );
        MainApplication.mainStage.show();
    }

}