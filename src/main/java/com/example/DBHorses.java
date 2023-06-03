package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHorses {
    private static final String URL = "jdbc:postgresql://localhost:5432/horses";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "9856";

    private Connection connection;

    public DBHorses() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
