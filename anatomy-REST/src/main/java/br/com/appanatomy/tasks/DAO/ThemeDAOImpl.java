package br.com.appanatomy.tasks.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import br.com.appanatomy.tasks.model.Theme;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.activation.DataSource;
import java.util.List;

public class ThemeDAOImpl implements ThemeDAO {
    private JdbcTemplate jdbcTemplate;

    public ThemeDAOImpl (DataSource dataSource) {
        jdbcTemplate = new jdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Theme theme){
        if (theme.getId() > 0) {
            String sql = "UPDATE theme SET name=? WHERE theme_id=?";
            jdbcTemplate.update(sql, theme.getName(), theme.getId());
        } else {
            String sql = "INSERT INTO them (id, name)"
                    + " VALUES (?, ?)";
            jdbcTemplate.update(sql, theme.getId(), theme.getName();
        }
    }

    @Override
    public void delete(int themeId){
        String sql = "DELETE FROM theme WHERE theme_id=?";
        jdbcTemplate.update(sql, themeId);
    }

    @Override
    public List<Theme> list() {
        String sql = "SELECT * FROM theme";
        List<Theme> listTheme = jdbcTemplate.query(sql, new RowMapper<Theme>() {

            @Override
            public Theme mapRow(ResultSet rs, int rowNum) throws SQLException {
                Theme aTheme = new Theme();

                aTheme.setId(rs.getInt("theme_id"));
                aTheme.setName(rs.getString("name"));

                return aTheme;
            }

        });

        return listTheme;
    }

    @Override
    public Theme get(int themeId) {
        String sql = "SELECT * FROM theme WHERE theme_id=" + themeId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Theme>() {

            @Override
            public Theme extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Theme theme = new Theme();
                    theme.setId(rs.getInt("theme_id"));
                    theme.setName(rs.getString("name"));
                    return theme;
                }
                return null;
            }

        });
    }
}
