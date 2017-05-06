package ch.fhnw.oop2.footballfx.view;

import ch.fhnw.oop2.footballfx.presentationmodel.PresentationModel;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ApplicationUI extends StackPane {

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
    private Label playerName; // Label für name
    private Label playerCountry; // Label für Country
    private Label playerLaenderspiele; // Label für Anzahl länderspiele (Nummer)
    private Label textLaenderspiele; // Label für text "Länderspiele"
    private Label playerStartYear; // Label für startjahr
    private Label playerEndYear; // Label für endjahr
    private Label textName; // Label für text "NAme"
    private Label textLand; // Label für text "Land"
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
        // Init buttons
        buttonAdd = new Button();
        buttonRemove = new Button();
        buttonSave = new Button();
        buttonUndo = new Button();
        buttonRedo = new Button();

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
        playerName = new Label();
        playerCountry = new Label();
        playerLaenderspiele = new Label();
        playerStartYear = new Label();
        playerEndYear = new Label();
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


    }

    private void layoutControls() {
        getChildren().add(button);
    }

    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {
    }

    private void setupBindings() {
        button.textProperty().bind(model.greetingProperty());
    }
}
