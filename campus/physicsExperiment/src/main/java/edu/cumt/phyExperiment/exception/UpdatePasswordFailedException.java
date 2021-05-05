package edu.cumt.phyExperiment.exception;

/**
 * 修改密码失败异常
 */
public class UpdatePasswordFailedException extends RuntimeException {
    public UpdatePasswordFailedException(String message) {
        super(message);
    }

    public UpdatePasswordFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
