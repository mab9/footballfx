package ch.fhnw.oop2.footballfx.core.player.business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.AssociationRepository;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.CountryRepository;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;
import ch.fhnw.oop2.footballfx.core.player.model.Association;
import ch.fhnw.oop2.footballfx.core.player.model.Country;
import ch.fhnw.oop2.footballfx.core.player.model.Player;

public class PlayerService {

    private PlayerRepository playerRepository;
    private AssociationRepository associationRepository;
    private CountryRepository countryRepository;

    public PlayerService(PlayerRepository playerRepository, AssociationRepository associationRepository,
            CountryRepository countryRepository) {
        this.playerRepository = playerRepository;
        this.associationRepository = associationRepository;
    }

    public List<Player> retrieveAllPlayers() {
        Iterable<Player> players = playerRepository.findAll();
        List<Player> players1 = new ArrayList<>();
        players.forEach(players1::add);
        return players1;
    }

    public Player createPlayer(Player player) {
        return playerRepository.createPlayer(player);
    }

    public Player updatePlayer(UUID id, Player player) {
        Player update = playerRepository.findById(id);
        if (!update.getId().equals(player.getId())) {
            throw new WebApplicationException("Player: " + player.getId() + " not found.", Response.Status.NOT_FOUND);
        }
        return playerRepository.updatePlayer(player);
    }

    public void deletePlayer(UUID id) {
        Player update = playerRepository.findById(id);
        if (update == null) {
            throw new WebApplicationException("Player: " + id + " not found.", Response.Status.NOT_FOUND);
        }
        playerRepository.removePlayer(id);
    }

    public List<Association> retrieveAllAssociation() {
        Iterable<Association> associations = associationRepository.findAll();
        List<Association> associations1 = new ArrayList<>();
        associations.forEach(associations1::add);
        return associations1;
    }

    public List<Country> retrieveAllCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        List<Country> countries1 = new ArrayList<>();
        countries.forEach(countries1::add);
        return countries1;
    }
}
