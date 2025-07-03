package org.example.connection.impl;

import org.example.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerImpl implements ConnectionManager {
    private String name;
    private String url;
    private String password;
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }
}
