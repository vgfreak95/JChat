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

public class ViewMemberController extends ChatroomController
        implements
        Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> idColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> operationColumn;
    @FXML
    private TableColumn<User, String> AColumn;
    @FXML
    private TableColumn<User, String> MColumn;
    @FXML
    private TableColumn<User, String> DColumn;
    @FXML
    private TableColumn<User, String> removeColumn;

    ObservableList<User> users;
    SQLDriver sqld;

    @FXML
    public void onTableClick() throws IOException {
        ObservableList<User> UserList;
        UserList = tableView.getSelectionModel().getSelectedItems();
        if (UserList.isEmpty()) {
            return;
        }

    }

    public void printRow(User item) {
        System.out.println(item.getName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            sqld = new SQLDriver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Create all the columns for the table
        // TableColumn<User, String> UserColumn = new TableColumn("User Name");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        // UserColumn.setCellValueFactory(cellData -> cellData.getValue().);
        // TableColumn<User, String> timeColumn = new TableColumn("Time
        // Created");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // TableColumn<User, String> capacityColumn = new TableColumn("User
        // Capacity");
        // capacityColumn
        // .setCellValueFactory(new PropertyValueFactory<>("capacity"));

        AColumn.setCellFactory((col) -> {
            TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("A");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {
                        try {
                            sqld.changeUser(users.get(getIndex()).getId(),
                                    "admin");
                            users.get(getIndex()).getId();
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

        MColumn.setCellFactory((col) -> {
            TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("M");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {
                        try {
                            sqld.changeUser(users.get(getIndex()).getId(),
                                    "moderator");
                            users.get(getIndex()).getId();
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

        DColumn.setCellFactory((col) -> {
            TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("D");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {
                        try {
                            sqld.changeUser(users.get(getIndex()).getId(),
                                    "default");
                            users.get(getIndex()).getId();
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

        removeColumn.setCellFactory((col) -> {

            TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    Button button = new Button("R");
                    button.setStyle(
                            "-fx-background-color: #00bcff;-fx-text-fill: #ffffff");

                    button.setOnMouseClicked((col) -> {
                        System.out.println(getIndex());
                        try {
                            sqld.removeUser(users.get(getIndex()).getId());
                            users.remove(getIndex());
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

        try {
            users = FXCollections.observableArrayList(sqld.getUsers());
            tableView.setItems(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}