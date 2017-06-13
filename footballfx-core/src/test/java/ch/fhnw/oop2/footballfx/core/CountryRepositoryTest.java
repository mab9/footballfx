package ch.fhnw.oop2.footballfx.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.CountryRepositoryInterface;
import ch.fhnw.oop2.footballfx.core.player.model.Country;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryRepositoryTest extends JpaTest {

    @Autowired
    private CountryRepositoryInterface repository;

    @Test
    public void findAllCountry() {
        Iterable<Country> country = repository.findAll();
        assertThat(country).isNotNull();
    }

    @Test
    public void findCountryById() {
        Iterable<Country> country = repository.findAll();
        Country expectedCountry = country.iterator().next();

        Country actualCountry = repository.findOne(expectedCountry.getId());
        assertThat(actualCountry).isNotNull();
        assertThat(actualCountry.getId()).isEqualTo(expectedCountry.getId());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void findCountryByIdNotExisting() {
        repository.findOne(null);
    }
}
