package edu.cumt.phyExperiment.exception;

/**
 * 实验限选学院异常，产生条件为：实验不对学生所在学院开放
 */
public class CollegeLimitException extends RuntimeException {

    public CollegeLimitException(String message) {
        super(message);
    }

    public CollegeLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
