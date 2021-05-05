package edu.cumt.phyExperiment.enums;

public enum LoginStateEnum {

    LOGIN_SUCCESS(0, "登录成功"), SECURITY_CODE_ERROR(-1, "验证码错误"),
    STUDENT_ID_NOT_EXISTS(-2, "学号不存在"), TEACHER_ID_NOT_EXISTS(-3, "教师工号不存在"),
    ADMIN_ACCOUNT_NOT_EXISTS(-4, "管理员账号不存在"),PASSWORD_ERROR(-5, "密码错误"),
    LOGIN_ERROR(-5, "登陆时遇到错误，请重试"), ROLE_NOT_EXISTS(-6, "角色不存在");

    private int state;
    private String stateInfo;

    private LoginStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() { return state; }

    public String getStateInfo() { return stateInfo; }

    public static LoginStateEnum getStateInfoOf(int state) {
        for (LoginStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
