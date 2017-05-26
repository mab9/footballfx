package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerRepository {

    @Autowired
    private PlayerRepositoryInterface repository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public PlayerRepository() {
    }

    public Iterable<Player> findAll() {
        return repository.findAll();
    }

    public Player findById(UUID id) {
        return repository.findOne(id);
    }

    public Player updatePlayer(Player player) {
        repository.save(player);
        return player;
    }

    public void removePlayer(UUID id) {
        repository.delete(id);
    }

    public Player createPlayer(Player player) {
        return repository.save(player);
    }
}
