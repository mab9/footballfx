package ch.fhnw.oop2.footballfx.core.player.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String verband;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVerband() {
        return verband;
    }

    public void setVerband(String verband) {
        this.verband = verband;
    }
}
