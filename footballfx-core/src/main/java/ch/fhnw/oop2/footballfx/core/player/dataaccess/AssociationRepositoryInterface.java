package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ch.fhnw.oop2.footballfx.core.player.model.Association;

public interface AssociationRepositoryInterface extends CrudRepository<Association, UUID> {
}
