package main.com.bsuir.autoservice.dao.database;

import main.com.bsuir.autoservice.dao.exception.DaoException;

import java.sql.*;
import java.util.List;

public interface IDatabase {
    Connection getConnection() throws SQLException;
    void returnConnection(Connection connection) throws SQLException;
    List<String> getListTableNames() throws SQLException;
}
