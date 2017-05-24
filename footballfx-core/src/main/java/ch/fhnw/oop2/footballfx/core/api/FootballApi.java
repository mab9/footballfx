package ch.fhnw.oop2.footballfx.core.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fhnw.oop2.footballfx.core.business.FootballService;
import ch.fhnw.oop2.footballfx.core.model.Player;

@Path("/football")
public class FootballApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final FootballService footballService;

    public FootballApi(FootballService footballService) {
        this.footballService = footballService;
    }

    @GET
    public List<Player> retrieveAllPlayers() {
        log.info("retrieve players");
        return footballService.retrieveAllPlayers();
    }

    @POST
    public Player createPlayer(Player player) {
        log.info("create player");
        return footballService.createPlayer(player);
    }

    @PUT
    public Player updateFootballPlayer(Player player) {
        log.info("update player");
        return footballService.updatePlayer(player);
    }

    @DELETE
    public void deleteFootballPlayer(Player player) {
        log.info("delete player");
        footballService.deletePlayer(player);
    }
}
