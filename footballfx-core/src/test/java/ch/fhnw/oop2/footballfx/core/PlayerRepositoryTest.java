package ch.fhnw.oop2.footballfx.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepositoryInterface;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PlayerRepositoryTest extends JpaTest {

    @Autowired
    private PlayerRepositoryInterface repository;

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
