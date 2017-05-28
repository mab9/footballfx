package ch.fhnw.oop2.footballfx.client.presentationmodel;

import java.util.UUID;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {

    private UUID id;
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty birthday = new SimpleStringProperty();
    private final StringProperty country = new SimpleStringProperty();
    private final StringProperty verband = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();
    private final StringProperty hundertesSpiel = new SimpleStringProperty();
    private final StringProperty gegner = new SimpleStringProperty();
    private final StringProperty fifa_spiele = new SimpleStringProperty();
    private final StringProperty rsssf_spiele = new SimpleStringProperty();
    private final StringProperty startjahr = new SimpleStringProperty();
    private final StringProperty endjahr = new SimpleStringProperty();
    private final StringProperty platz = new SimpleStringProperty();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getBirthday() {
        return birthday;
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

    public StringProperty getGegner() {
        return gegner;
    }

    public StringProperty getFifa_spiele() {
        return fifa_spiele;
    }

    public StringProperty getRsssf_spiele() {
        return rsssf_spiele;
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

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
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

    public void setGegner(String gegner) {
        this.gegner.set(gegner);
    }

    public void setFifa_spiele(String fifa_spiele) {
        this.fifa_spiele.set(fifa_spiele);
    }

    public void setRsssf_spiele(String rsssf_spiele) {
        this.rsssf_spiele.set(rsssf_spiele);
    }

    public void setStartjahr(String startjahr) {
        this.startjahr.set(startjahr);
    }

    public void setEndjahr(String endjahr) {
        this.endjahr.set(endjahr);
    }

    public void setPlatz(String platz) {
        this.platz.set(platz);
    }

    public StringProperty getPlatz() {
        return platz;
    }

}
