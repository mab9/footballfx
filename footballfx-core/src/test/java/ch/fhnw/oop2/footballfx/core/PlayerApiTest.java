package ch.fhnw.oop2.footballfx.core;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.oop2.footballfx.core.player.api.PlayerApi;
import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PlayerApi.class, PlayerService.class, PlayerRepository.class })
@EnableConfigurationProperties
public class PlayerApiTest {

    @Inject
    private PlayerApi playerApi;

    @Test
    public void contextLoad() {
        assertThat(playerApi).isNotNull();
    }

    @Test
    public void retrieveAllPlayers() {
        List<Player> players = playerApi.retrieveAllPlayers();
        assertThat(players).isNotNull();
    }

    @Test
    public void createPlayer() {
        Player player = new Player();
        player.setName("Hakuna");
        Player expectedPlayer = playerApi.createPlayer(player);

        List<Player> actualPlayers = playerApi.retrieveAllPlayers();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void failCreatePlayerNull() {
        playerApi.createPlayer(null);
    }

    @Test
    public void deletePlayer() {
        Player player = new Player();
        player.setName("Hakuna");
        playerApi.deletePlayer(player);

        List<Player> actuealPlayers = playerApi.retrieveAllPlayers();
        assertThat(actuealPlayers).doesNotContain(player);
    }

    @Test
    public void failDeletePlayerNull() {
        playerApi.deletePlayer(null);
    }

    @Test
    public void updatePlayer() {
        Player expectedPlayer = playerApi.retrieveAllPlayers().get(0);
        expectedPlayer.setName("Hakuna");

        playerApi.updatePlayer(expectedPlayer);

        List<Player> actualPlayers = playerApi.retrieveAllPlayers();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void failUpdatePlayerNull() {
        playerApi.updatePlayer(null);
    }
}
