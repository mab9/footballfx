package ch.fhnw.oop2.footballfx.core;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepositoryInterface;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PlayerRepositoryTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayerRepositoryInterface repository;

    private final String INSERT_DATA_SCRIPT = "import.sql";

    @Before
    public void setup() throws SQLException {
        ScriptUtils.executeSqlScript(
                jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(INSERT_DATA_SCRIPT));
    }

    @Test
    public void savePlayer() {
        Player player = new Player();
        player.setName("Hakuna");
        Player expectedPlayer = repository.save(player);

        Iterable<Player> actualPlayers = repository.findAll();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void updatePlayer() {
        Iterable<Player> players = repository.findAll();
        Player expectedPlayer = players.iterator().next();

        expectedPlayer.setName("lecce");
        repository.save(expectedPlayer);

        Player actualPlayer = repository.findOne(expectedPlayer.getId());
        assertThat(actualPlayer.getId()).isEqualTo(expectedPlayer.getId());
        assertThat(actualPlayer.getName()).isEqualTo(expectedPlayer.getName());
    }

    @Test
    public void deletePlayer() {
        Iterable<Player> players = repository.findAll();
        Player expectedPlayer = players.iterator().next();

        repository.delete(expectedPlayer);
        Iterable<Player> actualPlayers = repository.findAll();
        assertThat(actualPlayers).doesNotContain(expectedPlayer);
    }

    @Test
    public void findAllPlayer() {
        Iterable<Player> actualPlayers = repository.findAll();
        assertThat(actualPlayers).isNotNull();
    }
}
