package edu.cumt.phyExperiment.exception;

/**
 * 查询成绩时遇到的异常
 */
public class QueryScoreException extends RuntimeException {

    public QueryScoreException(String message) {
        super(message);
    }

    public QueryScoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
