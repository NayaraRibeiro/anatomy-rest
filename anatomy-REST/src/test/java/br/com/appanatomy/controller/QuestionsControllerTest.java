package br.com.appanatomy.controller;

import br.com.appanatomy.dao.SubThemeService;
import br.com.appanatomy.model.Answer;
import br.com.appanatomy.model.Question;
import br.com.appanatomy.model.SubTheme;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class QuestionsControllerTest {

    private QuestionsController questionsController;

    private SubThemeService subThemeService;

    @Mock
    private List<Question> questions;

    @Before
    public void setUp(){
        questionsController = new QuestionsController();
        subThemeService = new SubThemeService();
    }

    @Test
    public void shouldGetJsonBySubThemeName() throws SQLException, ClassNotFoundException {
        String subThemeName = "Ossos do Crânio";

        String json = questionsController.getQuestions(subThemeName);

        assertEquals(json.contains("Ossos do crânio"), true);
        assertEquals(json.contains("Onde estão inseridos os dentes superiores?"), true);
        assertEquals(json.contains("Osso Maxila"), true);
    }
}