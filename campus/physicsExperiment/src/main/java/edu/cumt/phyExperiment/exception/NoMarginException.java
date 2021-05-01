package edu.cumt.phyExperiment.exception;

/**
 * 实验可选人数已达上限异常
 */
public class NoMarginException extends RuntimeException {
    public NoMarginException(String message) {
        super(message);
    }

    public NoMarginException(String message, Throwable cause) {
        super(message, cause);
    }
}
