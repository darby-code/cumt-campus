package edu.cumt.phyExperiment.enums;

public enum AuditExperimentStateEnum {
    AUDIT_PASS_SUCCESS(1, "实验审核通过操作成功"), AUDIT_NOT_PASS_SUCCESS(0, "实验审核不通过操作成功"),
    AUDIT_PASS_FAILED(-1, "实验审核通过操作失败"), AUDIT_NOT_PASS_FAILED(-2, "实验审核不通过操作失败"),
    AUDIT_INNER_ERROR(-3, "实验审核过程系统内部发生错误");

    private int state;
    private String stateInfo;

    private AuditExperimentStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() { return state; }

    public String getStateInfo() { return stateInfo; }

    public static AuditExperimentStateEnum getStateInfoOf(int state) {
        for (AuditExperimentStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
