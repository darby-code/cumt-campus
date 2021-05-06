package edu.cumt.phyExperiment.enums;

/**
 * 性别数据字典
 */
public enum SexEnum {

    MAN(false, "男"), WOMAN(true, "女");

    private Boolean sex;
    private String info;

    private SexEnum(boolean sex, String info) {
        this.sex = sex;
        this.info = info;
    }

    public boolean getSex() {
        return sex;
    }

    public String getInfo() {
        return info;
    }

    public static SexEnum getSexEnumBy(boolean sex) {
        for (SexEnum sexEnum : values()) {
            if (sex == sexEnum.sex) {
                return sexEnum;
            }
        }
        return null;
    }
}
