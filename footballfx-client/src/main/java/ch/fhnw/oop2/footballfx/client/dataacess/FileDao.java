package ch.fhnw.oop2.footballfx.client.dataacess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileDao {

    private final String PROJECT_NAME = "footballplayerfx-marcantoineBruelhart";

    public FileDao() {
    }

    public Stream<String> readFile(Path path) throws FileAccessException {
        try {
            InputStream data = ClassLoader.getSystemResourceAsStream(path.getFileName().toString());
            return new BufferedReader(new InputStreamReader(data)).lines();
        } catch (NullPointerException e) {
            throw new FileAccessException("Could not load file: " + path.getFileName() + ".", e);
        }
    }

    public void saveFile(Path path, Stream<String> data) throws FileAccessException {
        try {
            Path relativePath = getRelativePathToResourceFolder(path);
            if (!Files.isWritable(relativePath)) {
                throw new FileAccessException(
                        "Could not write data to file: " + path.getFileName() + ". No write access");
            }
            Files.write(relativePath, (Iterable<String>) data::iterator);
        } catch (IOException e) {
            throw new FileAccessException("Could not write data to file: " + path.getFileName() + ".", e);
        }
    }

    private Path getRelativePathToResourceFolder(Path path) throws FileAccessException {
        try {
            Path tmpPath = Paths.get(ClassLoader.getSystemResource(path.getFileName().toString()).toURI());
            for (int i = 0; i < tmpPath.getNameCount(); i++) {
                if (PROJECT_NAME.equals(tmpPath.getName(i).toString())) {
                    return tmpPath.subpath(i + 1, tmpPath.getNameCount());
                }
            }
            throw new FileAccessException(
                    "Could not write data to file: " + path + ". File Path could not be resolved.");
        } catch (URISyntaxException | NullPointerException e) {
            throw new FileAccessException(
                    "Could not write data to file: " + path.getFileName() + ". File does not exist.");
        }
    }
}
