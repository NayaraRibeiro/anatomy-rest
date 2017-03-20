package br.com.appanatomy.dao;

import br.com.appanatomy.model.SubTheme;

import java.sql.SQLException;

public class SubThemeService {

    public SubTheme findSubThemeByName(String name) throws SQLException, ClassNotFoundException {
        SubThemeDao subThemeDao = new SubThemeDao();
        SubTheme subTheme = subThemeDao.findSubThemeByName(name);
        return subTheme;

    }
}
