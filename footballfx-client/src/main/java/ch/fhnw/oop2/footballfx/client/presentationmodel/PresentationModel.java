package ch.fhnw.oop2.footballfx.client.presentationmodel;

import java.util.List;

import ch.fhnw.oop2.footballfx.client.business.FootballService;
import ch.fhnw.oop2.footballfx.client.business.ServerConnectionException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PresentationModel {

    private final FootballService footballService = new FootballService();
    private ObservableList<Player> data = FXCollections.observableArrayList();

    private final StringProperty applicationTitle = new SimpleStringProperty("Football FX - Marc-Antoine Brülhart & Peer Jüttner");

    private final StringProperty playerPlatz = new SimpleStringProperty();
    private final StringProperty playerName = new SimpleStringProperty();
    private final StringProperty playerBirthDate = new SimpleStringProperty();
    private final StringProperty playerCountry = new SimpleStringProperty();
    private final StringProperty playerVerband = new SimpleStringProperty();
    private final StringProperty playerPosition = new SimpleStringProperty();
    private final StringProperty playerHundertesSpiel = new SimpleStringProperty();
    private final StringProperty playerGegen = new SimpleStringProperty();
    private final StringProperty playerFifa = new SimpleStringProperty();
    private final StringProperty playerRSSSF = new SimpleStringProperty();
    private final StringProperty playerLaenderspiele = new SimpleStringProperty();
    private final StringProperty playerStartJahr = new SimpleStringProperty();
    private final StringProperty playerEndJahr = new SimpleStringProperty();
    private final StringProperty playerMehrSpiele = new SimpleStringProperty();

    public PresentationModel() {
        try {
            data = loadDataFromServer();
        } catch (ServerConnectionException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        showPlayerDetails(data.get(1));
    }

    /**
     * Returns the Data of players in the List.
     *
     * @return ObservableList<player> with data on players inside
     * @author Peer Jüttner
     * @author Marc-Antoine Brülhart
     * @version %I%, %G%
     * @since 1.0
     */

    public ObservableList<Player> getData() {
        return data;
    }

    private ObservableList<Player> loadDataFromServer() throws ServerConnectionException {
        List<Player> playerss = footballService.retrieveAllPlayers();
        return FXCollections.observableArrayList(playerss);
    }

    /**
     *
     * @param player to be shown in the Player Overview in the right side of the GUI. Tests for an Empty object first.
     *            If a player is selected, the Player's Data is loaded using the getter Methods.
     * @return the image at the specified URL
     * @author Peer Jüttner
     * @author Marc-Antoine Brülhart
     * @version %I%, %G%
     * @since 1.0
     */

    public void showPlayerDetails(Player player) {
        if (player != null) {
            playerPlatz.set(player.getPlatz().get());
            playerName.set(player.getName().get());
            playerBirthDate.set(player.getBirthday().get());
            playerCountry.set(player.getCountry().get());
            playerVerband.set(player.getVerband().get());
            playerPosition.set(player.getPosition().get());
            playerHundertesSpiel.set(player.getHundertesSpiel().get());
            playerGegen.set(player.getGegner().get());
            playerFifa.set(player.getFifa_spiele().get());
            playerRSSSF.set(player.getRsssf_spiele().get());
            playerStartJahr.set(player.getStartJahr().get());
            playerEndJahr.set(player.getEndJahr().get());
            setMostInternationalGames(player);
        } else {
            playerName.set("");
            playerBirthDate.set("");
            playerCountry.set("");
            playerVerband.set("");
            playerPosition.set("");
            playerHundertesSpiel.set("");
            playerGegen.set("");
            playerFifa.set("");
            playerRSSSF.set("");
            playerPlatz.set("");
            playerStartJahr.set("");
            playerEndJahr.set("");
            playerMehrSpiele.set("");
        }
    }

    private void setMostInternationalGames(Player player) {
        try {
            if (Integer.valueOf(player.getFifa_spiele().get()) >= Integer.valueOf(player.getRsssf_spiele().get())) {
                playerMehrSpiele.set(player.getFifa_spiele().get());
            } else if (Integer.valueOf(player.getFifa_spiele().get()) < Integer
                    .valueOf(player.getRsssf_spiele().get())) {
                playerMehrSpiele.set(player.getRsssf_spiele().get());
            } else {
                playerMehrSpiele.set("");
            }
        } catch (NumberFormatException e) {
            System.out.print("New Item Created - Values was NULL");
        }
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public StringProperty getPlayerPlatz() {
        return playerPlatz;
    }

    public StringProperty getPlayerName() {
        return playerName;
    }

    public StringProperty getPlayerCountry() {
        return playerCountry;
    }

    public StringProperty getPlayerVerband() {
        return playerVerband;
    }

    public StringProperty getPlayerFifa() {
        return playerFifa;
    }

    public StringProperty getPlayerRSSSF() {
        return playerRSSSF;
    }

    public StringProperty getPlayerHundertesSpiel() {
        return playerHundertesSpiel;
    }

    public StringProperty getPlayerStartJahr() {
        return playerStartJahr;
    }

    public StringProperty getPlayerBirthDate() {
        return playerBirthDate;
    }

    public StringProperty getPlayerPosition() {
        return playerPosition;
    }

    public StringProperty getPlayerGegen() {
        return playerGegen;
    }

    public StringProperty getPlayerEndJahr() {
        return playerEndJahr;
    }

    public StringProperty getPlayerMehrSpiele() {
        return playerMehrSpiele;
    }

    /**
     * Adds a new player to the Footballservice-backend. Tests for a Connection to the backend server. If a connection
     * is possible
     * the player is added by calling footballService.createPlayer(Player)
     *
     * @param player object to be created.
     * @return the newly created Player object
     * @author Peer Jüttner
     * @author Marc-Antoine Brülhart
     * @version %I%, %G%
     * @since 1.0
     */
    public Player createPlayer(Player player) {
        try {
            return footballService.createPlayer(player);
        } catch (ServerConnectionException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Pushes a player's info to the Footballservice-backend. Tests for a Connection to the backend server. If a
     * connection is possible
     * the player is modified by calling footballService.updatePlayer(Player)
     *
     * @param player object to be edited, complete with updated Values.
     * @return the newly modified Player object
     * @author Peer Jüttner
     * @author Marc-Antoine Brülhart
     * @version %I%, %G%
     * @since 1.0
     */
    public Player updatePlayer(Player player) {
        try {
            return footballService.updatePlayer(player);
        } catch (ServerConnectionException e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Removes a player from the Footballservice-backend. Tests for a Connection to the backend server. If a connection
     * is possible
     * the player is removed by calling footballService.deletePlayer(Player)
     *
     * @param player object to be deleted.
     * @return void
     * @author Peer Jüttner
     * @author Marc-Antoine Brülhart
     * @version %I%, %G%
     * @since 1.0
     */
    public void removePlayer(Player player) {
        try {
            footballService.deletePlayer(player);
        } catch (ServerConnectionException e) {
            System.err.println(e);
        }
    }
}