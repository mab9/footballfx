package ch.fhnw.oop2.footballfx.presentationmodel;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.dataacess.FileDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PresentationModel {

    private final Path DATA_SOURCE = Paths.get("player.csv");
    private final FileDao fileDao = new FileDao();
    private ObservableList<Player> data = FXCollections.observableArrayList();

    private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX Application");
    private final StringProperty greeting = new SimpleStringProperty("Hello World!");

    private final StringProperty playerNumber = new SimpleStringProperty();
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
    private final StringProperty playerErstesSpiel = new SimpleStringProperty();
    private final StringProperty playerLetztesSpiel = new SimpleStringProperty();
    //private final Property<Image> countryImage = new Property<Image>();
    //private final Property<Image> teamImage = new Property<Image>();


    public PresentationModel() {
        try {
            data = loadData();
        } catch (FileAccessException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        showPlayerDetails(data.get(1));
    }

    public ObservableList<Player> getData() {
        return data;
    }

    private ObservableList<Player> loadData() throws FileAccessException {
        Stream<String> stream = fileDao.readFile(DATA_SOURCE);
        ObservableList<Player> players = FXCollections.observableArrayList();

        stream.skip(1).forEach(row -> {
            String[] splitedData = row.split(";");
            Player player = new Player();
            player.setName(splitedData[1]);
            player.setBirthDate(splitedData[2]);
            player.setCountry(splitedData[3]);
            player.setVerband(splitedData[4]);
            player.setPosition(splitedData[5]);
            player.setHundertesSpiel(splitedData[6]);
            player.setGegen(splitedData[7]);
            player.setFifa(splitedData[8]);
            player.setRsssf(splitedData[9]);
            player.setNumber(splitedData[0]);
            player.setStartjahr(splitedData[10]);
            player.setEndjahr(splitedData[11]);
            players.add(player);
        });
        return players;
    }

    public void showPlayerDetails(Player player) {
        if (player != null) {
            playerName.set(player.getName().get());
            playerBirthDate.set(player.getBirthDate().get());
            playerCountry.set(player.getCountry().get());
            playerVerband.set(player.getVerband().get());
            playerPosition.set(player.getPosition().get());
            playerHundertesSpiel.set(player.getHundertesSpiel().get());
            playerGegen.set(player.getGegen().get());
            playerFifa.set(player.getFifa().get());
            playerRSSSF.set(player.getRsssf().get());
            playerNumber.set(player.getNumber().get());
            playerErstesSpiel.set(player.getStartJahr().get());
            playerLetztesSpiel.set(player.getEndJahr().get());



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
            playerNumber.set("");
            playerErstesSpiel.set("");
            playerLetztesSpiel.set("");
        }
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public void addPlayer() {
    }

    public void removePlayer(Player player) {

        data.remove(player);
    }

    public void saveData() throws FileAccessException{
        //fileDao.saveFile("player.csv",);

    }

    public void undoAction() {
    }

    public void redoAction() {

    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public String getGreeting() {
        return greeting.get();
    }

    public StringProperty greetingProperty() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting.set(greeting);
    }

    public StringProperty getPlayerNumber() {return playerNumber; }

    public StringProperty getPlayerName() {
        return playerName;
    }

    public StringProperty getPlayerCountry() {
        return playerCountry;
    }

    public StringProperty getPlayerLaenderspiele() {
        return playerLaenderspiele;
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

    public StringProperty getPlayerErstesSpiel() {
        return playerErstesSpiel;
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

    public StringProperty getPlayerLetztesSpiel() {
        return playerLetztesSpiel;
    }

  /*  public Property<Image> getTeamImage() {
        return null;
        //return teamImage;
    }

    public Property<Image> getCountryImage() {
        return
                null;
        //countryImage;
    } */
}
