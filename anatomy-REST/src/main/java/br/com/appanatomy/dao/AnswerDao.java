package br.com.appanatomy.dao;


import br.com.appanatomy.model.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDao extends Dao{

    public List<Answer> findIncorrectRandomAnswers(int correctAnswerId) throws SQLException, ClassNotFoundException {
        openDBConnection();
        List<Answer> incorrectAnswers = buildIncorrectRandomAnswersByQuery("SELECT * FROM app_anatomy.answer " +
                "WHERE app_anatomy.answer.id != " + correctAnswerId + " ORDER BY RAND() LIMIT 3");
        closeDBConnection();
        return incorrectAnswers;
    }

    private List<Answer> buildIncorrectRandomAnswersByQuery(String query){

        List<Answer> incorrectAnswers = new ArrayList<Answer>();
        try {
            ResultSet resultSet = getResultSet(query);
            while (resultSet.next()){
                incorrectAnswers.add(retrieveIncorrectAnswer(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Consulta Inválida!");
        }
        return incorrectAnswers;
    }

    private Answer retrieveIncorrectAnswer(ResultSet resultSet) throws SQLException {
        return new Answer(resultSet.getInt(1), resultSet.getString("answer"));
    }

}