package br.com.appanatomy.dao;

import br.com.appanatomy.model.SubTheme;
import org.json.JSONObject;

import java.sql.SQLException;

public class SubThemeDao extends ConnectionDao{

    public JSONObject getSubThemeByName(String name) throws SQLException, ClassNotFoundException {

        openDBConnection();
        SubTheme subTheme = retrieveSubThemeByName(name);
        closeDBConnection();
        return buildSubThemeJSON(subTheme);

    }

    private JSONObject buildSubThemeJSON(SubTheme subTheme) {

        JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", subTheme.getId());
            jsonObject.put("subTheme", subTheme.getName());
            jsonObject.put("questions", subTheme.getQuestions());

        return jsonObject;

    }
}
