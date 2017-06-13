package ch.fhnw.oop2.footballfx.client.view;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;
import ch.fhnw.oop2.footballfx.client.presentationmodel.PresentationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.util.*;

public class ApplicationUI extends VBox {

    private final PresentationModel model;
    private List<Player> newplayers;
    private ComboBox comboBoxLanguges;
    private Button buttonAddPlayer;
    private Button buttonRemovePlayer;
    private Button buttonSavePlayer;
    private Button buttonChangeLanguage;
    private TextField search;
    private TableView<Player> playerTableView;
    private ImageView countryImageView;
    private ImageView teamImageView;
    private ToolBar toolBar;
    private TextField txtPlayerName;
    private TextField txtPlayerCountry;
    private TextField txtPlayerLaenderspiele;
    private TextField txtPlayerStartJahr;
    private TextField txtPlayerEndJahr;
    private TextField txtPlayerAgainst;
    private TextField txtPlayerFifa;
    private TextField txtPlayerRSSSF;
    private TextField txtPlayerPosition;
    private TextField txtPlayerBirthDate;
    private TextField txtPlayerHundrethGame;
    private TextField txtPlayerFirstGame;
    private TextField txtPlayerLetztesSpiel;
    private TextField txtPlayerAssociation;
    private Label lblTextLaenderspiele;
    private Label lblPlayerRang;
    private Label lblTextName;
    private Label lblOverName;
    private Label lblOverLand;
    private Label lblOverLaenderspiele;
    private Label lblOverStartJahr;
    private Label lblOverEndJahr;
    private Label lblTextLand;
    private Label lblTextBis;
    private Label lblTextVerband;
    private Label lblTextSpieleFifa;
    private Label lblTextSpieleRSSSF;
    private Label lblTextBirthDate;
    private Label lblTextRang;
    private Label lblTextPosition;
    private Label lblTextHundertesSpiel;
    private Label lblTextGegen;
    private Label lblTextErstesSpiel;
    private Label lblTextLetztesSpiel;
    private Locale locale;
    private TableColumn<Player, String> numberColumn;
    private TableColumn<Player, String> nameColumn;
    private TableColumn<Player, String> birthDateColumn;
    private TableColumn<Player, String> countryColumn ;
    private TableColumn<Player, String> verbandColumn ;
    private TableColumn<Player, String> positionColumn ;
    private TableColumn<Player, String> hundertesSpielColumn ;
    private TableColumn<Player, String> gegenColumn ;
    private TableColumn<Player, String> fifaColumn ;
    private TableColumn<Player, String> rsssfColumn ;
    private TableColumn<Player, String> startjahrColumn ;
    private TableColumn<Player, String> endjahrColumn ;


    public ApplicationUI(PresentationModel model) {
        this.model = model;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
        setTextLocalized();
        cleanUiForNewPlayer();
    }

