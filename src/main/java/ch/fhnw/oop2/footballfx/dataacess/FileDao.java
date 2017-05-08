package ch.fhnw.oop2.footballfx.dataacess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileDao {

    public FileDao() {
    }

    public Stream<String> readFile(Path path) throws FileAccessException {
        try {
            InputStream data = ClassLoader.getSystemResourceAsStream(path.getFileName().toString());
            return new BufferedReader(new InputStreamReader(data)).lines();
        } catch (NullPointerException e) {
            throw new FileAccessException("Could not read file: " + path.getFileName() + ".", e);
        }
    }

    public void saveFile(Path path, Stream<String> data) throws FileAccessException {
        try {
            // TODO adjust path so that it writes via relative path to resources.
            Files.write(path, (Iterable<String>) data::iterator);
        } catch (IOException e) {
            throw new FileAccessException("Could not save file: " + path.getFileName() + ".", e);
        }
    }
}
