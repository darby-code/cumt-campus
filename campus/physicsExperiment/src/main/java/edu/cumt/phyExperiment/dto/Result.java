package edu.cumt.phyExperiment.dto;

/**
 * 封装部分结果并作为json对象返回至前端
 * @param <T>
 */
public class Result<T> {

    /**
     * 是否成功标识符
     */
    private boolean success;
    /**
     * 成功时返回的数据
     */
    private T data;
    /**
     * 返回的消息，用于告知用户
     */
    private String message;

    /**
     * 返回消息的状态字，用于前端处理消息
     */
    private Integer state;
    /**
     * 默认构造器
     */
    public Result() {
        super();
    }

    /**
     * 成功时的构造器
     * @param success
     * @param data
     */
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    /**
     * 失败时的构造器
     * 如果成功时返回的数据是字符串，则也可用
     * @param success
     * @param message
     */
    public Result(boolean success, String message, Integer state) {
        this.success = success;
        this.message = message;
        this.state = state;
    }

    /*********************getter和setter方法***********************************/
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", state=" + state +
                '}';
    }
}
