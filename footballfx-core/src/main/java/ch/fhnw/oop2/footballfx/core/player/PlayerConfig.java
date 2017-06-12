package ch.fhnw.oop2.footballfx.core.player;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.fhnw.oop2.footballfx.core.player.business.PlayerService;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.AssociationRepository;
import ch.fhnw.oop2.footballfx.core.player.dataaccess.PlayerRepository;

@Configuration
public class PlayerConfig {

    public PlayerConfig() {
    }

    @Bean
    public PlayerService playerService() {
        return new PlayerService(playerRepository(), associationRepository());
    }

    @Bean
    public PlayerRepository playerRepository() {
        return new PlayerRepository();
    }

    @Bean
    public AssociationRepository associationRepository() {
        return new AssociationRepository();
    }
}
