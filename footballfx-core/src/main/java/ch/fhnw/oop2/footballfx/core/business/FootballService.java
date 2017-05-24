package ch.fhnw.oop2.footballfx.core.business;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import ch.fhnw.oop2.footballfx.core.dataaccess.FootballRepository;
import ch.fhnw.oop2.footballfx.core.model.Player;

public class FootballService {

    private final FootballRepository footballRepository;

    public FootballService(FootballRepository footballRepository) {
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
