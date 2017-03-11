package br.com.appanatomy.dao;

import br.com.appanatomy.model.Question;
import br.com.appanatomy.model.SubTheme;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class SubThemeDao extends ConnectionDao{

    public JSONObject getSubTheme (String st) throws SQLException, ClassNotFoundException {

        open();
        query("SELECT * FROM app_anatomy.sub_theme WHERE app_anatomy.sub_theme.name LIKE '%" + st + "%' ");
        SubTheme subTheme = getSubTheme();
        close();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", subTheme.getId());
        jsonObject.put("subTheme", subTheme.getName());
        jsonObject.put("questions", subTheme.getQuestions());

        return jsonObject;
    }

}
