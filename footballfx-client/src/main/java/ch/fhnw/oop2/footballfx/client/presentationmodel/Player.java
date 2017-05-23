package ch.fhnw.oop2.footballfx.client.presentationmodel;

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
    private final StringProperty number = new SimpleStringProperty();
    private final StringProperty startjahr = new SimpleStringProperty();
    private final StringProperty endjahr = new SimpleStringProperty();

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

    public StringProperty getStartJahr() {
        return startjahr;
    }

    public StringProperty getEndJahr() {
        return endjahr;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public void setVerband(String verband) {
        this.verband.set(verband);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setHundertesSpiel(String hundertesSpiel) {
        this.hundertesSpiel.set(hundertesSpiel);
    }

    public void setGegen(String gegen) {
        this.gegen.set(gegen);
    }

    public void setFifa(String fifa) {
        this.fifa.set(fifa);
    }

    public void setRsssf(String rsssf) {
        this.rsssf.set(rsssf);
    }

    public void setStartjahr(String startjahr) {
        this.startjahr.set(startjahr);
    }

    public void setEndjahr(String endjahr) {
        this.endjahr.set(endjahr);
    }

    public void setNumber(String number) { this.number.set(number);
    }

    public StringProperty getNumber() {
        return number;
    }
}
