package ch.fhnw.oop2.footballfx.client.business;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

public class FootballService {

    private final Client client;
    private final String BASE_URL = "http://localhost:8080/";

    /**
     * Sets up the client object from the Configuration. Registers the JSON Provider and makes the client available for other methods
     *
     *
     * @author      Peer Jüttner
     * @author      Marc-Antoine Brülhart
     * @version     %I%, %G%
     * @since       1.0
     */

    public FootballService() {
        ClientConfig config = new ClientConfig();
        config.register(new JacksonJsonProvider());
        client = ClientBuilder.newClient(config);
    }
    /**
     * Retrieves all Players from the Backend Server. Throws ServerConnectionException if it cannot connect to the server.
     * Uses JSON for communication
     * @return      List of <players> loaded from the backend
     * @author      Peer Jüttner
     * @author      Marc-Antoine Brülhart
     * @version     %I%, %G%
     * @since       1.0
     */
    public List<Player> retrieveAllPlayers() throws ServerConnectionException {
        try {
            return client.target(BASE_URL).path("/football").request(APPLICATION_JSON_TYPE)
                    .get(new GenericType<List<Player>>() {
                    });
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }

    /**
     * Takes a new player, converts it to json format and posts the object to the server to get it added to the backend DB.
     * @param player - object of type player
     * @return      created player
     * @author      Peer Jüttner
     * @author      Marc-Antoine Brülhart
     * @version     %I%, %G%
     * @since       1.0
     */
    public Player createPlayer(Player player) throws ServerConnectionException {
        try {
            Response response = client.target(BASE_URL).path("/football").request(APPLICATION_JSON_TYPE)
                    .post(Entity.entity(player, APPLICATION_JSON_TYPE));
            Player newPlayer = response.readEntity(Player.class);
            player.setId(newPlayer.getId());
            return player;
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }
    /**
     * Retrieves all Players from the Backend Server. Throws ServerConnectionException if it cannot connect to the server.
     * Uses JSON for communication
     * @param       player - object of player to be updated.
     * @return      updated player
     * @author      Peer Jüttner
     * @author      Marc-Antoine Brülhart
     * @version     %I%, %G%
     * @since       1.0
     */
    public Player updatePlayer(Player player) throws ServerConnectionException {
        try {
            Response response = client.target(BASE_URL).path("/football").path("/" + player.getId().toString())
                    .request(APPLICATION_JSON_TYPE)
                .put(Entity.entity(player, APPLICATION_JSON_TYPE));
        return response.readEntity(Player.class);
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }
    /**
     * Deletes player from the backend server. Passes info over JSON. Throws Serverconnectionexception if server cant be reached.
     * @param       player - player to be deleted
     * @return      void
     * @author      Peer Jüttner
     * @author      Marc-Antoine Brülhart
     * @version     %I%, %G%
     * @since       1.0
     */
    public void deletePlayer(Player player) throws ServerConnectionException {
        try {
            client.target(BASE_URL).path("/football").path(player.getId().toString()).request().delete();
        } catch (ProcessingException e) {
            throw new ServerConnectionException("Can not connect to server. Connection aborder.", e);
        }
    }
}
