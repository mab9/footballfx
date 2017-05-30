package ch.fhnw.oop2.footballfx.core.base;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import ch.fhnw.oop2.footballfx.core.player.api.PlayerApi;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PlayerApi.class);
        register(CorsResponseFilter.class);
    }
}
