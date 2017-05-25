package ch.fhnw.oop2.footballfx.core;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
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
        org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript(
                jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(INSERT_DATA_SCRIPT));
    }

    @Test
    public void savePlayers() {
        Player expectedPlayer = new Player();
        expectedPlayer.setName("Hakuna");

        entityManager.persist(expectedPlayer);

        Iterable<Player> actualPlayers = repository.findAll();
        actualPlayers.forEach(player -> System.out.println(player.getName()));
        Player p = actualPlayers.iterator().next();
        assertThat(p.getName()).isEqualTo(expectedPlayer.getName());
    }
}