    private void initializeSelf() {
        String stylesheet = ClassLoader.getSystemClassLoader().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        newplayers = new ArrayList<>();

        buttonAddPlayer = new Button();
        buttonRemovePlayer = new Button();
        buttonSavePlayer = new Button();
        buttonChangeLanguage = new Button();

        search = new TextField();

        playerTableView = new TableView();
        playerTableView.setEditable(true);

        comboBoxLanguges = new ComboBox();

        countryImageView = new ImageView();
        teamImageView = new ImageView();

        toolBar = new ToolBar();

        comboBoxLanguges = new ComboBox();

        txtPlayerName = new TextField();
        txtPlayerCountry = new TextField();
        txtPlayerLaenderspiele = new TextField();
        txtPlayerStartJahr = new TextField();
        txtPlayerEndJahr = new TextField();
        txtPlayerAssociation = new TextField();
        txtPlayerFifa = new TextField();
        txtPlayerRSSSF = new TextField();
        txtPlayerHundrethGame = new TextField();
        txtPlayerFirstGame = new TextField();
        lblPlayerRang = new Label();
        txtPlayerBirthDate = new TextField();
        txtPlayerPosition = new TextField();
        txtPlayerAgainst = new TextField();
        txtPlayerLetztesSpiel = new TextField();
        lblTextLaenderspiele = new Label();
        lblTextName = new Label();
        lblTextLand = new Label();
        lblTextSpieleFifa = new Label();
        lblTextSpieleRSSSF = new Label();
        lblTextVerband = new Label();
        lblTextBirthDate = new Label();
        lblTextRang = new Label();
        lblTextPosition = new Label();
        lblTextHundertesSpiel = new Label();
        lblTextGegen = new Label();
        lblTextErstesSpiel = new Label();
        lblTextLetztesSpiel = new Label();
        lblTextBis = new Label();
        lblOverName = new Label();
        lblOverLand = new Label();
        lblOverEndJahr = new Label();
        lblOverStartJahr = new Label();
        lblOverLaenderspiele = new Label();

        numberColumn = new TableColumn<>();
        nameColumn = new TableColumn<>();
        birthDateColumn = new TableColumn<>();
        countryColumn  = new TableColumn<>();
        verbandColumn  = new TableColumn<>();
        positionColumn  = new TableColumn<>();
        hundertesSpielColumn  = new TableColumn<>();
        gegenColumn  = new TableColumn<>();
        fifaColumn  = new TableColumn<>();
        rsssfColumn  = new TableColumn<>();
        startjahrColumn  = new TableColumn<>();
        endjahrColumn  = new TableColumn<>();
    }

