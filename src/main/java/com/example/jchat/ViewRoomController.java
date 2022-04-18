package com.example.jchat;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRoomController extends ChatroomController
        implements
        Initializable {

    @FXML
    private TableView<Room> tableView;
    @FXML
    private TableColumn<Room, String> idColumn;
    @FXML
    private TableColumn<Room, String> nameColumn;
    @FXML
    private TableColumn<Room, String> operationColumn;
    @FXML
    private TableColumn<Room, String> stopColumn;
    @FXML
    private TableColumn<Room, String> removeColumn;

    ObservableList<Room> rooms;
    SQLDriver sqld;

    @FXML
    public void onTableClick() throws IOException {
        ObservableList<Room> roomList;
        roomList = tableView.getSelectionModel().getSelectedItems();
        if (roomList.isEmpty()) {
            return;
        }

        // ChatroomController chr = MainApplication.openLoader.getController();
        // chr.setLabelName("bruh");
        // chr.setChatRoom(roomList.get(0));

        onOpenRoomClick(roomList.get(0));
    }

    public void printRow(Room item) {
        System.out.println(item.getRoomName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            sqld = new SQLDriver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Create all the columns for the table
        // TableColumn<Room, String> roomColumn = new TableColumn("Room Name");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        // roomColumn.setCellValueFactory(cellData -> cellData.getValue().);
        // TableColumn<Room, String> timeColumn = new TableColumn("Time
        // Created");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        // TableColumn<Room, String> capacityColumn = new TableColumn("Room
        // Capacity");
        // capacityColumn
        // .setCellValueFactory(new PropertyValueFactory<>("capacity"));

        stopColumn.setCellFactory((col) -> {

            TableCell<Room, String> cell = new TableCell<Room, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("S");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {

                    });

                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

        removeColumn.setCellFactory((col) -> {

            TableCell<Room, String> cell = new TableCell<Room, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("R");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {
                        System.out.println(getIndex());
                        try {
                            sqld.removeRoom(rooms.get(getIndex()).getId());
                            rooms.remove(getIndex());
                        } catch (SQLException e) {
                            e.printStackTrace();
                            new Alert(AlertType.ERROR, e.getMessage())
                                    .showAndWait();
                        }
                    });

                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        this.setGraphic(button);
                    }
                }
            };
            return cell;
        });

        // tableView.getColumns().addAll(roomColumn, timeColumn,
        // capacityColumn);
        try {
            rooms = FXCollections.observableArrayList(sqld.viewRooms());
            tableView.setItems(rooms);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
