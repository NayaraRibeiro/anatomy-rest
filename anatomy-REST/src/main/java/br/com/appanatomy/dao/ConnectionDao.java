package br.com.appanatomy.dao;

import br.com.appanatomy.model.Question;
import br.com.appanatomy.model.SubTheme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDao {

    private static Connection connection;

    private static ResultSet resultSet;

    private static PreparedStatement statement;

    public static void open() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_anatomy",
                "root", "solnascente");
    }

    public static void query(String query) throws SQLException {
        statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery(query);

    }

    public static ResultSet getResultSet(){
        return resultSet;
    }

    public static void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public static SubTheme getSubTheme() throws SQLException {
        SubTheme subTheme = new SubTheme();
        while (getResultSet().next()) {
            int id = Integer.parseInt(getResultSet().getString("id"));
            String name = getResultSet().getString("name");
            int themeId = Integer.parseInt(getResultSet().getString("theme_id"));
            subTheme = new SubTheme(id, name, themeId);
        }
        return subTheme;
    }

    private static List<Question> retrieveQuestions(ResultSet resultSet) {

        List<Question> questions = null;

        return questions;
    }


}