    private void layoutControls() {
        SplitPane splitPane = new SplitPane();
        ToolBar toolBar = new ToolBar();
        GridPane gridTop = new GridPane();
        gridTop.getStyleClass().add("gridTop");
        GridPane gridBottom = new GridPane();
        gridBottom.getStyleClass().add("gridBottom");
        VBox vBoxright = new VBox();
        vBoxright.getChildren().addAll(gridTop, gridBottom);
        vBoxright.setSpacing(10);
        vBoxright.getStyleClass().add("vBoxRight");
        gridTop.setHgap(3);
        gridTop.setVgap(3);
        countryImageView.setFitHeight(60);
        countryImageView.setFitWidth(60);
        teamImageView.setFitHeight(60);
        teamImageView.setFitWidth(60);

        // Add toolbar
        toolBar.getItems().addAll(buttonSavePlayer, buttonAddPlayer, buttonRemovePlayer, comboBoxLanguges);
        // Add Grid
        gridTop.add(lblOverName, 0, 0, 4, 1);
        gridTop.add(lblOverLand, 0, 1);
        gridTop.add(countryImageView, 3, 0, 1, 2);
        gridTop.add(lblOverLaenderspiele, 0, 2);
        gridTop.add(lblTextLaenderspiele, 1, 2,4,1);
        gridTop.add(teamImageView, 3, 2, 1, 3);
        gridTop.add(lblOverStartJahr, 0, 3);
        gridTop.add(lblTextBis, 1, 3);
        gridTop.add(lblOverEndJahr, 2, 3);

        gridBottom.add(lblTextName, 0, 0);
        gridBottom.add(lblTextLand, 0, 1);
        gridBottom.add(lblTextVerband, 0, 2);
        gridBottom.add(lblTextSpieleFifa, 0, 3);
        gridBottom.add(lblTextHundertesSpiel, 0, 4);
        gridBottom.add(lblTextErstesSpiel, 0, 5);

        gridBottom.add(txtPlayerName, 1, 0);
        gridBottom.add(txtPlayerCountry, 1, 1);
        gridBottom.add(txtPlayerAssociation, 1, 2);
        gridBottom.add(txtPlayerFifa, 1, 3);
        gridBottom.add(txtPlayerHundrethGame, 1, 4);
        gridBottom.add(txtPlayerFirstGame, 1, 5);

        // Column 2
        gridBottom.add(lblTextBirthDate, 2, 0);
        gridBottom.add(lblTextPosition, 2, 1);
        gridBottom.add(lblTextRang, 2, 2);
        gridBottom.add(lblTextSpieleRSSSF, 2, 3);
        gridBottom.add(lblTextGegen, 2, 4);
        gridBottom.add(lblTextLetztesSpiel, 2, 5);

        // Column 3
        gridBottom.add(txtPlayerBirthDate, 3, 0);
        gridBottom.add(txtPlayerPosition, 3, 1);
        gridBottom.add(lblPlayerRang, 3, 2);
        gridBottom.add(txtPlayerRSSSF, 3, 3);
        gridBottom.add(txtPlayerAgainst, 3, 4);
        gridBottom.add(txtPlayerLetztesSpiel, 3, 5);

        playerTableView.getItems().setAll(model.getData());

        playerTableView.getColumns().add(numberColumn);
        playerTableView.getColumns().add(nameColumn);
        playerTableView.getColumns().add(birthDateColumn);
        playerTableView.getColumns().add(countryColumn);
        playerTableView.getColumns().add(verbandColumn);
        playerTableView.getColumns().add(positionColumn);
        playerTableView.getColumns().add(hundertesSpielColumn);
        playerTableView.getColumns().add(gegenColumn);
        playerTableView.getColumns().add(fifaColumn);
        playerTableView.getColumns().add(rsssfColumn);
        playerTableView.getColumns().add(startjahrColumn);
        playerTableView.getColumns().add(endjahrColumn);


        numberColumn.setCellValueFactory(e -> e.getValue().getPlatz());
        nameColumn.setCellValueFactory(e -> e.getValue().getName());
        birthDateColumn.setCellValueFactory(e -> e.getValue().getBirthday());
        countryColumn.setCellValueFactory(e -> e.getValue().getCountry());
        verbandColumn.setCellValueFactory(e -> e.getValue().getVerband());
        positionColumn.setCellValueFactory(e -> e.getValue().getPosition());
        hundertesSpielColumn.setCellValueFactory(e -> e.getValue().getHundertesSpiel());
        gegenColumn.setCellValueFactory(e -> e.getValue().getGegner());
        fifaColumn.setCellValueFactory(e -> e.getValue().getFifa_spiele());
        rsssfColumn.setCellValueFactory(e -> e.getValue().getRsssf_spiele());
        startjahrColumn.setCellValueFactory(e -> e.getValue().getStartJahr());
        endjahrColumn.setCellValueFactory(e -> e.getValue().getEndJahr());

        ObservableList<String> options =
                FXCollections.observableArrayList(
                    "Deutsch",
                    "English",
                    "Francais"
                );

        comboBoxLanguges.setItems(options);
        comboBoxLanguges.getSelectionModel().select(0);
        comboBoxLanguges.setOnAction((event) -> {
            setTextLocalized();
        });

        this.setVgrow(splitPane,Priority.ALWAYS);
        splitPane.getItems().addAll(playerTableView,vBoxright);
        this.getChildren().addAll(toolBar, splitPane);
        this.getStyleClass().add("topVBox");
    }
    private void setTextLocalized(){
        String currentLanguage = comboBoxLanguges.getValue().toString();
        switch (currentLanguage){
            case "Deutsch":
                locale = new Locale("de","DE");
                break;
            case "English":
                locale = new Locale("en","US");
                break;
            case "Francais":
                locale = new Locale("fr","FR");
                break;
            default:
                locale = new Locale("en","US");
                break;
        }
        // Text for Overview
        ResourceBundle messages = ResourceBundle.getBundle("MessegesBundle", locale);
        lblTextLaenderspiele.setText(messages.getString("internationalgames"));
        lblTextBis.setText(messages.getString("to"));

        // Text for Editor
        lblTextName.setText(messages.getString("name"));
        lblTextLand.setText(messages.getString("nationality"));
        lblTextVerband.setText(messages.getString("association"));
        lblTextSpieleFifa.setText(messages.getString("fifa_spiele"));
        lblTextSpieleRSSSF.setText(messages.getString("rsssf_spiele"));
        lblTextHundertesSpiel.setText(messages.getString("100game"));
        lblTextGegen.setText(messages.getString("against"));
        lblTextErstesSpiel.setText(messages.getString("firstgame"));
        lblTextLetztesSpiel.setText(messages.getString("lastgame"));
        lblTextBirthDate.setText(messages.getString("birthdate"));
        lblTextPosition.setText(messages.getString("position"));
        lblTextRang.setText(messages.getString("rang"));

        numberColumn.setText(messages.getString("rang"));
        nameColumn.setText(messages.getString("name"));
        birthDateColumn.setText(messages.getString("birthyear"));
        countryColumn.setText(messages.getString("nationality"));
        verbandColumn.setText(messages.getString("association"));
        positionColumn.setText(messages.getString("position"));
        hundertesSpielColumn.setText(messages.getString("100game"));
        gegenColumn.setText(messages.getString("against"));
        fifaColumn.setText(messages.getString("fifa_spiele"));
        rsssfColumn.setText(messages.getString("rsssf_spiele"));
        startjahrColumn.setText(messages.getString("firstgame"));
        endjahrColumn.setText(messages.getString("lastgame"));

        buttonSavePlayer.setText(messages.getString("save"));
        buttonAddPlayer.setText(messages.getString("addplayer"));
        buttonRemovePlayer.setText(messages.getString("removeplayer"));
    }

