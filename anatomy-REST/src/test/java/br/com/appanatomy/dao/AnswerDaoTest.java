package br.com.appanatomy.dao;

import br.com.appanatomy.model.Answer;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AnswerDaoTest {

    private JdbcDatabaseTester jdbcDatabaseTester;

    @Mock
    private AnswerDao answerDao;

    @Before
    public void setUp() throws Exception {
        jdbcDatabaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/app_anatomy?useUnicode=yes&characterEncoding=UTF-8",
                "root", "solnascente");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdbcDatabaseTester.setDataSet(loader.load("/start.xml"));
        jdbcDatabaseTester.onSetup();
        answerDao = new AnswerDao();
    }

    @Test
    public void shouldFindIncorrectAnswers() throws SQLException, ClassNotFoundException {
        int correctAnswerId = 1;
        List<Answer> incorrectAnswers = answerDao.findIncorrectRandomAnswers(correctAnswerId);

        assertEquals(3, incorrectAnswers.size());

    }

}