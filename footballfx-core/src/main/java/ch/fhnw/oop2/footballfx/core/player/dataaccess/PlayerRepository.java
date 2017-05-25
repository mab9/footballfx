package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerRepository {

    @Autowired
    private PlayerRepo repo;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public PlayerRepository() {
    }

    public Iterable<Player> findAll() {
        return repo.findAll();
    }

    public Player updatePlayer(Player player) {
        return player;
    }

    public void removePlayer(Player player) {

    }

    public Player createPlayer(Player player) {
        return repo.save(player);
    }
}
