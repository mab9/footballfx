package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.player.model.Country;

public class CountryRepository {

    @Autowired
    private CountryRepositoryInterface repository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public CountryRepository() {
    }

    public Iterable<Country> findAll() {
        return repository.findAll();
    }

    public Country findById(UUID id) {
        return repository.findOne(id);
    }
}
