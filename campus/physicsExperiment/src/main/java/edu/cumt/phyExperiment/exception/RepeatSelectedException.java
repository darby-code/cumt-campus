package edu.cumt.phyExperiment.exception;

/**
 * 重复选实验异常
 */
public class RepeatSelectedException extends RuntimeException {

    public RepeatSelectedException(String message) {
        super(message);
    }

    public RepeatSelectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
