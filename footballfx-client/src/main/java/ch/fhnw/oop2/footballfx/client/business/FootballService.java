package ch.fhnw.oop2.footballfx.client.business;

import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

public class FootballService {

    private final Client client;
    private final String BASE_URL = "http://localhost:8080/";

    public FootballService() {
        ClientConfig config = new ClientConfig();
        config.register(new JacksonJsonProvider());
        client = ClientBuilder.newClient(config);
    }

    public List<Player> retrieveAllPlayers() throws ServerConnectionException {
        try {
            return client.target(BASE_URL).path("/football").request(APPLICATION_JSON_TYPE)
                    .get(new GenericType<List<Player>>() {
                    });
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }

    public Player createPlayer(Player player) throws ServerConnectionException {
        try {
            Response response = client.target(BASE_URL).path("/football").path("/add").request(APPLICATION_JSON_TYPE)
                    .put(Entity.entity(player, APPLICATION_JSON_TYPE));
            return response.readEntity(Player.class);
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }

    public Player updatePlayer(Player player) throws ServerConnectionException {
        try {
        Response response = client.target(BASE_URL).path("/football").path(player.getId().toString()).request()
                .put(Entity.entity(player, APPLICATION_JSON_TYPE));
        return response.readEntity(Player.class);
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }

    public void deletePlayer(Player player) throws ServerConnectionException {
        try {
            client.target(BASE_URL).path("/football").path(player.getId().toString()).request().delete();
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }
}
