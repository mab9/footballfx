package ch.fhnw.oop2.footballfx.core.player.business;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerService {

    private final PlayerRepository footballRepository;

    public PlayerService(PlayerRepository footballRepository) {
        this.footballRepository = footballRepository;
    }

    public List<Player> retrieveAllPlayers() {
        throw new WebApplicationException("Not implemented", Response.Status.NOT_FOUND);
    }

    public Player createPlayer(Player player) {
        return null;
    }

    public Player updatePlayer(Player player) {
        return null;
    }

    public void deletePlayer(Player player) {

    }
}
