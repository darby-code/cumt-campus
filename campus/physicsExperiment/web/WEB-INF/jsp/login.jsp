<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录页面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
    <h1 class="display-1">欢迎,CUMT'er</h1>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card text-center">
                    <div class="card-header">
                        通知栏
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">选课通知</h5>
                        <p class="card-text">${announcementContent}</p>
                        <a href="http://10.100.0.121:8019/customer/index/index0.html" class="btn btn-outline-secondary">了解更多...</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="shadow p-3 mb-5 bg-body rounded" style="margin: auto;width: 360px;height: 440px;">
                    <form method="post" action="userLogin/loginCheck.do" onsubmit="loginCheck(this);return false;">
                        <div class="container">
                            <div class="mb-3 row">
                                <label for="userAccount" class="form-label">学号/工号:</label>
                                <input type="text" class="form-control" style="width: 250px;height: 30px;" id="userAccount" onchange="checkAccount();" required>
                                <div id="accountCheck" class="valid-feedback"></div>
                            </div>
                            <div class="mb-3 row">
                                <label for="userPassword" class="form-label">密码:</label>
                                <input type="password" class="form-control" style="width: 250px;height: 30px;" id="userPassword" onchange="checkPassword();" required>
                                <div id="passwordCheck" class="valid-feedback"></div>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <div class="col-md-4">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="role" id="studentRole" value="1" checked>
                                    <label class="form-check-label" for="studentRole">学生</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="role" id="teacherRole" value="2">
                                    <label class="form-check-label" for="teacherRole">教师</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="role" id="adminRole" value="0">
                                    <label class="form-check-label" for="adminRole">管理员</label>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label for="securityCode" class="form-label">请输入验证码:</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="securityCode" onchange="checkCode();" placeholder="验证码" required>
                                <div id="codeCheck" class="valid-feedback"></div>
                            </div>
                            <div class="col-md-4">
                                <img src="userLogin/getVerifyCode.do" alt="" title="看不清?点击换一张" id="kaptchaImage" onclick="changeVerifyCode();">
                            </div>

                        </div>
                        <button type="submit" id="submitBtn" class="btn btn-outline-secondary">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="base/footer.jsp" %>
