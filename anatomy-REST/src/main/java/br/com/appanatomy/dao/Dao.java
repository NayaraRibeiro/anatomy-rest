package br.com.appanatomy.dao;


import java.sql.*;

public class Dao {

    private Connection connection;
    private ResultSet resultSet;
    protected PreparedStatement statement;

    protected void openDBConnection(String bd, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        if("app_anatomy".equals(bd)) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd + "?useUnicode=yes&characterEncoding=UTF-8", user, password);
        }
            connection = null;
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
