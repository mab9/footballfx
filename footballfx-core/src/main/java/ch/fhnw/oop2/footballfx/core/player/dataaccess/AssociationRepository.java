package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.fhnw.oop2.footballfx.core.player.model.Association;

public class AssociationRepository {

    @Autowired
    private AssociationRepositoryInterface repository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public AssociationRepository() {
    }

    public Iterable<Association> findAll() {
        return repository.findAll();
    }

    public Association findById(UUID id) {
        return repository.findOne(id);
    }
}
