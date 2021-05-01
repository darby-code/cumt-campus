package edu.cumt.phyExperiment.exception;

/**
 * 退选实验时出现的异常
 */
public class DropExperimentException extends RuntimeException {

    public DropExperimentException(String message) {
        super(message);
    }

    public DropExperimentException(String message, Throwable cause) {
        super(message, cause);
    }
}
