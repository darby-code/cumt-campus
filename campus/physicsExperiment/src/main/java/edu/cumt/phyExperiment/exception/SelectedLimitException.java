package edu.cumt.phyExperiment.exception;

/**
 * 学生已选实验已达到实验选课数量上限异常
 */
public class SelectedLimitException extends RuntimeException {

    public SelectedLimitException(String message) {
        super(message);
    }

    public SelectedLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
