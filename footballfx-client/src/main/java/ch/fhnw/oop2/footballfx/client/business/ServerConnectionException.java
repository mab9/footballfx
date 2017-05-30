package ch.fhnw.oop2.footballfx.client.business;

public class ServerConnectionException extends Exception {

    public ServerConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerConnectionException(String message) {
        super(message);
    }
}
