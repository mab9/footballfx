package ch.fhnw.oop2.footballfx.view;

import ch.fhnw.oop2.footballfx.presentationmodel.PresentationModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox {

    private final PresentationModel model;

    private Button buttonAdd;
    private Button buttonRemove;
    private Button buttonUndo;
    private Button buttonRedo;
    private Button buttonSave;
    private TextField search;
    private TableView playerTableView;
    private ImageView countryImageView;
    private ImageView teamImageView;
    private ToolBar toolBar;
    private TextField playerName;
    private TextField playerCountry;
    private TextField playerLaenderspiele;
    private Label textLaenderspiele;
    private TextField playerStartJahr;
    private TextField playerEndJahr;
    private TextField playerGegen;
    private TextField playerFifa;
    private TextField playerRSSSF;
    private TextField playerPosition;
    private TextField playerGeboren;
    private TextField playerHundertesSpiel;
    private TextField playerErstesSpiel;
    private TextField playerLetztesSpiel;
    private TextField playerVerband;
    private Label playerRang;
    private Label textName;
    private Label overName;
    private Label overLand;
    private Label overLaenderspiele;
    private Label overStartJahr;
    private Label overEndJahr;
    private Label textLand;
    private Label textBis;
    private Label textVerband;
    private Label textSpieleFifa;
    private Label textSpieleRSSSF;
    private Label textGeboren;
    private Label textRang;
    private Label textPosition;
    private Label textHundertesSpiel;
    private Label textGegen;
    private Label textErstesSpiel;
    private Label textLetztesSpiel;

    public ApplicationUI(PresentationModel model) {
        this.model = model;
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
        /*
         * Controls
         * text* = Labels, welche Statischen text darstellen, wie z.B "Name","Verband" etc.
         * over* = Labels, welche in der Overview verwendet werden und dynamisch nach Auswahl sich anpassen
         * player* = TextFields, welche zur Eingabe im Editorbereich verwendet werden. Ausnahme: PlayerRand = Label,
         * weil nicht vom User veränderbar,
         * 
         * 
         */
        // Init buttons
        buttonAdd = new Button();
        buttonRemove = new Button();
        buttonSave = new Button();
        buttonUndo = new Button();
        buttonRedo = new Button();
        buttonSave.setText("Save");
        buttonAdd.setText("+");
        buttonRemove.setText("-");
        buttonUndo.setText("<--");
        buttonRedo.setText("-->");

        // init Textfields
        search = new TextField();

        // init Tableview
        playerTableView = new TableView();

        // init Imageview
        countryImageView = new ImageView();
        teamImageView = new ImageView();

        // init toolbar
        toolBar = new ToolBar();

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
        playerGeboren = new TextField();
        playerPosition = new TextField();
        playerRang = new Label();
        playerRSSSF = new TextField();
        playerGegen = new TextField();
        playerLetztesSpiel = new TextField();
        textLaenderspiele = new Label();
        textName = new Label();
        textLand = new Label();
        textVerband = new Label();
        textSpieleFifa = new Label();
        textSpieleRSSSF = new Label();
        textVerband = new Label();
        textGeboren = new Label();
        textRang = new Label();
        textPosition = new Label();
        textHundertesSpiel = new Label();
        textGegen = new Label();
        textErstesSpiel = new Label();
        textLetztesSpiel = new Label();
        textBis = new Label();
        overName = new Label();
        overLand = new Label();
        overEndJahr = new Label();
        overStartJahr = new Label();
        overLaenderspiele = new Label();

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
        toolBar.getItems().addAll(buttonSave, buttonAdd, buttonRemove, buttonUndo, buttonRedo);
        // Add Grid
        gridTop.add(overName, 0, 0, 4, 1);
        gridTop.add(overLand, 0, 1);
        gridTop.add(countryImageView, 3, 1, 1, 2);
        gridTop.add(overLaenderspiele, 0, 2);
        gridTop.add(textLaenderspiele, 1, 2);
        gridTop.add(teamImageView, 3, 2, 1, 2);
        gridTop.add(overStartJahr, 0, 3);
        gridTop.add(textBis, 1, 3);
        gridTop.add(overEndJahr, 2, 3);

        // Column 0
        gridBottom.add(textName, 0, 0);
        gridBottom.add(textLand, 0, 1);
        gridBottom.add(textVerband, 0, 2);
        gridBottom.add(textSpieleFifa, 0, 3);
        gridBottom.add(textHundertesSpiel, 0, 4);
        gridBottom.add(textErstesSpiel, 0, 5);
        // Column 1
        gridBottom.add(playerName, 1, 0);
        gridBottom.add(playerCountry, 1, 1);
        gridBottom.add(playerVerband, 1, 2);
        gridBottom.add(playerFifa, 1, 3);
        gridBottom.add(playerHundertesSpiel, 1, 4);
        gridBottom.add(playerErstesSpiel, 1, 5);

        // Column 2
        gridBottom.add(textGeboren, 2, 0);
        gridBottom.add(textPosition, 2, 1);
        gridBottom.add(textRang, 2, 2);
        gridBottom.add(textSpieleRSSSF, 2, 3);
        gridBottom.add(textGegen, 2, 4);
        gridBottom.add(textLetztesSpiel, 2, 5);

        // Column 3
        gridBottom.add(playerGeboren, 3, 0);
        gridBottom.add(playerPosition, 3, 1);
        gridBottom.add(playerRang, 3, 2);
        gridBottom.add(playerRSSSF, 3, 3);
        gridBottom.add(playerGegen, 3, 4);
        gridBottom.add(playerLetztesSpiel, 3, 5);

        // Text for Overview
        overName.setText("Ahmed Hassan");
        overLand.setText("Ägypten");
        overLaenderspiele.setText("184");
        textLaenderspiele.setText("Länderspiele");
        overStartJahr.setText("2020");
        textBis.setText("bis");
        overEndJahr.setText("2021");

        // Text for Editor
        textName.setText("Name");
        textLand.setText("Land");
        textVerband.setText("Verband");
        textSpieleFifa.setText("Spiele (FIFA)");
        textSpieleRSSSF.setText("Spiele (RSSSF)");
        textHundertesSpiel.setText("100. Spiel");
        textGegen.setText("gegen");
        textErstesSpiel.setText("erstes Spiel");
        textLetztesSpiel.setText("letztes Spiel");
        textGeboren.setText("geboren");
        textPosition.setText("position");
        textRang.setText("Rang");

        hBox.getChildren().addAll(playerTableView, vBoxright);
        this.getChildren().addAll(toolBar, hBox);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
        // button.textProperty().bind(model.greetingProperty());
    }
}
