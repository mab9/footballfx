package ch.fhnw.oop2.footballfx.presentationmodel;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.dataacess.FileDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PresentationModel {

    private final FileDao fileDao = new FileDao();

    private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX Application");
    private final StringProperty greeting = new SimpleStringProperty("Hello World!");

    private final StringProperty playerName = new SimpleStringProperty("Name");
    private final StringProperty playerCountry = new SimpleStringProperty("Land");
    private final StringProperty playerLaenderspiele = new SimpleStringProperty("Länderspiel");
    private final StringProperty playerStartJahr = new SimpleStringProperty("Start Jahr");
    private final StringProperty playerEndJahr = new SimpleStringProperty("Ende Jahr");
    private final StringProperty playerVerband = new SimpleStringProperty("Verband");
    private final StringProperty playerFifa = new SimpleStringProperty("Fifa");
    private final StringProperty playerRSSSF = new SimpleStringProperty("RSSF");
    private final StringProperty playerHundertesSpiel = new SimpleStringProperty("HundertesSpiel");
    private final StringProperty playerErstesSpiel = new SimpleStringProperty("Erstes Spiel");
    private final StringProperty playerGeboren = new SimpleStringProperty("geboren");
    private final StringProperty playerPosition = new SimpleStringProperty("Position");
    private final StringProperty playerGegen = new SimpleStringProperty("gegen");
    private final StringProperty playerLetztesSpiel = new SimpleStringProperty("letztes spiel");

    public List<String> loadData() throws FileAccessException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        return data.collect(Collectors.toList());
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public void addPlayer() {
    }

    public void removePlayer() {

    }

    public void saveData() {
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

    public StringProperty getPlayerName() {
        return playerName;
    }

    public StringProperty getPlayerCountry() {
        return playerCountry;
    }

    public StringProperty getPlayerLaenderspiele() {
        return playerLaenderspiele;
    }

    public StringProperty getPlayerStartJahr() {
        return playerStartJahr;
    }

    public StringProperty getPlayerEndJahr() {
        return playerEndJahr;
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

    public StringProperty getPlayerGeboren() {
        return playerGeboren;
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
}
