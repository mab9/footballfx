package ch.fhnw.oop2.footballfx.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import ch.fhnw.oop2.footballfx.core.player.dataaccess.AssociationRepositoryInterface;
import ch.fhnw.oop2.footballfx.core.player.model.Association;

import static org.assertj.core.api.Assertions.assertThat;

public class AssociationRepositoryTest extends JpaTest {

    @Autowired
    private AssociationRepositoryInterface repositoryInterface;

    @Test
    public void findAllAssociations() {
        Iterable<Association> association = repositoryInterface.findAll();
        assertThat(association).isNotNull();
    }

    @Test
    public void findAssociationById() {
        Iterable<Association> association = repositoryInterface.findAll();
        Association expectedAssociation = association.iterator().next();

        Association actualAssociation = repositoryInterface.findOne(expectedAssociation.getId());
        assertThat(actualAssociation).isNotNull();
        assertThat(actualAssociation.getId()).isEqualTo(expectedAssociation.getId());
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void findAssociationByIdNotExisting() {
        repositoryInterface.findOne(null);
    }
}
