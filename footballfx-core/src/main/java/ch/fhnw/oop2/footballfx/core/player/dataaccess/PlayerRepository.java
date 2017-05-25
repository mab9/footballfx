package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public PlayerRepository() {
    }

    public List<Player> findAll() {
        return null;
    }

    public Player updatePlayer(Player player) {
        return player;
    }

    public void removePlayer(Player player) {

    }

    public Player addPlayer(Player player) {
        return player;
    }
}
