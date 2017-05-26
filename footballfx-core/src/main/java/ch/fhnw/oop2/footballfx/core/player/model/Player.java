package ch.fhnw.oop2.footballfx.core.player.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Player {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String platz;
    private String name;
    private String birthday;
    private String country;
    private String verband;
    private String position;

    @Column(name = "hundertes_spiel")
    private String hundertesSpiel;
    private String gegner;
    private String fifa_spiele;
    private String rsssf_spiele;
    private String startjahr;
    private String endjahr;

    public UUID getId() {
        return id;
    }

    public String getPlatz() {
        return platz;
    }

    public void setPlatz(String platz) {
        this.platz = platz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getGegner() {
        return gegner;
    }

    public void setGegner(String gegner) {
        this.gegner = gegner;
    }

    public String getFifa_spiele() {
        return fifa_spiele;
    }

    public void setFifa_spiele(String fifa_spiele) {
        this.fifa_spiele = fifa_spiele;
    }

    public String getRsssf_spiele() {
        return rsssf_spiele;
    }

    public void setRsssf_spiele(String rsssf_spiele) {
        this.rsssf_spiele = rsssf_spiele;
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
