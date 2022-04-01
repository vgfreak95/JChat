package com.example.jchat;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewRoomController extends DashboardController implements Initializable {

    @FXML private TableView<Room> tableView;
    @FXML private TableColumn<Room, String> roomColumn;
    @FXML private TableColumn<Room, String> timeColumn;
    @FXML private TableColumn<Room, String> capacityColumn;


    @FXML
    public void onTableClick() {
        ObservableList<Room> roomList;
        roomList = tableView.getSelectionModel().getSelectedItems();
        System.out.println(roomList.get(0).getRoomName());
    }

    public void printRow(Room item) {
        System.out.println(item.getRoomName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SQLDriver sqld = null;
        try {
            sqld = new SQLDriver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Create all the columns for the table
//        TableColumn<Room, String> roomColumn = new TableColumn("Room Name");
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
//        roomColumn.setCellValueFactory(cellData -> cellData.getValue().);
//        TableColumn<Room, String> timeColumn = new TableColumn("Time Created");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("createTime"));
//        TableColumn<Room, String> capacityColumn = new TableColumn("Room Capacity");
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        tableView.getColumns().addAll(roomColumn, timeColumn, capacityColumn);

        ArrayList<Room> rooms = null;
        try {
            rooms = sqld.viewRooms(sqld.conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Room room : rooms) {
            System.out.println(room.getRoomName() + " " + room.getCreateTime() + " " + room.getCapacity());
            tableView.getItems().add(new Room(room.getRoomName(), room.getCreateTime(), room.getCapacity()));
        }
    }
}
