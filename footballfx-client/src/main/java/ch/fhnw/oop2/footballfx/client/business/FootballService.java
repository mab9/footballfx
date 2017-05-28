package ch.fhnw.oop2.footballfx.client.business;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;

public class FootballService {

    private final Client client;
    private final String BASE_URL = "http://localhost:8080/";

    public FootballService() {
        ClientConfig config = new ClientConfig();
        config.register(new JacksonJsonProvider());
        client = ClientBuilder.newClient(config);
    }

    public List<Player> retrieveAllPlayers() {
        return client.target(BASE_URL).path("/football").request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Player>>() {
                });
    }

    public Player createPlayer(Player player) {
        Player p = new Player();
        p.setName("der player");
        Response post = client.target(BASE_URL).path("/football").request()
                .post(Entity.entity(p, MediaType.APPLICATION_JSON_TYPE));
        System.out.println(post.readEntity(Player.class).getName());
        return null;
    }

    public Player updatePlayer(Player player) {
        return null;
    }

    public void deletePlayer(Player player) {

    }
}
