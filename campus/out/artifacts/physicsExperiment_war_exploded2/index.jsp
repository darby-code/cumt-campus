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
                        <p class="card-text">第1周绪论课，第2周选实验，第3周至第18周到实验室完成10个实验项目。
                            物理实验开放选课时间为每周周四晚上9:00，可以预约下周的实验，所选的实验在开课前一天晚上9点前可以自由选入和退出。比如第2周周三的实验选课截止时间为第2周周二晚9:00。</p>
                        <a href="http://10.100.0.121:8019/customer/index/index0.html" class="btn btn-outline-secondary">了解更多...</a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="shadow p-3 mb-5 bg-body rounded" style="margin: auto;width: 500px;height: 400px;">
                    <form method="post" action="userLogin/login.do" onsubmit="return checkAll();">
                        <div class="mb-3">
                            <label for="userAccount" class="form-label">学号/工号:</label>
                            <input type="text" class="form-control" style="width: 250px;height: 30px;" id="userAccount" name="account" aria-describedby="infoHelp"><span id="accountCheck"></span>
                            <div id="infoHelp" class="form-text">我们不会将你的信息泄漏给别人</div>
                        </div>
                        <div class="mb-3">
                            <label for="userPassword" class="form-label">密码:</label>
                            <input type="password" class="form-control" style="width: 250px;height: 30px;" id="userPassword" name="password"><span id="passwordCheck"></span>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="role" id="inlineRadio1" value="1" checked>
                            <label class="form-check-label" for="inlineRadio1">学生</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="role" id="inlineRadio2" value="2">
                            <label class="form-check-label" for="inlineRadio2">教师</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="role" id="inlineRadio3" value="0">
                            <label class="form-check-label" for="inlineRadio3">管理员</label>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-md-4">验证码</label><br/>
                            <input type="text" name="verifyCode" id="verifyCode" style="width: auto;"  class="form-control" placeholder="验证码">
                            <div class="col-md-4">
                                <img src="userLogin/getVerifyCode.do" id="kaptchaImage" onclick="changeVerifyCode();">
                            </div>
                        </div>
                        <br/>
                        <button type="submit" class="btn btn-outline-secondary">登录</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">
    function checkAccount() {
        var check = true;
        var message = "";
        var account = document.getElementById("userAccount").value;
        var regForTeacher = /100(\d){4,}/;
        var regForStudent = /1001(\d){5,}/;
        var regForAdmin = /\w{5,}/;
        var ratios = document.getElementsByName("role");
        if (ratios[0].checked) {
            //验证学生，只验证账号是否符合规则，以及密码长度
            if (!regForStudent.test(account)) {
                message = "学号不正确";
                check =  false;
            }
        } else if (ratios[1].checked) {
            //验证教师
            if (!regForTeacher.test(account)) {
                message = "教师工号不正确";
                check = false;
            }
        } else if (ratios[2].checked) {
            //验证管理员
            if (!regForAdmin.test(account)) {
                message = "管理员账户非法";
                check = false;
            }
        }
        document.getElementById("accountCheck").innerHTML = message;
        return check;
    }
    function checkPassword() {
        var check = true;
        var message = "";
        var password = document.getElementById("userPassword").value;
        if (password.length < 8) {
           message = "密码长度至少为8位";
           check = false;
        }
        document.getElementById("passwordCheck").innerHTML = message;
        return check;
    }
    function checkAll() {
        var check = checkAccount() && checkPassword();
        return check;
    }
    function changeVerifyCode() {
        var imgChange = document.getElementById("kaptchaImage");
        imgChange.click(function () {
            imgChange.setAttribute("src", "/userLogin/getVerifyCode.do?" + Math.floor(Math.random() * 100));
        })
    }
</script>
</body>
</html>
