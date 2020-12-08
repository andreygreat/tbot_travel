package by.resliv.travel.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(final int statusCode,
                               final String message) {
        super(message);
    }
}
