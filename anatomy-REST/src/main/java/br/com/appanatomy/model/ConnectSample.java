package br.com.appanatomy.model;

import br.com.appanatomy.dao.ConnectionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectSample extends ConnectionDao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        open();
        query("SELECT * FROM app_anatomy.sub_theme");
        List<SubTheme> subThemes = getListOfSubTheme();
        close();

    }

    public static List<SubTheme> getListOfSubTheme() throws SQLException {
        List<SubTheme> subThemes = new ArrayList<SubTheme>();
        while (getResultSet().next()) {
            int id = Integer.parseInt(getResultSet().getString("id"));
            String name = getResultSet().getString("name");
            int themeId = Integer.parseInt(getResultSet().getString("theme_id"));
            SubTheme subTheme = new SubTheme(id, name, themeId);
            subThemes.add(subTheme);
        }
        return subThemes;
    }
}
