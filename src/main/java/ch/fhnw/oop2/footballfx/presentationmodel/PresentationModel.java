package ch.fhnw.oop2.footballfx.presentationmodel;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.dataacess.FileDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PresentationModel {

    private final FileDao fileDao = new FileDao();
    private List<List<String>> data = new ArrayList<>();

    private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX Application");
    private final StringProperty greeting = new SimpleStringProperty("Hello World!");

    private final StringProperty playerName;
    private final StringProperty playerGeboren;
    private final StringProperty playerCountry;
    private final StringProperty playerVerband;
    private final StringProperty playerPosition;
    private final StringProperty playerHundertesSpiel;
    private final StringProperty playerGegen;
    private final StringProperty playerFifa;
    private final StringProperty playerRSSSF;
    private final StringProperty playerStartJahr;
    private final StringProperty playerEndJahr;

    private final StringProperty playerLaenderspiele = new SimpleStringProperty("Länderspiel");
    private final StringProperty playerErstesSpiel = new SimpleStringProperty("Erstes Spiel");
    private final StringProperty playerLetztesSpiel = new SimpleStringProperty("letztes spiel");

    public PresentationModel() {
        try {
            data = loadData();
        } catch (FileAccessException e) {
            System.err.println("Could not load data");
        }
        playerName = new SimpleStringProperty(data.get(1).get(1));
        playerGeboren = new SimpleStringProperty(data.get(1).get(2));
        playerCountry = new SimpleStringProperty(data.get(1).get(3));
        playerVerband = new SimpleStringProperty(data.get(1).get(4));
        playerPosition = new SimpleStringProperty(data.get(1).get(5));
        playerHundertesSpiel = new SimpleStringProperty(data.get(1).get(6));
        playerGegen = new SimpleStringProperty(data.get(1).get(7));
        playerFifa = new SimpleStringProperty(data.get(1).get(8));
        playerRSSSF = new SimpleStringProperty(data.get(1).get(9));
        playerStartJahr = new SimpleStringProperty(data.get(1).get(10));
        playerEndJahr = new SimpleStringProperty(data.get(1).get(11));
    }

    private List<List<String>> loadData() throws FileAccessException {
        Stream<String> stream = fileDao.readFile(Paths.get("player.csv"));
        List<List<String>> datas = new ArrayList<>();

        List<String> rows = stream.collect(Collectors.toList());
        rows.forEach(row -> {
            String[] split = row.split(";");
            List<String> columns = Arrays.asList(split);
            datas.add(columns);
        });
        return datas;
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
