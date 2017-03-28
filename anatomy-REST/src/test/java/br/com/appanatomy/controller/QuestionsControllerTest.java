package br.com.appanatomy.controller;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class QuestionsControllerTest {

    private QuestionsController questionsController;

    @Before
    public void setUp(){
        questionsController = new QuestionsController();
    }

    @Test
    public void shouldGetJsonBySubThemeName() throws SQLException, ClassNotFoundException {
        String subThemeName = "Ossos do Crânio";
        String json = questionsController.getQuestions(subThemeName);
        assertEquals(json.contains("Ossos do crânio"), true);
    }
}
