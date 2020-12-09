package by.resliv.travel.exceptions;

public class BadRequestException extends RuntimeException {
    private int statusCode;
    private String message;
    public BadRequestException(final int statusCode,
                               final String message) {
        super(message);
        this.statusCode =  statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
