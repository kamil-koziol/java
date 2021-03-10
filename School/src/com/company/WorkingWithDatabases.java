package com.company;

import java.sql.*;
import java.util.Random;

public class WorkingWithDatabases {


    public static void main()  {
        try {
            MySQL.connect();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(MySQL.isConnected()) {
            try {
                PreparedStatement stmt;
                stmt = MySQL.getConnection().prepareStatement("SELECT * FROM users;");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    System.out.println("id " + id + " name: " + name);
                }
//                stmt = MySQL.getConnection().prepareStatement("INSERT INTO users(name) VALUES (?)");
//                stmt.setString(1, "Imie");
//                stmt.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
