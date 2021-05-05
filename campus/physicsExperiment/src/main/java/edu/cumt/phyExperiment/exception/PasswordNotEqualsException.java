package edu.cumt.phyExperiment.exception;

/**
 * 密码与原始密码不匹配异常
 */
public class PasswordNotEqualsException extends RuntimeException {

    public PasswordNotEqualsException(String message) {
        super(message);
    }

    public PasswordNotEqualsException(String message, Throwable cause) {
        super(message, cause);
    }
}
