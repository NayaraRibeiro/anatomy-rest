package br.com.appanatomy.controller;

import br.com.appanatomy.dao.SubThemeDao;
import br.com.appanatomy.model.SubTheme;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/rest")
public class QuestionsController {
    @RequestMapping(value = "/questions", method = RequestMethod.GET, produces = ("application/json;charset=UTF-8"))
    public String getQuestions (@RequestParam(value="subtheme") String subTheme) throws SQLException, ClassNotFoundException {
        SubThemeDao subThemeDao = new SubThemeDao();
        JSONObject subThemes = subThemeDao.getSubTheme(subTheme);
        return subThemes.toString();
    }

}
