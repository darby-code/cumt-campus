package edu.cumt.phyExperiment.exception;

/**
 * 实验已关闭选课异常
 */
public class NotAllowSelectedException extends RuntimeException {

    public NotAllowSelectedException(String message) {
        super(message);
    }

    public NotAllowSelectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
