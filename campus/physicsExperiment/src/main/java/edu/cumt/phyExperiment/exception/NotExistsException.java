package edu.cumt.phyExperiment.exception;

/**
 * 实验不存在 异常
 */
public class NotExistsException extends RuntimeException {

    public NotExistsException(String message) {
        super(message);
    }

    public NotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
