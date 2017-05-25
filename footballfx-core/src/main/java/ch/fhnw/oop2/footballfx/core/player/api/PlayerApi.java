package ch.fhnw.oop2.footballfx.core.player.api;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

@Path("football")
public class PlayerApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final PlayerService playerService;

    public PlayerApi(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GET
    public List<Player> retrieveAllPlayers() {
        log.info("retrieve players");
        return playerService.retrieveAllPlayers();
    }

    @POST
    public Player createPlayer(@NotNull Player player) {
        log.info("create player");
        return playerService.createPlayer(player);
    }

    @PUT
    public Player updatePlayer(@NotNull Player player) {
        log.info("update player");
        return playerService.updatePlayer(player);
    }

    @DELETE
    public void deletePlayer(@NotNull Player player) {
        log.info("delete player");
        playerService.deletePlayer(player);
    }
}
