package br.com.appanatomy.tasks.DAO;

import br.com.appanatomy.tasks.model.Theme;

import java.util.List;

public interface ThemeDAO {
    public void saveOrUpdate(Theme theme);
    public void delete (int themeID);
    public Theme get(int themeID);
    public List<Theme> list();
}
