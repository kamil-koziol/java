package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private static Connection connection;

    public static boolean isConnected() {
        return connection != null;
    }

    public static void connect() throws SQLException {
        if(!isConnected()) {
            String host = "localhost";
            String port = "3306";
            String database = "java";
            String username = "root";
            String password = "root1234";
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false", username, password);
        }
    }

    public static void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
