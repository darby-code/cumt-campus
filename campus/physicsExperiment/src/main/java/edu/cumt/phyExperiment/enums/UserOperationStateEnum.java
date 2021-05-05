package edu.cumt.phyExperiment.enums;

public enum UserOperationStateEnum {
    MODIFY_ANNOUNCEMENT_CONTENT_SUCCESS(8, "修改公告内容成功"),
    RESET_ALL_STUDENT_PASSWORD_SUCCESS(6, "重置该学院所有学生密码成功"), RESET_ALL_TEACHER_PASSWORD_SUCCESS(7, "重置该学院所有老师密码成功"),
    RESET_STUDENT_PASSWORD_SUCCESS(4, "重置学生密码成功"), RESET_TEACHER_PASSWORD_SUCCESS(5, "修改教师密码成功"),
    UPDATE_INFO_SUCCESS(2, "修改个人信息成功"),UPDATE_PASSWORD_SUCCESS(3, "修改密码成功"),
    QUERY_INFO_SUCCESS(1, "获取个人信息成功"), QUERY_INFO_ERROR(0, "获取个人信息失败"),
    UPDATE_INFO_FAILED(-1, "修改个人信息失败"), UPDATE_PASSWORD_FAILED(-2, "修改密码失败"),
    UPDATE_PASSWORD_NOT_EQUALS(-3, "旧密码与原始密码不匹配，无法进行更新"), RESET_STUDENT_PASSWORD_FAILED(-4, "重置学生密码失败"),
    RESET_TEACHER_PASSWORD_FAILED(-5, "重置教师密码失败"), RESET_ALL_STUDENT_PASSWORD_FAILED(-6, "重置该学院所有学生密码失败"),
    RESET_ALL_TEACHER_PASSWORD_FAILED(-7, "重置该学院所有老师密码失败"), MODIFY_ANNOUNCEMENT_CONTENT_FAILED(-8, "修改公告内容失败");

    private int state;
    private String stateInfo;

    private UserOperationStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() { return state; }

    public String getStateInfo() { return stateInfo; }

    public static UserOperationStateEnum getStateInfoOf(int state) {
        for (UserOperationStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
