package ch.fhnw.oop2.footballfx.dataacess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDao {

    public FileDao() {
    }

    public byte[] readFile(Path path) throws FileAccessException {
        try {
            return Files.readAllBytes(path.getFileName());
        } catch (IOException e) {
            throw new FileAccessException("Could not read file: " + path.getFileName() + ".", e);
        }
    }

    public void saveFile(Path path, byte[] data) throws FileAccessException {
        try {
            Files.write(path, data);
        } catch (IOException e) {
            throw new FileAccessException("Could not save file: " + path.getFileName() + ".", e);
        }
    }
}
