package ch.fhnw.oop2.footballfx.core.player.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String birthDate;
    private String country;
    private String verband;
    private String position;
    private String hundertesSpiel;
    private String gegen;
    private String fifa;
    private String rsssf;
    private String number;
    private String startjahr;
    private String endjahr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVerband() {
        return verband;
    }

    public void setVerband(String verband) {
        this.verband = verband;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHundertesSpiel() {
        return hundertesSpiel;
    }

    public void setHundertesSpiel(String hundertesSpiel) {
        this.hundertesSpiel = hundertesSpiel;
    }

    public String getGegen() {
        return gegen;
    }

    public void setGegen(String gegen) {
        this.gegen = gegen;
    }

    public String getFifa() {
        return fifa;
    }

    public void setFifa(String fifa) {
        this.fifa = fifa;
    }

    public String getRsssf() {
        return rsssf;
    }

    public void setRsssf(String rsssf) {
        this.rsssf = rsssf;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartjahr() {
        return startjahr;
    }

    public void setStartjahr(String startjahr) {
        this.startjahr = startjahr;
    }

    public String getEndjahr() {
        return endjahr;
    }

    public void setEndjahr(String endjahr) {
        this.endjahr = endjahr;
    }
}