<script type="text/javascript">

    function loginCheck(clickObj) {
        //登录前进行检查
        if (checkAll()) {
            //都检查通过后，进行登录验证，验证不成功不跳转
            var userAccountObj = document.getElementById("userAccount");
            var accountCheckObj = document.getElementById("accountCheck")
            var userPasswordObj = document.getElementById("userPassword");
            var passwordCheckObj = document.getElementById("passwordCheck");
            var studentRoleObj = document.getElementById("studentRole");
            var teacherRoleObj = document.getElementById("teacherRole");
            var adminRoleObj = document.getElementById("adminRole");
            var securityCodeObj = document.getElementById("securityCode");
            var codeCheckObj = document.getElementById("codeCheck");
            var submitBtnObj = document.getElementById("submitBtn");

            //请求路径拼接
            var urlPath = clickObj.action + "?userAccount=" + userAccountObj.value
                + "&userPassword=" + userPasswordObj.value + "&securityCode="
                + securityCodeObj.value + "&role=";
            if (studentRoleObj.checked) {
                //如果学生ratio被点击
                urlPath = urlPath + studentRoleObj.value;
            }
            if (teacherRoleObj.checked) {
                //如果教师ratio被点击
                urlPath = urlPath + teacherRoleObj.value;
            }
            if(adminRoleObj.checked) {
                //如果管理员ratio被点击
                urlPath = urlPath + adminRoleObj.value;
            }
            //路径完成
            var xmlhttp;
            if (window.XMLHttpRequest) {
                //通用浏览器,如Firefox Chrome  Safari
                xmlhttp = new XMLHttpRequest();
            } else {
                //IE浏览器
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && (xmlhttp.status >= 200 && xmlhttp.status < 300)) {
                    //接收到服务器端返回的JSON对象
                    var obj = JSON.parse(xmlhttp.responseText);
                    if (obj.success) {
                        //登录成功
                        //拼接跳转路径
                        // var jumpPath = 'login.do?userAccount=' + obj.userAccount + "&userPassword="
                        //     + obj.userPassword + "&role=" + obj.role;
                        document.write("<form action='login.do' method='post' name='form1' style='display:none'>");
                        document.write("<input type='hidden' name='userAccount' value='" + obj.userAccount + "'>");
                        document.write("<input type='hidden' name='userPassword' value='" + obj.userPassword + "'>");
                        document.write("<input type='hidden' name='role' value='" + obj.role + "'>");
                        document.write("</form>");
                        document.form1.submit();
                       // submitBtnObj.attachEvent('onclick', window.location.href = jumpPath);
                    } else {
                        //登录失败
                        submitBtnObj.disabled = false;
                        submitBtnObj.innerHTML = '登录';
                        //以下情况验证码都要刷新
                        if (obj.state == -1) {
                            //验证码错误
                            // userAccountObj.value = obj.userAccount;
                            // userPasswordObj.value = obj.userPassword;
                            // securityCodeObj.value = "";
                            securityCodeObj.className = "form-control is-invalid";
                            codeCheckObj.className = "invalid-feedback";
                            codeCheckObj.innerHTML = obj.stateInfo;
                            document.getElementById("kaptchaImage").attacheEvent('onclick', changeVerifyCode());
                        } else if ((obj.state == -2) || (obj.state == -3) || (obj.state == -4)) {
                            //账号不存在
                            // userAccountObj.value = "";
                            userAccountObj.className = "form-control is-invalid";
                            accountCheckObj.className = "invalid-feedback";
                            accountCheckObj.innerHTML = obj.stateInfo;
                            // userPasswordObj.value = "";
                            userPasswordObj.className = "form-control";
                            // securityCodeObj.value = "";
                            securityCodeObj.className = "form-control";
                            document.getElementById("kaptchaImage").attacheEvent('onclick', changeVerifyCode());
                        } else if (obj.state == -5) {
                            //密码错误
                            // userAccountObj.value = obj.userAccount;
                            // userPasswordObj.value = "";
                            userPasswordObj.className = "form-control is-invalid";
                            passwordCheckObj.className = "invalid-feedback";
                            passwordCheckObj.innerHTML = obj.stateInfo;
                            // securityCodeObj.value = "";
                            securityCodeObj.className = "form-control";
                            document.getElementById("kaptchaImage").attacheEvent('onclick', changeVerifyCode());
                        } else {
                            //其他错误
                            alert(obj.stateInfo);
                            document.getElementById("kaptchaImage").attacheEvent('onclick', changeVerifyCode());
                        }
                    }
                } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 400 && xmlhttp.status < 500)) {
                    alert("请检查请求内容")
                } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 500)) {
                    alert("发生了一个未知的错误");
                } else {
                    //请求过程
                    //防止重复点击
                    submitBtnObj.disabled = true;
                    submitBtnObj.innerHTML = "<span class='spinner-border spinner-border-sm' role='status' aria-hidden='true'></span><span class='visually-hidden'>登陆中...</span>"
                }
            }
            xmlhttp.open("GET", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded,charset=UTF-8");
            xmlhttp.send(null);
        }
    }

    function checkAccount() {
        var account = document.getElementById("userAccount");
        var accountCheck = document.getElementById("accountCheck");
        var regForTeacher = /^(1001)[0-9]{4,5}$/;
        var regForStudent = /^(1001)[0-9]{6,8}$/;
        var regForAdmin = /\w{5,15}/;
        var ratios = document.getElementsByName("role");
        if (ratios[0].checked) {
            //验证学生，只验证账号是否符合规则，以及密码长度
            if (!regForStudent.test(account.value)) {
                account.className = "form-control is-invalid";
                accountCheck.className = "invalid-feedback";
                accountCheck.innerHTML = "学号不正确";
                return false;
            }
        } else if (ratios[1].checked) {
            //验证教师
            if (!regForTeacher.test(account.value)) {
                account.className = "form-control is-invalid";
                accountCheck.className = "invalid-feedback";
                accountCheck.innerHTML = "教师工号不正确";
                return false;
            }
        } else if (ratios[2].checked) {
            //验证管理员
            if (!regForAdmin.test(account.value)) {
                account.className = "form-control is-invalid";
                accountCheck.className = "invalid-feedback";
                accountCheck.innerHTML = "管理员账户非法";
                return false;
            }
        }
        account.className = "form-control is-valid";
        accountCheck.className = "valid-feedback";
        accountCheck.innerHTML = "";
        return true;
    }
    function checkPassword() {
        var passwordObj = document.getElementById("userPassword");
        var passwordCheckObj = document.getElementById("passwordCheck");
        if (passwordObj.value.length < 7) {
            passwordObj.className = "form-control is-invalid";
            passwordCheckObj.className = "invalid-feedback";
            passwordCheckObj.innerHTML = "密码长度至少为7位";
           return false;
        }
        passwordObj.className = "form-control is-valid";
        passwordCheckObj.className = "valid-feedback";
        passwordCheckObj.innerHTML = "";
        return true;
    }

    //验证码检查
    function checkCode() {
        var codeInputBox = document.getElementById("securityCode");
        var codeCheckBox = document.getElementById("codeCheck");
        if (codeInputBox.value.length != 4) {
            codeInputBox.className = "form-control is-invalid";
            codeCheckBox.className = "invalid-feedback";
            codeCheckBox.innerHTML = "验证码不正确";
            return false;
        }
        codeInputBox.className = "form-control is-valid";
        codeCheckBox.className = "valid-feedback";
        codeCheckBox.innerHTML = "";
        return true;
    }

    function checkAll() {
        return checkAccount() && checkPassword() && checkCode();
    }

    //验证码刷新
    function changeVerifyCode() {
        var imgChange = document.getElementById("kaptchaImage");
        imgChange.setAttribute("src", "${pageContext.request.contextPath}//userLogin/getVerifyCode.do?" + Math.floor(Math.random() * 100));
    }
</script>
</body>
</html>
