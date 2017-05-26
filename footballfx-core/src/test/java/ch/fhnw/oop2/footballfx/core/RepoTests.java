package ch.fhnw.oop2.footballfx.core;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepo;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerRepo repository;

    private final String INSERT_DATA_SCRIPT = "import.sql";

    @Before
    public void setup() throws SQLException {
        ScriptUtils.executeSqlScript(
                jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(INSERT_DATA_SCRIPT));
    }

    @Test
    public void savePlayer() {
        Player expectedPlayer = new Player();
        expectedPlayer.setName("Hakuna");
        expectedPlayer.setId(UUID.randomUUID());
        entityManager.persist(expectedPlayer);

        Iterable<Player> actualPlayers = repository.findAll();
        assertThat(actualPlayers).contains(expectedPlayer);
    }
}
