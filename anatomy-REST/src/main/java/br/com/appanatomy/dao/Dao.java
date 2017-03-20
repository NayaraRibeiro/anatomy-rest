package br.com.appanatomy.dao;


import java.sql.*;

public class Dao {

    private Connection connection;
    private ResultSet resultSet;
    protected PreparedStatement statement;

    protected void openDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_anatomy?useUnicode=yes&characterEncoding=UTF-8",
                "root", "solnascente");
    }

    protected void closeDBConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    protected ResultSet getResultSet(String query) throws SQLException {
        statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery(query);
        return resultSet;
    }


}
