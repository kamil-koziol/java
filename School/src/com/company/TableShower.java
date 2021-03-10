package com.company;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableShower extends JFrame {
    JTable table;
    String[] columnNames = {"id", "name",};
    ArrayList<Object[]> users;

    public TableShower() {
        setSize(1000, 1000);

        users = new ArrayList<Object[]>();

        try {
            PreparedStatement stmt;
            stmt = MySQL.getConnection().prepareStatement("SELECT * FROM users;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Object[] user = new Object[]{id, name};
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Object[][] data = new Object[users.size()][columnNames.length];

        int i = 0;
        for (Object[] user : users) {
            data[i][0] = user[0];
            data[i][1] = user[1];
            i++;
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

