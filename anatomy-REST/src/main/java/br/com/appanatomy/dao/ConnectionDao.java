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

    protected void openDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_anatomy?useUnicode=yes&characterEncoding=UTF-8",
                "root", "solnascente");
    }

    protected void closeDBConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    protected SubTheme retrieveSubThemeByName(String name) throws SQLException {
        return query("SELECT * FROM app_anatomy.sub_theme inner join app_anatomy.question" +
                " on app_anatomy.question.sub_theme_id = app_anatomy.sub_theme.id inner join app_anatomy.answer" +
                " on app_anatomy.question.id = app_anatomy.answer.question_id WHERE app_anatomy.sub_theme.name LIKE '"+ name +"'");
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
                    new Answer(resultSet.getInt(8), resultSet.getString("answer")), retrieveIncorrectAnswers(resultSet.getInt(8))));
        } while (resultSet.next());

        return questions;
    }

    private List<Answer> retrieveIncorrectAnswers(int id) {
        List<Answer> incorrectAnswers = queryRandom ("SELECT * FROM app_anatomy.answer WHERE app_anatomy.answer.id != "+ id +" ORDER BY RAND() LIMIT 3");
        return incorrectAnswers;
    }

    private List<Answer> queryRandom (String query){

        List<Answer> incorrectAnswers = new ArrayList<Answer>();

        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                incorrectAnswers.add(new Answer(resultSet.getInt(1), resultSet.getString("answer")));
            }

        } catch (SQLException e) {
            System.out.println("Consulta Inválida!");
        }
        return incorrectAnswers;
    }
}
