<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/2
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 70px;"></div>
    <div class="container w-75">
        <form method="post" action="user/updatePassword.do?role=${role}&roleInfo=${nowUser}&" onsubmit="updatePassword(this); return false;">
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="oldPasswordLabel">旧密码：</span>
                        <input type="password" class="form-control" id="oldPassword" onchange="setPasswordUpdateBtnNotDisable();" onblur="checkOldPassword();"  placeholder="旧密码" aria-label="oldPasswordLabel" aria-describedby="oldPasswordLabel">
                    </div>
                </div>
                <div class="col">
                    <span id="oldPasswordTip"></span>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="newPasswordLabel">新密码：</span>
                        <input type="password" class="form-control" id="newPassword" onchange="setPasswordUpdateBtnNotDisable();" onblur="checkNewPassword();" placeholder="新密码" aria-label="newPasswordLabel" aria-describedby="newPasswordLabel">
                    </div>
                </div>
                <div class="col">
                    <span id="newPasswordTip"></span>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="checkAgainLabel">再次确认：</span>
                        <input type="password" class="form-control" id="checkPassword" onchange="setPasswordUpdateBtnNotDisable();" onblur="checkCheckPassword();" placeholder="再次输入新密码" aria-label="checkAgainLabel" aria-describedby="checkAgainLabel">
                    </div>
                </div>
                <div class="col">
                    <span id="checkPasswordTip"></span>
                </div>
            </div>
            <div class="mb-3 row">
                <input type="submit" id="updatePasswordBtn" disabled class="btn btn-secondary w-25"/>
            </div>
        </form>
    </div>
</body>
</html>
