package ch.fhnw.oop2.footballfx.core.player.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.base.SpringBeanInjectionHelper;
import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

@Path("football")
public class PlayerApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayerService playerService;

    public PlayerApi() {
        SpringBeanInjectionHelper.inject(this);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> retrieveAllPlayers() {
        return playerService.retrieveAllPlayers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Player createPlayer(Player player) {
        return playerService.createPlayer(player);
    }

    @PUT
    @Path("/add/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Player updatePlayer(@NotNull @PathParam("id") UUID id, @NotNull @Valid Player player) {
        uuidValidator(id, player);
        return playerService.updatePlayer(id, player);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlayer(@NotNull @PathParam("id") UUID id) {
        playerService.deletePlayer(id);
    }

    private boolean uuidValidator(UUID uuid, Object object) {
        try {
            Method getID = object.getClass().getMethod("getId");
            Object id = getID.invoke(object);

            if (!uuid.equals(id)) {
                throw new WebApplicationException("UUID not match", Response.Status.NOT_ACCEPTABLE);
            }
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new WebApplicationException("UUID not match", Response.Status.NOT_ACCEPTABLE);
        }
    }
}
