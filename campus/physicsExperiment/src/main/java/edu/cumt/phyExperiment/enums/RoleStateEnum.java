package edu.cumt.phyExperiment.enums;

/**
 * 登录用户角色的数据字典
 */
public enum RoleStateEnum {
    ADMIN(0, "管理员"), STUDENT(1, "同学"), TEACHER(2, "老师");

    private int state;
    private String roleInfo;

    private RoleStateEnum(int state, String roleInfo) {
        this.state = state;
        this.roleInfo = roleInfo;
    }

    public int getState() { return state; }

    public String getRoleInfo() { return roleInfo; }

    public static RoleStateEnum getRoleInfoOf(int state) {
        for (RoleStateEnum roleStateEnum : values()) {
            if (roleStateEnum.state == state) {
                return roleStateEnum;
            }
        }
        return null;
    }
}
