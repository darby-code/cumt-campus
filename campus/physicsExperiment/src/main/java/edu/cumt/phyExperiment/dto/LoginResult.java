package edu.cumt.phyExperiment.dto;

import edu.cumt.phyExperiment.enums.LoginStateEnum;

public class LoginResult {

    private boolean success;

    private String role;

    private String securityCode;

    private String userAccount;

    private String userPassword;

    private Integer state;

    private String stateInfo;

    /**
     * 登录成功的构造器
     * @param success
     * @param role
     * @param securityCode
     * @param userAccount
     * @param userPassword
     * @param stateEnum
     */
    public LoginResult(boolean success, String role, String securityCode, String userAccount,
                       String userPassword, LoginStateEnum stateEnum) {
        this.success = success;
        this.role = role;
        this.securityCode = securityCode;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 账号不存在或者登录过程失败构造器
     * @param success
     * @param stateEnum
     */
    public LoginResult(boolean success, String role, LoginStateEnum stateEnum) {
        this.success = success;
        this.role = role;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 密码错误构造器
     * @param success
     * @param userAccount
     * @param stateEnum
     */
    public LoginResult(boolean success, String role, String userAccount, LoginStateEnum stateEnum) {
        this.success = success;
        this.role = role;
        this.userAccount = userAccount;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 验证码错误构造器
     * @param success
     * @param userAccount
     * @param userPassword
     * @param stateEnum
     */
    public LoginResult(boolean success, String role, String userAccount, String userPassword, LoginStateEnum stateEnum) {
        this.success = success;
        this.role = role;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "success=" + success +
                ", role='" + role + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
