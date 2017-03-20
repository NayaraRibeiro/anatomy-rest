package br.com.appanatomy.dao;

import br.com.appanatomy.model.Answer;
import br.com.appanatomy.model.Question;
import br.com.appanatomy.model.SubTheme;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubThemeDao extends Dao {

    public SubTheme findSubThemeByName(String name) throws SQLException, ClassNotFoundException {
        openDBConnection();
        SubTheme subTheme = buildSubThemeByQuery("SELECT * FROM app_anatomy.sub_theme inner join app_anatomy.question" +
                " on app_anatomy.question.sub_theme_id = app_anatomy.sub_theme.id inner join app_anatomy.answer" +
                " on app_anatomy.question.id = app_anatomy.answer.question_id WHERE app_anatomy.sub_theme.name LIKE '"+ name +"'");
        closeDBConnection();

        return subTheme;
    }

    private SubTheme buildSubThemeByQuery(String query) {

        SubTheme subTheme = new SubTheme();
        try {
            ResultSet resultSet = getResultSet(query);
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
            questions.add(retrieveQuestion(resultSet));
        } while (resultSet.next());
        return questions;
    }

    private Question retrieveQuestion(ResultSet resultSet) throws SQLException {
        AnswerDao answerDao = new AnswerDao();
        return new Question(resultSet.getInt(4),
                            resultSet.getString("title"),
                            retrieveCorrectAnswer(resultSet),
                            answerDao.findIncorrectRandomAnswers(resultSet.getInt(8)));
    }

    private Answer retrieveCorrectAnswer(ResultSet resultSet) throws SQLException {
        return new Answer(resultSet.getInt(8), resultSet.getString("answer"));
    }

}