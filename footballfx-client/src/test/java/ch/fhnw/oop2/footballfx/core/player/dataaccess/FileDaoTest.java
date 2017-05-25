package ch.fhnw.oop2.footballfx.core.player.dataaccess;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

import ch.fhnw.oop2.footballfx.client.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.client.dataacess.FileDao;

import static org.junit.Assert.assertTrue;

public class FileDaoTest {

    private FileDao fileDao = new FileDao();

    @Test
    public void readFile() throws FileAccessException, IOException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        String headerLine = data.findFirst().get();
        assertTrue(headerLine.contains("#Platz; Name;Geboren;"));
    }

    @Test(expected = FileAccessException.class)
    public void failReadFileNotExisting() throws FileAccessException {
        fileDao.readFile(Paths.get("playerssssss.csv"));
    }

    @Ignore
    @Test
    public void saveFile() throws FileAccessException, IOException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        List<String> fileRows = data.collect(Collectors.toList());

        String row = "something";
        fileRows.add(row);

        fileDao.saveFile((Paths.get("player.csv")), fileRows.stream());

        Stream<String> updatedData = fileDao.readFile(Paths.get("player.csv"));
        List<String> updatedFileRows = updatedData.collect(Collectors.toList());
        assertTrue(updatedFileRows.contains(row));
    }

    @Test(expected = FileAccessException.class)
    public void failSaveFile() throws FileAccessException, IOException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        List<String> fileRows = data.collect(Collectors.toList());

        String row = "something";
        fileRows.add(row);

        fileDao.saveFile((Paths.get("notExistingFile.csv")), fileRows.stream());
    }
}
