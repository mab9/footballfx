package ch.fhnw.oop2.footballfx.core.base;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class InitialContextLoader {

    private final String INSERT_DATA_SCRIPT = "import.sql";
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public InitialContextLoader() {
    }

    public void init() {
        try {
            ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(),
                    new ClassPathResource(INSERT_DATA_SCRIPT));
        } catch (SQLException e) {
            log.error("Could not load initial data", e);
        }
    }
}
