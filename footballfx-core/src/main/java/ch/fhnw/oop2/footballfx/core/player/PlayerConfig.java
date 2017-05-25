package ch.fhnw.oop2.footballfx.core.player;

import org.springframework.context.annotation.Configuration;

import ch.fhnw.oop2.footballfx.core.player.api.PlayerApi;
import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;

@Configuration
public class PlayerConfig {

    public PlayerConfig() {
    }

    public PlayerApi playerApi() {
        return new PlayerApi(playerService());
    }

    public PlayerService playerService() {
        return new PlayerService(playerRepository());
    }

    public PlayerRepository playerRepository() {
        return new PlayerRepository();
    }

}
