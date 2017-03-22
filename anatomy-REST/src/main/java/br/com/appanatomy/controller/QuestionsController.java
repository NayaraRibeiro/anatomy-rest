package br.com.appanatomy.controller;

import br.com.appanatomy.dao.SubThemeService;
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

    @RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestions (@RequestParam(value="subtheme") String subThemeName) throws SQLException, ClassNotFoundException {
        SubThemeService subThemeService = new SubThemeService();
        SubTheme subTheme = subThemeService.findSubThemeByName(subThemeName);
        return buildSubThemeJSON(subTheme);
    }

    private String buildSubThemeJSON(SubTheme subTheme) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", subTheme.getId());
        jsonObject.put("subTheme", subTheme.getName());
        jsonObject.put("questions", subTheme.getQuestions());

        return jsonObject.toString();

    }
}
