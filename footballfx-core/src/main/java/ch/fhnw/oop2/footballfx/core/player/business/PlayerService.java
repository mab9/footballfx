package ch.fhnw.oop2.footballfx.core.player.business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerService {

    private PlayerRepository repository;

    public PlayerService(PlayerRepository playerRepository) {
        this.repository = playerRepository;
    }

    public List<Player> retrieveAllPlayers() {
        Iterable<Player> players = repository.findAll();
        List<Player> players1 = new ArrayList<>();
        players.forEach(players1::add);
        return players1;
    }

    public Player createPlayer(Player player) {
        return repository.createPlayer(player);
    }

    public Player updatePlayer(UUID id, Player player) {
        Player update = repository.findById(id);
        if (!update.getId().equals(player.getId())) {
            throw new WebApplicationException("Player: " + player.getId() + " not found.", Response.Status.NOT_FOUND);
        }
        return repository.updatePlayer(player);
    }

    public void deletePlayer(UUID id) {
        Player update = repository.findById(id);
        if (update == null) {
            throw new WebApplicationException("Player: " + id + " not found.", Response.Status.NOT_FOUND);
        }
        repository.removePlayer(id);
    }
}
