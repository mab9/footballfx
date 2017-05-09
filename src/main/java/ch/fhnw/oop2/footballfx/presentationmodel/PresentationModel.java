package ch.fhnw.oop2.footballfx.presentationmodel;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.dataacess.FileDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PresentationModel {

    private final Path DATA_SOURCE = Paths.get("player.csv");
    private final FileDao fileDao = new FileDao();
    private ObservableList<Player> data = FXCollections.observableArrayList();

    private final StringProperty applicationTitle = new SimpleStringProperty("JavaFX Application");
    private final StringProperty greeting = new SimpleStringProperty("Hello World!");

    private final StringProperty playerName = new SimpleStringProperty();
    private final StringProperty playerBirthDate = new SimpleStringProperty();
    private final StringProperty playerCountry = new SimpleStringProperty();
    private final StringProperty playerVerband = new SimpleStringProperty();
    private final StringProperty playerPosition = new SimpleStringProperty();
    private final StringProperty playerHundertesSpiel = new SimpleStringProperty();
    private final StringProperty playerGegen = new SimpleStringProperty();
    private final StringProperty playerFifa = new SimpleStringProperty();
    private final StringProperty playerRSSSF = new SimpleStringProperty();
    private final StringProperty playerStartJahr = new SimpleStringProperty();
    private final StringProperty playerEndJahr = new SimpleStringProperty();

    private final StringProperty playerLaenderspiele = new SimpleStringProperty();
    private final StringProperty playerErstesSpiel = new SimpleStringProperty();
    private final StringProperty playerLetztesSpiel = new SimpleStringProperty();

    public PresentationModel() {
        try {
            data = loadData();
        } catch (FileAccessException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }

        try {
            // initDefaultData(1);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Loaded Data are wrong formatted");
        }
    }

    public ObservableList<Player> getData() {
        return data;
    }

    private void initDefaultData(int rowNumber) {
        /*
         * playerName.set(data.get(rowNumber).get(1));
         * playerBirthDate.set(data.get(rowNumber).get(2));
         * playerCountry.set(data.get(rowNumber).get(3));
         * playerVerband.set(data.get(rowNumber).get(4));
         * playerPosition.set(data.get(rowNumber).get(5));
         * playerHundertesSpiel.set(data.get(rowNumber).get(6));
         * playerGegen.set(data.get(rowNumber).get(7));
         * playerFifa.set(data.get(rowNumber).get(8));
         * playerRSSSF.set(data.get(rowNumber).get(9));
         * playerStartJahr.set(data.get(rowNumber).get(10));
         * playerEndJahr.set(data.get(rowNumber).get(11));
         */
    }

    private ObservableList<Player> loadData() throws FileAccessException {
        Stream<String> stream = fileDao.readFile(DATA_SOURCE);
        ObservableList<Player> players = FXCollections.observableArrayList();

        stream.skip(1).forEach(row -> {
            String[] splitedData = row.split(";");
            Player player = new Player();
            player.setName(splitedData[0]);
            player.setBirthDate(splitedData[1]);
            player.setCountry(splitedData[2]);
            player.setVerband(splitedData[3]);
            player.setPosition(splitedData[4]);
            player.setHundertesSpiel(splitedData[5]);
            player.setGegen(splitedData[6]);
            player.setFifa(splitedData[7]);
            player.setRsssf(splitedData[8]);
            player.setStartjahr(splitedData[9]);
            player.setEndjahr(splitedData[10]);
            players.add(player);
        });
        return players;
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public void addPlayer() {
    }

    public void removePlayer() {

    }

    public void saveData() {
        try {
            fileDao.saveFile(DATA_SOURCE, getFormatedData().stream());
        } catch (FileAccessException e) {
            e.printStackTrace();
        }
    }

    private List<String> getFormatedData() {
        List<String> rows = new ArrayList<>();
        data.forEach(row -> {
            /*
             * StringBuilder sb = new StringBuilder();
             * row.forEach(element -> {
             * sb.append(element).append(";");
             * });
             * rows.add(sb.toString());
             */
        });

        return rows;
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
}
