package com.example.jchat;

// SQL Imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import java.sql.*;
import java.util.ArrayList;

import com.example.jchat.Room;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SQLDriver {

    private String username;

    Connection conn = createConnection(
            "aws-csc-340.cci2srkkj23u.us-east-2.rds.amazonaws.com", "3306",
            "csc340", "admin", "awscsc340");

    public SQLDriver() throws SQLException {
    }

    public Connection createConnection(String ip, String port, String schema,
                                       String user, String pass) throws SQLException {
        String connectionFormat = String.format("jdbc:mysql://%s:%s/%s", ip,
                port, schema);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Check if the user has
            // the driver
        } catch (Exception e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(connectionFormat, user,
                pass); // Connect to db
        return conn;
    }

    public Boolean signUpUser(Connection conn, String user, String pass)
            throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM user_login");

        // When the username already exists
        while (res.next()) {
            System.out.println((res.getString(2)));
            if (res.getString("username").equals(user)) {
                return false;
            }
        }

        // When the username doesn't exist
        statement = conn.createStatement();
        String sqlQueryFormat = String.format(
                "INSERT INTO user_login (username, pass, permission) VALUES ('%s', '%s', 'default');",
                user, pass);
        statement.executeUpdate(sqlQueryFormat);
        this.username = user;
        return true;

    }

    public ArrayList<Room> viewRooms() throws SQLException {
        // final ObservableList<String> data =
        // FXCollections.observableArrayList();
        ArrayList<Room> roomList = new ArrayList<Room>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM room");

        // Add the columns to the table
        while (result.next()) {
            String room_name = result.getString("roomname");
            String create_time = result.getString("create_time");
            String capacity = result.getString("capacity");
            String id = result.getString("room_id");
            roomList.add(new Room(room_name, create_time, capacity, id));
        }
        return roomList;
    }

    public void removeRoom(String id) throws SQLException {
        // final ObservableList<String> data =
        // FXCollections.observableArrayList();
        PreparedStatement st = conn
                .prepareStatement("delete  FROM room where room_id=?");
        st.setString(1, id);
        st.executeUpdate();
        st.close();
    }

    public ArrayList<User> getUsers() throws SQLException {
        // final ObservableList<String> data =
        // FXCollections.observableArrayList();
        ArrayList<User> userList = new ArrayList<User>();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM user_login");

        // Add the columns to the table
        while (result.next()) {
            String name = result.getString("username");
            String id = result.getString("id");
            String permission = result.getString("permission");
            userList.add(new User(id, name, permission));
        }
        return userList;
    }

    public void removeUser(String id) throws SQLException {
        // final ObservableList<String> data =
        // FXCollections.observableArrayList();
        PreparedStatement st = conn
                .prepareStatement("delete  FROM user_login where id=?");
        st.setString(1, id);
        st.executeUpdate();
        st.close();
    }

    public void changeUser(String id, String permission) throws SQLException {
        // final ObservableList<String> data =
        // FXCollections.observableArrayList();
        PreparedStatement st = conn.prepareStatement(
                "update user_login set permission=? where id=?");
        st.setString(1, permission);
        st.setString(2, id);
        st.executeUpdate();
        st.close();
    }

    public static void testConnection(String ip, String port, String schema,
                                      String user, String pass) throws SQLException {
        String connectionFormat = String.format("jdbc:mysql://%s:%s/%s", ip,
                port, schema);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection conn = DriverManager.getConnection(connectionFormat,
            // user, pass);
            System.out.println(connectionFormat);
            Connection conn = DriverManager.getConnection(connectionFormat,
                    user, pass);
            Statement statement = conn.createStatement();
            ResultSet result = statement
                    .executeQuery("SELECT * FROM loginuser;");
            while (result.next()) {
                System.out.println(result.getString(1));
            }
            // System.out.println(conn.isValid(6));
            // System.out.println(conn.getSchema());
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("There was an error trying to connect to the
            // database...\n" + e);
        }
    }

    public Boolean loginUser(Connection conn, String username, String password)
            throws SQLException {
        /**
         * iterate all users and passwords until match found if no found return
         * false if return true
         */
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM user_login;");
        while (result.next()) {
            if (result.getString("username").equals(username)
                    && result.getString("pass").equals(password)) {
                return true;
            }
        }
        return false;
    }
}