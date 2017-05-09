package ch.fhnw.oop2.footballfx.presentationmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {

    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty birthDate = new SimpleStringProperty();
    private final StringProperty country = new SimpleStringProperty();
    private final StringProperty verband = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();
    private final StringProperty hundertesSpiel = new SimpleStringProperty();
    private final StringProperty gegen = new SimpleStringProperty();
    private final StringProperty fifa = new SimpleStringProperty();
    private final StringProperty rsssf = new SimpleStringProperty();
    private final StringProperty startjahr = new SimpleStringProperty();

    public StringProperty getName() {
        return name;
    }

    public StringProperty getBirthDate() {
        return birthDate;
    }

    public StringProperty getCountry() {
        return country;
    }

    public StringProperty getVerband() {
        return verband;
    }

    public StringProperty getPosition() {
        return position;
    }

    public StringProperty getHundertesSpiel() {
        return hundertesSpiel;
    }

    public StringProperty getGegen() {
        return gegen;
    }

    public StringProperty getFifa() {
        return fifa;
    }

    public StringProperty getRsssf() {
        return rsssf;
    }

    public StringProperty getStartjahr() {
        return startjahr;
    }

    public StringProperty getEndjahr() {
        return endjahr;
    }
}
