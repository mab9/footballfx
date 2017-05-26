package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ch.fhnw.oop2.footballfx.core.player.model.Player;

public interface PlayerRepositoryInterface extends CrudRepository<Player, UUID> {
}
