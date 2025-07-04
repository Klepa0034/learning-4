package org.example.manager;

import org.example.annatation.Component;

import java.sql.Connection;
import java.sql.SQLException;
public interface ConnectionManager {
    Connection getConnection() throws SQLException;

}