    private void setupEventHandlers() {
        playerTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> model.showPlayerDetails(newValue));

        buttonAddPlayer.setOnAction(e -> {
            if (newplayers.size()>0){
                warningNotSavedYet();
            } else {
                cleanUiForNewPlayer();
                Player player = new Player();
                playerTableView.getItems().add(0, player);
                playerTableView.getSelectionModel().select(0);
                newplayers.add(player);
            }

        });

        buttonRemovePlayer.setOnAction(e -> {
            int selectedIndex = playerTableView.getSelectionModel().getSelectedIndex();
            if(newplayers.contains(getSelectedPlayer(selectedIndex))){
                newplayers.remove(getSelectedPlayer(selectedIndex));
            }
            if (selectedIndex >= 0) {
                if (getSelectedPlayer(selectedIndex).getId() != null) {
                    model.removePlayer(getSelectedPlayer(selectedIndex));
                }
                playerTableView.getItems().remove(selectedIndex);
            } else {
                warningNoPlayerSelected();
            }

        });

        buttonSavePlayer.setOnAction(e -> {
            int selectedIndex = playerTableView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                savePlayer(selectedIndex);
            } else {
                warningNoPlayerSelected();
            }
            if(newplayers.contains(getSelectedPlayer(selectedIndex))){
                playerTableView.getItems().remove(selectedIndex);
                newplayers.remove(getSelectedPlayer(selectedIndex));
            }

        });
    }

    private void cleanUiForNewPlayer() {
        countryImageView.setImage(null);
        teamImageView.setImage(null);
        txtPlayerName.textProperty().setValue("");
        txtPlayerCountry.textProperty().setValue("");
        txtPlayerAssociation.textProperty().setValue("");
        txtPlayerFifa.textProperty().setValue("");
        txtPlayerHundrethGame.textProperty().setValue("");
        txtPlayerFirstGame.textProperty().setValue("");
        txtPlayerBirthDate.textProperty().setValue("");
        txtPlayerPosition.textProperty().setValue("");
        lblPlayerRang.textProperty().setValue("");
        txtPlayerRSSSF.textProperty().setValue("");
        txtPlayerAgainst.textProperty().setValue("");
        lblOverLaenderspiele.textProperty().setValue("");
    }

    private void warningNoPlayerSelected() {
        ResourceBundle messages = ResourceBundle.getBundle("MessegesBundle", locale);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(messages.getString("notselected"));
        alert.setHeaderText(messages.getString("notselectedheader"));
        alert.setContentText(messages.getString("notselectedcontent"));
        alert.showAndWait();
    }

    private void warningNotSavedYet() {
        ResourceBundle messages = ResourceBundle.getBundle("MessegesBundle", locale);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(messages.getString("notsaved"));
        alert.setHeaderText(messages.getString("notsavedheader"));
        alert.setContentText(messages.getString("notsavedcontent"));
        alert.showAndWait();
    }

    private void savePlayer(int selectedIndex) {
        if (getSelectedPlayer(selectedIndex).getId() != null) {
            Player updatedPlayer = model.updatePlayer(getSelectedPlayer(selectedIndex));
            playerTableView.getItems().remove(selectedIndex);
            playerTableView.getItems().add(updatedPlayer);
        } else {
            Player newPlayer = model.addPlayer(getSelectedPlayer(selectedIndex));
            playerTableView.getItems().add(newPlayer);
        }
    }

    private Player getSelectedPlayer(int selectedIndex) {
        return playerTableView.getItems().get(selectedIndex);
    }

    private void setupValueChangedListeners() {
        txtPlayerName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setName(newValue);
            }
        });
        txtPlayerCountry.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setCountry(newValue);
                displayImage(countryImageView, "flags/" + newValue);
                displayImage(teamImageView, "associations/" +newValue);

            }
        });
        txtPlayerAssociation.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setVerband(newValue);
               // displayImage(teamImageView, "associations/" +newValue);
            }
        });
        txtPlayerFifa.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setFifa_spiele(newValue);
            }
        });
        txtPlayerRSSSF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setRsssf_spiele(newValue);
            }
        });
        txtPlayerHundrethGame.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setHundertesSpiel(newValue);
            }
        });
        txtPlayerFirstGame.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setStartjahr(newValue);
            }
        });
        txtPlayerBirthDate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setBirthday(newValue);
            }
        });
        txtPlayerPosition.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setPosition(newValue);
            }
        });
        txtPlayerAgainst.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setGegner(newValue);
            }
        });
        txtPlayerLetztesSpiel.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setEndjahr(newValue);
            }
        });
    }

    private boolean isItemSelected() {
        return playerTableView.getSelectionModel().getSelectedItem() != null;
    }

    private void setupBindings() {
        lblPlayerRang.textProperty().bindBidirectional(model.getPlayerPlatz());
        txtPlayerName.textProperty().bindBidirectional(model.getPlayerName());
        txtPlayerCountry.textProperty().bindBidirectional(model.getPlayerCountry());
        txtPlayerAssociation.textProperty().bindBidirectional(model.getPlayerVerband());
        txtPlayerFifa.textProperty().bindBidirectional(model.getPlayerFifa());
        txtPlayerRSSSF.textProperty().bindBidirectional(model.getPlayerRSSSF());
        txtPlayerHundrethGame.textProperty().bindBidirectional(model.getPlayerHundertesSpiel());
        txtPlayerFirstGame.textProperty().bindBidirectional(model.getPlayerStartJahr());
        txtPlayerBirthDate.textProperty().bindBidirectional(model.getPlayerBirthDate());
        txtPlayerPosition.textProperty().bindBidirectional(model.getPlayerPosition());
        txtPlayerAgainst.textProperty().bindBidirectional(model.getPlayerGegen());
        txtPlayerLetztesSpiel.textProperty().bindBidirectional(model.getPlayerEndJahr());

        lblOverName.textProperty().bindBidirectional(model.getPlayerName());
        lblOverLand.textProperty().bindBidirectional(model.getPlayerCountry());
        lblOverStartJahr.textProperty().bindBidirectional(model.getPlayerStartJahr());
        lblOverEndJahr.textProperty().bindBidirectional(model.getPlayerEndJahr());
        lblOverLaenderspiele.textProperty().bindBidirectional(model.getPlayerMehrSpiele());
    }

    private void displayImage(ImageView target, String imgSubPath){
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(imgSubPath +".png");
        if ( null != stream){
            Image img = new Image(stream);
            target.setImage(img);
        }
    }
}
