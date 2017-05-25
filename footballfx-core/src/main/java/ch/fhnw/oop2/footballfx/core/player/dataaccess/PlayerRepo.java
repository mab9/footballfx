package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import org.springframework.data.repository.CrudRepository;

import ch.fhnw.oop2.footballfx.core.player.model.Player;

public interface PlayerRepo extends CrudRepository<Player, Long> {
}
