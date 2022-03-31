package com.example.jchat;


// SQL Imports
import java.sql.*;

public class SQLDriver {
    Connection conn = createConnection("25.95.108.108", "3307", "csc340", "testuser", "1234");
    public SQLDriver() throws SQLException {
    }

    public Connection createConnection(String ip, String port, String schema, String user, String pass) throws SQLException {
        String connectionFormat = String.format("jdbc:mysql://%s:%s/%s", ip, port, schema);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Check if the user has the driver
        } catch (Exception e) {
            e.printStackTrace();
        }
            Connection conn = DriverManager.getConnection(connectionFormat, user, pass); // Connect to db
            return conn;
    }

    public Boolean signUpUser(Connection conn, String user, String pass) throws SQLException {
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
        String sqlQueryFormat = String.format("INSERT INTO user_login (username, pass, permission) VALUES ('%s', '%s', 'default');", user, pass);
        statement.executeUpdate(sqlQueryFormat);
        return true;

    }


    public static void testConnection(String ip, String port, String schema, String user, String pass) throws SQLException {
             String connectionFormat = String.format("jdbc:mysql://%s:%s/%s", ip, port, schema);
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection(connectionFormat, user, pass);
            System.out.println(connectionFormat);
            Connection conn = DriverManager.getConnection(connectionFormat, user, pass);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM loginuser;");
            while (result.next()) {
                System.out.println(result.getString(1));
            }
//            System.out.println(conn.isValid(6));
//            System.out.println(conn.getSchema());
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("There was an error trying to connect to the database...\n" + e);
        }
    }
    public Boolean loginUser(Connection conn, String username, String password) throws SQLException {
        /**
         * iterate all users and passwords until match found
         * if no found return false
         * if return true
         */
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM user_login;");
        while(result.next()){
            if(result.getString("username").equals(username) &&  result.getString("pass").equals(password)){
                return true;
            }
        }
        return false;
    }
}
