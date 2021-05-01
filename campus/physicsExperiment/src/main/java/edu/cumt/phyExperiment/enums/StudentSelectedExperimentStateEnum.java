package edu.cumt.phyExperiment.enums;

public enum StudentSelectedExperimentStateEnum {
    DROP_SUCCESS(2, "退选实验成功"), SUCCESS(1, "实验选课成功")
    , NO_MARGIN(0, "实验可选人数已达上限"),
    CONFLICT(-1, "所选实验与已选实验冲突"), LIMIT(-2, "已达到实验选课数量上限"),
    NOT_ALLOW(-3, "该实验已关闭选课"), NOT_EXISTS(-4, "所选实验不存在"),
    REPEAT_SELECT(-5, "重复选课"), INNER_ERROR(-6, "系统异常"),
    TOO_MANY_HITS(-7, "该实验选课人数过多，请选择别的实验"), DROP_FAILED(-8, "退选实验失败");

    private int state;
    private String stateInfo;

    private StudentSelectedExperimentStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() { return state; }

    public String getStateInfo() { return stateInfo; }

    public static StudentSelectedExperimentStateEnum getStateInfoOf(int state) {
        for (StudentSelectedExperimentStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
