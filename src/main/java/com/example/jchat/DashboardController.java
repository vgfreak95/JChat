package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardController {

    @FXML
    private TableView<Room> table_view;
    @FXML
    private TableColumn<Room, String> roomColumn;
    @FXML
    private TableColumn<Room, String> timeColumn;
    @FXML
    private TableColumn<Room, String> capacityColumn;

    @FXML
    protected void onNewChatClick() {
        MainApplication.mainStage.setScene(MainApplication.chatroomScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewReportLogsClick() {
        MainApplication.mainStage.setScene(MainApplication.reportedLogsScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewMembersClick() {
        MainApplication.mainStage.setScene(MainApplication.viewMembersScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onModifyUserPermissionsClick() {
        MainApplication.mainStage.setScene(MainApplication.modifyPermissionsScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onViewOpenRoomsClick() throws SQLException {

        MainApplication.mainStage.setScene(MainApplication.openRoomsScene);
        MainApplication.mainStage.show();

        SQLDriver sqld = new SQLDriver();
        // Create all the columns for the table
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("roomname"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("create_time"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        ArrayList<Room> rooms = sqld.viewRooms(sqld.conn);

//        for (Room room : rooms) {
        table_view.getItems().add(new Room("bruh","bruh", "bruh"));
//        }

    }
    @FXML
    protected void onSuspendUserAccess() {
        MainApplication.mainStage.setScene(MainApplication.suspendAccessScene );
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onReturnToDashboardClick() {
        MainApplication.mainStage.setScene(MainApplication.dashboardScene );
        MainApplication.mainStage.show();
    }

}