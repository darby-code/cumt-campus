package edu.cumt.phyExperiment.exception;

/**
 * 实验选课系统内部异常
 */
public class SelectedException extends RuntimeException {
    public SelectedException(String message) {
        super(message);
    }

    public SelectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
