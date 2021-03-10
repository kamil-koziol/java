package com.company;

import com.company.dziedziczenie.Konto;
import com.company.dziedziczenie.KontoPremium;
import com.company.dziedziczenie.WorkingWithAccounts;
import com.mysql.cj.xdevapi.Table;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException {
            try {
                MySQL.connect();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

//        WorkingWithArrays.main();
//        GeometryMenu.main();
//        WorkingWithFiles.main();
//        WorkingWithAccounts.main();
//            WorkingWithDatabases.main();
        TableShower tableShower = new TableShower();
//            MySQL.disconnect();
    }
}
