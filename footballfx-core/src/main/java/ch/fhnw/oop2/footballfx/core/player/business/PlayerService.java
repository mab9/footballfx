package ch.fhnw.oop2.footballfx.core.player.business;

import java.util.List;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerService {

    private PlayerRepository repository;

    public PlayerService(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }

    public List<Player> retrieveAllPlayers() {
        return repository.findAll();
        // throw new WebApplicationException("Not implemented", Response.Status.NOT_FOUND);
    }

    public Player createPlayer(Player player) {
        return repository.addPlayer(player);
    }

    public Player updatePlayer(Player player) {
        return repository.updatePlayer(player);
    }

    public void deletePlayer(Player player) {
        repository.removePlayer(player);
    }
}
