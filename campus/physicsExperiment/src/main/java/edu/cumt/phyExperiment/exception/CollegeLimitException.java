package edu.cumt.phyExperiment.exception;

public class CollegeLimitException extends RuntimeException {

    public CollegeLimitException(String message) {
        super(message);
    }

    public CollegeLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
