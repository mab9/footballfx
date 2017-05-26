package ch.fhnw.oop2.footballfx.core;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.fhnw.oop2.footballfx.core.player.api.PlayerApi;
import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PlayerApi.class, PlayerService.class, PlayerRepository.class })
public class PlayerApiTest extends JpaTest {

    @Inject
    private PlayerApi playerApi;

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
        List<Player> players = playerApi.retrieveAllPlayers();
        Player expectedPlayer = players.get(0);
        playerApi.deletePlayer(expectedPlayer.getId());

        List<Player> actualPlayers = playerApi.retrieveAllPlayers();
        assertThat(actualPlayers).doesNotContain(expectedPlayer);
    }

    @Test
    public void failDeletePlayerNull() {
        playerApi.deletePlayer(null);
    }

    @Test
    public void updatePlayer() {
        Player expectedPlayer = playerApi.retrieveAllPlayers().get(0);
        expectedPlayer.setName("Hakuna");

        playerApi.updatePlayer(expectedPlayer.getId(), expectedPlayer);

        List<Player> actualPlayers = playerApi.retrieveAllPlayers();
        assertThat(actualPlayers).contains(expectedPlayer);
    }

    @Test
    public void failUpdatePlayerNull() {
        playerApi.updatePlayer(null, null);
    }
}
