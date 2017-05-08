package ch.fhnw.oop2.footballfx.dataaccess;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import ch.fhnw.oop2.footballfx.dataacess.FileAccessException;
import ch.fhnw.oop2.footballfx.dataacess.FileDao;

import static org.junit.Assert.assertTrue;

public class FileDaoTest {

    private FileDao fileDao = new FileDao();

    @Test
    public void readFile() throws FileAccessException, IOException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        String headerLine = data.findFirst().get();
        assertTrue(headerLine.contains("#Platz; Name;Geboren;"));
    }

    @Test
    public void failReadFileNotExisting() throws FileAccessException {
        fileDao.readFile(Paths.get("playerssssss.csv"));
    }

    @Test
    public void saveFile() throws FileAccessException, IOException {
        Stream<String> data = fileDao.readFile(Paths.get("player.csv"));
        List<String> fileRows = data.collect(Collectors.toList());

        String row = "something";
        fileRows.add(row);
        fileDao.saveFile(Paths.get("player.csv"), fileRows.stream());

        Stream<String> updatedData = fileDao.readFile(Paths.get("player.csv"));
        List<String> updatedFileRows = updatedData.collect(Collectors.toList());
        assertTrue(updatedFileRows.contains(row));
    }
}
