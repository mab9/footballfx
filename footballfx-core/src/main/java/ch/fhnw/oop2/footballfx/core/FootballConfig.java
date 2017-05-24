package ch.fhnw.oop2.footballfx.core;

import org.springframework.context.annotation.Configuration;

import ch.fhnw.oop2.footballfx.core.api.FootballApi;
import ch.fhnw.oop2.footballfx.core.business.FootballService;
import ch.fhnw.oop2.footballfx.core.dataaccess.FootballRepository;

@Configuration
public class FootballConfig {

    public FootballConfig() {
    }

    public FootballApi footballApi() {
        return new FootballApi(footballService());
    }

    public FootballService footballService() {
        return new FootballService(footballRepository());
    }

    public FootballRepository footballRepository() {
        return new FootballRepository();
    }

}
