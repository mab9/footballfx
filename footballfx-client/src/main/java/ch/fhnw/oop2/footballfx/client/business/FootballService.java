package ch.fhnw.oop2.footballfx.client.business;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;

public class FootballService {

    private final Client client;
    private WebResource webResource;

    public FootballService() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        client = Client.create(clientConfig);
        webResource = client.resource("http://localhost:8080/profile/").path("football");
    }

    public List<Player> retrieveAllPlayers() {
        createPlayer(null);
        return null;
    }

    public Player createPlayer(Player player) {
        Player p = new Player();
        p.setName("der player");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, p);

        System.out.println(response.getStatus());
        System.out.println(response.getEntity(Player.class));
        return null;
    }

    public Player updatePlayer(Player player) {
        return null;
    }

    public void deletePlayer(Player player) {

    }
}
