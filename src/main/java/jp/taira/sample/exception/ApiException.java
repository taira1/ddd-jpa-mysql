package jp.taira.sample.exception;

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApiException(final String message) {
        super(message);
    }
}
