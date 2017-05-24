package ch.fhnw.oop2.footballfx.client.view;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.presentationmodel.Player;
import ch.fhnw.oop2.footballfx.presentationmodel.PresentationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import ch.fhnw.oop2.footballfx.client.presentationmodel.Player;
import ch.fhnw.oop2.footballfx.client.presentationmodel.PresentationModel;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
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
    private Button buttonUndoAction;
    private Button buttonRedoAction;
    private Button buttonSaveData;
    private Button buttonChangeLanguage;
    private TextField search;
    private TableView<Player> playerTableView;
    private ImageView countryImageView;
    private ImageView teamImageView;
    private ToolBar toolBar;
    private TextField playerName;
    private TextField playerCountry;
    private TextField playerLaenderspiele;
    private Label lblTextLaenderspiele;
    private TextField playerStartJahr;
    private TextField playerEndJahr;
    private TextField playerGegen;
    private TextField playerFifa;
    private TextField playerRSSSF;
    private TextField playerPosition;
    private TextField playerBirthDate;
    private TextField playerHundertesSpiel;
    private TextField playerErstesSpiel;
    private TextField playerLetztesSpiel;
    private TextField playerVerband;
    private Label playerNumber;
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
        // Init buttons
        buttonAddPlayer = new Button();
        buttonRemovePlayer = new Button();
        buttonSaveData = new Button();
        buttonUndoAction = new Button();
        buttonRedoAction = new Button();
        buttonChangeLanguage = new Button();


        // init Textfields
        search = new TextField();

        // init Tableview
        playerTableView = new TableView();
        playerTableView.setEditable(true);

        // init Combobox
        comboBoxLanguges = new ComboBox();


        // init Imageview
        countryImageView = new ImageView();
        teamImageView = new ImageView();

        // init toolbar
        toolBar = new ToolBar();

        // init Languagedropdown in toolbar
        comboBoxLanguges = new ComboBox();

        // init Labels
        playerName = new TextField();
        playerCountry = new TextField();
        playerLaenderspiele = new TextField();
        playerStartJahr = new TextField();
        playerEndJahr = new TextField();
        playerVerband = new TextField();
        playerFifa = new TextField();
        playerRSSSF = new TextField();
        playerHundertesSpiel = new TextField();
        playerErstesSpiel = new TextField();
        playerNumber = new Label();
        playerBirthDate = new TextField();
        playerPosition = new TextField();
        playerGegen = new TextField();
        playerLetztesSpiel = new TextField();
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


        // Set Layout Gaps
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
        // this.getChildren().add(toolBar);
        toolBar.getItems().addAll(buttonSaveData, buttonAddPlayer, buttonRemovePlayer, buttonUndoAction,
                buttonRedoAction,comboBoxLanguges);
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

        // Column 0
        gridBottom.add(lblTextName, 0, 0);
        gridBottom.add(lblTextLand, 0, 1);
        gridBottom.add(lblTextVerband, 0, 2);
        gridBottom.add(lblTextSpieleFifa, 0, 3);
        gridBottom.add(lblTextHundertesSpiel, 0, 4);
        gridBottom.add(lblTextErstesSpiel, 0, 5);
        // Column 1
        gridBottom.add(playerName, 1, 0);
        gridBottom.add(playerCountry, 1, 1);
        gridBottom.add(playerVerband, 1, 2);
        gridBottom.add(playerFifa, 1, 3);
        gridBottom.add(playerHundertesSpiel, 1, 4);
        gridBottom.add(playerErstesSpiel, 1, 5);

        // Column 2
        gridBottom.add(lblTextBirthDate, 2, 0);
        gridBottom.add(lblTextPosition, 2, 1);
        gridBottom.add(lblTextRang, 2, 2);
        gridBottom.add(lblTextSpieleRSSSF, 2, 3);
        gridBottom.add(lblTextGegen, 2, 4);
        gridBottom.add(lblTextLetztesSpiel, 2, 5);

        // Column 3
        gridBottom.add(playerBirthDate, 3, 0);
        gridBottom.add(playerPosition, 3, 1);
        gridBottom.add(playerNumber, 3, 2);
        gridBottom.add(playerRSSSF, 3, 3);
        gridBottom.add(playerGegen, 3, 4);
        gridBottom.add(playerLetztesSpiel, 3, 5);

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

        numberColumn.setCellValueFactory(e -> e.getValue().getNumber());
        nameColumn.setCellValueFactory(e -> e.getValue().getName());
        birthDateColumn.setCellValueFactory(e -> e.getValue().getBirthDate());
        countryColumn.setCellValueFactory(e -> e.getValue().getCountry());
        verbandColumn.setCellValueFactory(e -> e.getValue().getVerband());
        positionColumn.setCellValueFactory(e -> e.getValue().getPosition());
        hundertesSpielColumn.setCellValueFactory(e -> e.getValue().getHundertesSpiel());
        gegenColumn.setCellValueFactory(e -> e.getValue().getGegen());
        fifaColumn.setCellValueFactory(e -> e.getValue().getFifa());
        rsssfColumn.setCellValueFactory(e -> e.getValue().getRsssf());
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
        ResourceBundle messages = ResourceBundle.getBundle("ch.fhnw.oop2.footballfx.MessegesBundle", locale);
        lblOverName.setText("");
        lblOverLand.setText("");
        lblOverLaenderspiele.setText("");
        lblTextLaenderspiele.setText(messages.getString("internationalgames"));
        lblOverStartJahr.setText("");
        lblTextBis.setText(messages.getString("to"));
        lblOverEndJahr.setText("");

        // Text for Editor
        lblTextName.setText(messages.getString("name"));
        lblTextLand.setText(messages.getString("nationality"));
        lblTextVerband.setText(messages.getString("association"));
        lblTextSpieleFifa.setText(messages.getString("fifa"));
        lblTextSpieleRSSSF.setText(messages.getString("rsssf"));
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
        fifaColumn.setText(messages.getString("fifa"));
        rsssfColumn.setText(messages.getString("rsssf"));
        startjahrColumn.setText(messages.getString("firstgame"));
        endjahrColumn.setText(messages.getString("lastgame"));

        buttonSaveData.setText(messages.getString("save"));
        buttonAddPlayer.setText(messages.getString("addplayer"));
        buttonRemovePlayer.setText(messages.getString("removeplayer"));
        buttonUndoAction.setText(messages.getString("undo"));
        buttonRedoAction.setText(messages.getString("redo"));

    }

    private void setupEventHandlers() {
        playerTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> model.showPlayerDetails(newValue));
        buttonAddPlayer.setOnAction(e -> model.addPlayer());
        buttonRemovePlayer.setOnAction(e -> {
            int selectedIndex = playerTableView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                playerTableView.getItems().remove(selectedIndex);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText("No player selected");
                alert.setContentText("Please select a player in the table.");
                alert.showAndWait();
            }

        });
        buttonSaveData.setOnAction(e -> {
            try {
                model.saveData();
            } catch (FileAccessException e1) {
                e1.printStackTrace();
            }
        });
        buttonUndoAction.setOnAction(e -> model.undoAction());
        buttonRedoAction.setOnAction(e -> model.redoAction());
    }

    private void setupValueChangedListeners() {

    }

    private void setupBindings() {
        playerNumber.textProperty().bindBidirectional(model.getPlayerNumber());
        playerName.textProperty().bindBidirectional(model.getPlayerName());
        playerCountry.textProperty().bindBidirectional(model.getPlayerCountry());
        playerLaenderspiele.textProperty().bindBidirectional(model.getPlayerLaenderspiele());
        playerVerband.textProperty().bindBidirectional(model.getPlayerVerband());
        playerFifa.textProperty().bindBidirectional(model.getPlayerFifa());
        playerRSSSF.textProperty().bindBidirectional(model.getPlayerRSSSF());
        playerNumber.textProperty().bindBidirectional(model.getPlayerNumber());
        playerHundertesSpiel.textProperty().bindBidirectional(model.getPlayerHundertesSpiel());
        playerErstesSpiel.textProperty().bindBidirectional(model.getPlayerErstesSpiel());
        playerBirthDate.textProperty().bindBidirectional(model.getPlayerBirthDate());
        playerPosition.textProperty().bindBidirectional(model.getPlayerPosition());
        playerGegen.textProperty().bindBidirectional(model.getPlayerGegen());
        playerLetztesSpiel.textProperty().bindBidirectional(model.getPlayerLetztesSpiel());

        lblOverName.textProperty().bindBidirectional(model.getPlayerName());
        lblOverLand.textProperty().bindBidirectional(model.getPlayerCountry());
        lblOverStartJahr.textProperty().bindBidirectional(model.getPlayerErstesSpiel());
        lblOverEndJahr.textProperty().bindBidirectional(model.getPlayerLetztesSpiel());
     //   countryImageView.imageProperty().bindBidirectional(model.getCountryImage());
     //   teamImageView.imageProperty().bindBidirectional(model.getTeamImage());

    }
}
