package br.com.appanatomy.dao;

import br.com.appanatomy.model.Answer;
import br.com.appanatomy.model.Question;
import br.com.appanatomy.model.SubTheme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDao {

    private Connection connection;

    private ResultSet resultSet;

    private PreparedStatement statement;

    protected SubTheme retrieveSubThemeByName(String name) throws SQLException {
        return query("SELECT * FROM app_anatomy.sub_theme inner join app_anatomy.question" +
                " on app_anatomy.question.sub_theme_id = app_anatomy.sub_theme.id inner join app_anatomy.answer" +
                " on app_anatomy.question.id = app_anatomy.answer.question_id WHERE app_anatomy.sub_theme.name LIKE '"+ name +"'");
    }

    protected void openDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_anatomy?useUnicode=yes&characterEncoding=UTF-8",
                "root", "solnascente");
    }

    protected void closeDBConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    private SubTheme query(String query) {

        SubTheme subTheme = new SubTheme();

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery(query);
            resultSet.next();
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            subTheme = new SubTheme(id, name, retrieveQuestions(resultSet));

        } catch (SQLException e) {
            System.out.println("Consulta Inválida!");
        }

        return subTheme;

    }

    private List<Question> retrieveQuestions(ResultSet resultSet) throws SQLException {

        List<Question> questions = new ArrayList<Question>();
        do {
            questions.add(new Question(resultSet.getInt(4), resultSet.getString("title"),
                    new Answer(resultSet.getInt(8), resultSet.getString("answer"))));
        } while (resultSet.next());

        return questions;
    }

}
