package ch.fhnw.oop2.footballfx.view;

import ch.fhnw.oop2.footballfx.presentationmodel.PresentationModel;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ApplicationUI extends VBox {

    private final PresentationModel model;

    private Button buttonAdd; // Button to Add a player
    private Button buttonRemove; // Button to remove a player
    private Button buttonUndo; // Button to undo
    private Button buttonRedo; // Button to redo
    private Button buttonSave; // Button to save data
    private TextField search; //Textfield für Suche
    private TableView playerTableView; // Tableview für Spieler
    private ImageView countryImageView; // IV für Landesflagge
    private ImageView teamImageView; // IV für Teamlogo
    private ToolBar toolBar; // Toolbar für Buttons
    private TextField playerName; // Label für name
    private TextField playerCountry; // Label für Country
    private TextField playerLaenderspiele; // Label für Anzahl länderspiele (Nummer)
    private Label textLaenderspiele; // Label für text "Länderspiele"
    private TextField playerStartJahr; // Label für startjahr
    private TextField playerEndJahr; // Label für endjahr
    private TextField playerGegen; // Label für endjahr
    private TextField playerFifa; // Label für endjahr
    private TextField playerRSSSF; // Label für endjahr
    private TextField playerPosition; // Label für endjahr
    private TextField playerGeboren; // Label für endjahr
    private TextField playerHundertesSpiel; // Label für endjahr
    private TextField playerErstesSpiel; // Label für endjahr
    private TextField playerLetztesSpiel; // Label für endjahr
    private TextField playerVerband; // Label für endjahr
    private Label playerRang; // Label für endjahr
    private Label textName; // Label für text "NAme"
    private Label overName; // Label für text "NAme"
    private Label overLand; // Label für text "NAme"
    private Label overLaenderspiele; // Label für text "NAme"
    private Label overStartJahr; // Label für text "NAme"
    private Label overEndJahr; // Label für text "NAme"
    private Label textLand; // Label für text "Land"
    private Label textBis; // Label für text "Bis"
    private Label textVerband; // Label für text "Verband"
    private Label textSpieleFifa; // Label für text "Spiele Fifa"
    private Label textSpieleRSSSF; // Label für text "Spiele RSSSF"
    private Label textGeboren; // Label für text "geboren"
    private Label textRang; // Label für text "Rang"
    private Label textPosition; // Label für text "Position"
    private Label textHundertesSpiel; // Label für text "100. Spiel"
    private Label textGegen; // Label für text "gegen"
    private Label textErstesSpiel; // Label für text "erstes Spiel"
    private Label textLetztesSpiel; // Label für text "letztes Spiel"



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
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {


        /* Controls
        text* = Labels, welche Statischen text darstellen, wie z.B "Name","Verband" etc.
        over* = Labels, welche in der Overview verwendet werden und dynamisch nach Auswahl sich anpassen
        player* = TextFields, welche zur Eingabe im Editorbereich verwendet werden. Ausnahme: PlayerRand = Label, weil nicht vom User veränderbar,


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
        playerRang= new Label();
        playerRSSSF= new TextField();
        playerGegen= new TextField();
        playerLetztesSpiel= new TextField();
        textLaenderspiele = new Label();
        textName= new Label();
        textLand= new Label();
        textVerband= new Label();
        textSpieleFifa= new Label();
        textSpieleRSSSF= new Label();
        textVerband= new Label();
        textGeboren= new Label();
        textRang= new Label();
        textPosition= new Label();
        textHundertesSpiel= new Label();
        textGegen= new Label();
        textErstesSpiel= new Label();
        textLetztesSpiel= new Label();
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
        vBoxright.getChildren().addAll(gridTop,gridBottom);
        vBoxright.setSpacing(10);
        gridTop.setHgap(3);
        gridTop.setVgap(3);

        // Add toolbar
       // this.getChildren().add(toolBar);
        toolBar.getItems().addAll(buttonSave,buttonAdd,buttonRemove,buttonUndo,buttonRedo);
        // Add Grid
        gridTop.add(overName,0,0,4,1);
        gridTop.add(overLand,0,1);
        gridTop.add(countryImageView,3,1,1,2);
        gridTop.add(overLaenderspiele,0,2);
        gridTop.add(textLaenderspiele,1,2);
        gridTop.add(teamImageView,3,2,1,2);
        gridTop.add(overStartJahr,0,3);
        gridTop.add(textBis,1,3);
        gridTop.add(overEndJahr,2,3);

        // Column 0
        gridBottom.add(textName,0,0);
        gridBottom.add(textLand,0,1);
        gridBottom.add(textVerband,0,2);
        gridBottom.add(textSpieleFifa,0,3);
        gridBottom.add(textHundertesSpiel,0,4);
        gridBottom.add(textErstesSpiel,0,5);
        // Column 1
        gridBottom.add(playerName,1,0);
        gridBottom.add(playerCountry,1,1);
        gridBottom.add(playerVerband,1,2);
        gridBottom.add(playerFifa,1,3);
        gridBottom.add(playerHundertesSpiel,1,4);
        gridBottom.add(playerErstesSpiel,1,5);

        // Column 2
        gridBottom.add(textGeboren,2,0);
        gridBottom.add(textPosition,2,1);
        gridBottom.add(textRang,2,2);
        gridBottom.add(textSpieleRSSSF,2,3);
        gridBottom.add(textGegen,2,4);
        gridBottom.add(textLetztesSpiel,2,5);

        //Column 3
        gridBottom.add(playerGeboren,3,0);
        gridBottom.add(playerPosition,3,1);
        gridBottom.add(playerRang,3,2);
        gridBottom.add(playerRSSSF,3,3);
        gridBottom.add(playerGegen,3,4);
        gridBottom.add(playerLetztesSpiel,3,5);

        // Text for Overview
        overName.setText("Ahmed Hassan");
        overLand.setText("Ägypten");
        overLaenderspiele.setText("184");
        textLaenderspiele.setText("Länderspiele");
        overStartJahr.setText("2020");
        textBis.setText("bis");
        overEndJahr.setText("2021");

        //Text for Editor
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

        hBox.getChildren().addAll(playerTableView,vBoxright);
        this.getChildren().addAll(toolBar,hBox);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
        //button.textProperty().bind(model.greetingProperty());
    }
}
