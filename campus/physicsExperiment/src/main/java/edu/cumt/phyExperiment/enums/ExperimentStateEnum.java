package edu.cumt.phyExperiment.enums;

/**
 * 实验选课、退课、修改成绩等相关实验操作的数据字典
 *
 */
public enum ExperimentStateEnum {
    SET_NOT_ALLOW_SELECTED_SUCCESS(6, "实验截止选课设置成功"),
    SUBMIT_SCORE_SUCCESS(4, "成绩更新成功"), SUBMIT_SCORE_SUCCESS_FINISHED(5, "实验所有成绩更新完毕"),
    SUBMIT_EXPERIMENT_SUCCESS(3, "提交实验成功，等待审核"),
    DROP_SUCCESS(2, "退选实验成功"), SUCCESS(1, "实验选课成功")
    , NO_MARGIN(0, "实验可选人数已达上限"), CONFLICT(-1, "所选实验与已选实验冲突"), LIMIT(-2, "已达到实验选课数量上限"),
    NOT_ALLOW(-3, "该实验已关闭选课"), NOT_EXISTS(-4, "所选实验不存在"),
    REPEAT_SELECT(-5, "重复选课"), INNER_ERROR(-6, "系统异常"),
    TOO_MANY_HITS(-7, "该实验选课人数过多，请选择别的实验"), COLLEGE_LIMIT(-8, "该实验不对你所在学院开放"),
    DROP_FAILED(-9, "退选实验失败"), SUBMIT_EXPERIMENT_FAILED(-10, "提交实验失败"),
    SUBMIT_SCORE_FAILED(-11, "更新成绩失败"), SET_NOT_ALLOW_SELECTED_FAILED(-12, "实验截止选课设置失败");

    private int state;
    private String stateInfo;

    private ExperimentStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() { return state; }

    public String getStateInfo() { return stateInfo; }

    public static ExperimentStateEnum getStateInfoOf(int state) {
        for (ExperimentStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
