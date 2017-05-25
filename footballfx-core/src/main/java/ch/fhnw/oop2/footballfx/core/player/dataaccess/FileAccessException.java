package ch.fhnw.oop2.footballfx.core.player.dataaccess;

public class FileAccessException extends Exception {

    public FileAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileAccessException(String message) {
        super(message);
    }
}
