package sunghs.rest.api.exception;

public class UserException extends RuntimeException {

    public UserException(final String msg) {
        super("userException : " + msg);
    }
}
