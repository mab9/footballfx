package ch.fhnw.oop2.footballfx.view;

import ch.fhnw.oop2.footballfx.presentationmodel.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditView extends VBox {

    private final Player player;

    private Button buttonSave;
    private Button buttonCancle;

    private ImageView countryImageView;
    private ImageView teamImageView;

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
    private Label playerRang;
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

    public EditView(Player player) {
        this.player = player;
        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        String stylesheet = ClassLoader.getSystemClassLoader().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        // Init buttons
        buttonSave = new Button();
        buttonCancle = new Button();
        buttonSave.setText("save");
        buttonCancle.setText("cancle");

        countryImageView = new ImageView();
        teamImageView = new ImageView();

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
        playerRang = new Label();
        playerBirthDate = new TextField();
        playerPosition = new TextField();
        playerRang = new Label();
        playerRSSSF = new TextField();
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
        toolBar.getItems().addAll(buttonSave, buttonCancle);
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
        gridBottom.add(playerRang, 3, 2);
        gridBottom.add(playerRSSSF, 3, 3);
        gridBottom.add(playerGegen, 3, 4);
        gridBottom.add(playerLetztesSpiel, 3, 5);

        // Text for Overview
        lblOverName.setText("Ahmed Hassan");
        lblOverLand.setText("Ägypten");
        lblOverLaenderspiele.setText("184");
        lblTextLaenderspiele.setText("Länderspiele");
        lblOverStartJahr.setText("2020");
        lblTextBis.setText("bis");
        lblOverEndJahr.setText("2021");

        // Text for Editor
        lblTextName.setText("Name");
        lblTextLand.setText("Land");
        lblTextVerband.setText("Verband");
        lblTextSpieleFifa.setText("Spiele (FIFA)");
        lblTextSpieleRSSSF.setText("Spiele (RSSSF)");
        lblTextHundertesSpiel.setText("100. Spiel");
        lblTextGegen.setText("gegen");
        lblTextErstesSpiel.setText("Erstes Spiel");
        lblTextLetztesSpiel.setText("Letztes Spiel");
        lblTextBirthDate.setText("Geburtsdatum");
        lblTextPosition.setText("Position");
        lblTextRang.setText("Rang");

        hBox.getChildren().addAll(vBoxright);
        this.getChildren().addAll(toolBar, hBox);
    }

    private void setupEventHandlers() {
        buttonSave.setOnAction(e -> {
        });
        buttonCancle.setOnAction(e -> {
        });
    }

    private void setupValueChangedListeners() {

    }

    private void setupBindings() {
        /*
         * playerName.textProperty().bindBidirectional(model.getPlayerName());
         * playerCountry.textProperty().bindBidirectional(model.getPlayerCountry());
         * playerLaenderspiele.textProperty().bindBidirectional(model.getPlayerLaenderspiele());
         * playerStartJahr.textProperty().bindBidirectional(model.getPlayerStartJahr());
         * playerEndJahr.textProperty().bindBidirectional(model.getPlayerEndJahr());
         * playerVerband.textProperty().bindBidirectional(model.getPlayerVerband());
         * playerFifa.textProperty().bindBidirectional(model.getPlayerFifa());
         * playerRSSSF.textProperty().bindBidirectional(model.getPlayerRSSSF());
         * playerHundertesSpiel.textProperty().bindBidirectional(model.getPlayerHundertesSpiel());
         * playerErstesSpiel.textProperty().bindBidirectional(model.getPlayerErstesSpiel());
         * playerBirthDate.textProperty().bindBidirectional(model.getPlayerBirthDate());
         * playerPosition.textProperty().bindBidirectional(model.getPlayerPosition());
         * playerGegen.textProperty().bindBidirectional(model.getPlayerGegen());
         * playerLetztesSpiel.textProperty().bindBidirectional(model.getPlayerLetztesSpiel());
         */
    }
}
