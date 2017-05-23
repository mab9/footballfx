package ch.fhnw.oop2.footballfx.client.dataacess;

public class FileAccessException extends Exception {

    public FileAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileAccessException(String message) {
        super(message);
    }
}