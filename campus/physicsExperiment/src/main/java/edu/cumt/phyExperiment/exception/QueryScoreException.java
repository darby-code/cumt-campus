package edu.cumt.phyExperiment.exception;

public class QueryScoreException extends RuntimeException {

    public QueryScoreException(String message) {
        super(message);
    }

    public QueryScoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
