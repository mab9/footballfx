package ch.fhnw.oop2.footballfx.core;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.oop2.footballfx.core.api.FootballApi;
import ch.fhnw.oop2.footballfx.core.business.FootballService;
import ch.fhnw.oop2.footballfx.core.dataaccess.FootballRepository;
import ch.fhnw.oop2.footballfx.core.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FootballApi.class, FootballService.class, FootballRepository.class })
@EnableConfigurationProperties
public class FootballApiTest {

    @Inject
    private FootballApi footballApi;

    @Test
    public void contextLoad() {
        assertThat(footballApi).isNotNull();
    }

    @Test
    public void retrieveAllPlayers() {
        List<Player> players = footballApi.retrieveAllPlayers();
        assertThat(players).isNotNull();
    }

    @Test
    public void createPlayer() {
        Player player = new Player();
        player.setName("Hakuna");
        Player expectedPlayer = footballApi.createPlayer(player);

        List<Player> actualPlayers = footballApi.retrieveAllPlayers();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void failCreatePlayerNull() {
        footballApi.createPlayer(null);
    }

    @Test
    public void deletePlayer() {
        Player player = new Player();
        player.setName("Hakuna");
        footballApi.deletePlayer(player);

        List<Player> actuealPlayers = footballApi.retrieveAllPlayers();
        assertThat(actuealPlayers).doesNotContain(player);
    }

    @Test
    public void failDeletePlayerNull() {
        footballApi.deletePlayer(null);
    }

    @Test
    public void updatePlayer() {
        Player expectedPlayer = footballApi.retrieveAllPlayers().get(0);
        expectedPlayer.setName("Hakuna");

        footballApi.updatePlayer(expectedPlayer);

        List<Player> actualPlayers = footballApi.retrieveAllPlayers();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void failUpdatePlayerNull() {
        footballApi.updatePlayer(null);
    }
}
