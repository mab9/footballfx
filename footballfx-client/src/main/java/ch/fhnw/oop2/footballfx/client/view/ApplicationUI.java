package ch.fhnw.oop2.footballfx.client.view;

import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;
import ch.fhnw.oop2.footballfx.client.presentationmodel.PresentationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApplicationUI extends VBox {

    private final PresentationModel model;

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
    private TextField txtPlayerGegen;
    private TextField txtPlayerFifa;
    private TextField txtPlayerRSSSF;
    private TextField txtPlayerPosition;
    private TextField txtPlayerBirthDate;
    private TextField txtPlayerHundertesSpiel;
    private TextField txtPlayerErstesSpiel;
    private TextField txtPlayerLetztesSpiel;
    private TextField txtPlayerVerband;
    private Label lblTextLaenderspiele;
    private Label lblPlayerPlatz;
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
    private Locale localeDE;
    private Locale localeEN;
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
    }

    private void initializeSelf() {
        String stylesheet = ClassLoader.getSystemClassLoader().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {

        localeDE = new Locale("en","US");
        localeEN = new Locale("de","DE");

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
        txtPlayerVerband = new TextField();
        txtPlayerFifa = new TextField();
        txtPlayerRSSSF = new TextField();
        txtPlayerHundertesSpiel = new TextField();
        txtPlayerErstesSpiel = new TextField();
        lblPlayerPlatz = new Label();
        txtPlayerBirthDate = new TextField();
        txtPlayerPosition = new TextField();
        txtPlayerGegen = new TextField();
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
        HBox hBox = new HBox();
        ToolBar toolBar = new ToolBar();
        GridPane gridTop = new GridPane();
        gridTop.getStyleClass().add("gridTop");
        GridPane gridBottom = new GridPane();
        gridBottom.getStyleClass().add("gridBottom");
        VBox vBoxright = new VBox();
        vBoxright.getChildren().addAll(gridTop, gridBottom);
        vBoxright.setSpacing(10);
        gridTop.setHgap(3);
        gridTop.setVgap(3);

        // Add toolbar
        toolBar.getItems().addAll(buttonSavePlayer, buttonAddPlayer, buttonRemovePlayer, comboBoxLanguges);

        // Add Grid
        gridTop.add(lblOverName, 0, 0, 4, 1);
        gridTop.add(lblOverLand, 0, 1);
        gridTop.add(countryImageView, 3, 1, 1, 2);
        gridTop.add(lblOverLaenderspiele, 0, 2);
        gridTop.add(lblTextLaenderspiele, 1, 2);
        gridTop.add(teamImageView, 3, 2, 1, 2);
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
        gridBottom.add(txtPlayerVerband, 1, 2);
        gridBottom.add(txtPlayerFifa, 1, 3);
        gridBottom.add(txtPlayerHundertesSpiel, 1, 4);
        gridBottom.add(txtPlayerErstesSpiel, 1, 5);

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
        gridBottom.add(lblPlayerPlatz, 3, 2);
        gridBottom.add(txtPlayerRSSSF, 3, 3);
        gridBottom.add(txtPlayerGegen, 3, 4);
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

        ObservableList<Locale> options =
                FXCollections.observableArrayList(
                    localeDE,
                    localeEN
                );
        comboBoxLanguges.setItems(options);
        comboBoxLanguges.getSelectionModel().select(0);
        comboBoxLanguges.setOnAction((event) -> {
            setTextLocalized();
        });
        hBox.getChildren().addAll(playerTableView, vBoxright);
        this.getChildren().addAll(toolBar, hBox);
    }
    private void setTextLocalized(){
        // Text for Overview
        String lStringsplit[] = comboBoxLanguges.getValue().toString().split("_");
        Locale locale = new Locale(lStringsplit[0].toString(),lStringsplit[1].toString());
        ResourceBundle messages = ResourceBundle.getBundle("MessegesBundle", locale);
        //lblOverName.setText("");
        //lblOverLand.setText("");
        //lblOverLaenderspiele.setText("");
        lblTextLaenderspiele.setText(messages.getString("internationalgames"));
        //lblOverStartJahr.setText("");
        lblTextBis.setText(messages.getString("to"));
        //lblOverEndJahr.setText("");

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
            Player player = new Player();
            playerTableView.getItems().add(player);
            playerTableView.getSelectionModel().select(playerTableView.getItems().size() - 1);
        });

        buttonRemovePlayer.setOnAction(e -> {
            int selectedIndex = playerTableView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                if (getSelectedPlayer(selectedIndex).getId() != null) {
                    model.removePlayer(getSelectedPlayer(selectedIndex));
                }
                playerTableView.getItems().remove(selectedIndex);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText("No player selected");
                alert.setContentText("Please select a player in the table.");
                alert.showAndWait();
            }
        });

        buttonSavePlayer.setOnAction(e -> {
            int selectedIndex = playerTableView.getSelectionModel().getSelectedIndex();
            if (getSelectedPlayer(selectedIndex).getId() != null) {
                Player updatedPlayer = model.updatePlayer(getSelectedPlayer(selectedIndex));
                playerTableView.getItems().remove(selectedIndex);
                playerTableView.getItems().add(updatedPlayer);
            } else {
                Player newPlayer = model.addPlayer(getSelectedPlayer(selectedIndex));
                playerTableView.getItems().add(newPlayer);
            }
        });
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
            }
        });
        txtPlayerVerband.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setVerband(newValue);
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
        txtPlayerHundertesSpiel.textProperty().addListener((observable, oldValue, newValue) -> {
            if (isItemSelected()) {
                playerTableView.getSelectionModel().getSelectedItem().setHundertesSpiel(newValue);
            }
        });
        txtPlayerErstesSpiel.textProperty().addListener((observable, oldValue, newValue) -> {
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
        txtPlayerGegen.textProperty().addListener((observable, oldValue, newValue) -> {
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
        lblPlayerPlatz.textProperty().bindBidirectional(model.getPlayerPlatz());
        txtPlayerName.textProperty().bindBidirectional(model.getPlayerName());
        txtPlayerCountry.textProperty().bindBidirectional(model.getPlayerCountry());
        txtPlayerVerband.textProperty().bindBidirectional(model.getPlayerVerband());
        txtPlayerFifa.textProperty().bindBidirectional(model.getPlayerFifa());
        txtPlayerRSSSF.textProperty().bindBidirectional(model.getPlayerRSSSF());
        txtPlayerHundertesSpiel.textProperty().bindBidirectional(model.getPlayerHundertesSpiel());
        txtPlayerErstesSpiel.textProperty().bindBidirectional(model.getPlayerStartJahr());
        txtPlayerBirthDate.textProperty().bindBidirectional(model.getPlayerBirthDate());
        txtPlayerPosition.textProperty().bindBidirectional(model.getPlayerPosition());
        txtPlayerGegen.textProperty().bindBidirectional(model.getPlayerGegen());
        txtPlayerLetztesSpiel.textProperty().bindBidirectional(model.getPlayerEndJahr());

        lblOverName.textProperty().bindBidirectional(model.getPlayerName());
        lblOverLand.textProperty().bindBidirectional(model.getPlayerCountry());
        lblOverStartJahr.textProperty().bindBidirectional(model.getPlayerStartJahr());
        lblOverEndJahr.textProperty().bindBidirectional(model.getPlayerEndJahr());
        lblOverLaenderspiele.textProperty().bindBidirectional(model.getPlayerMehrSpiele());
    }
}
