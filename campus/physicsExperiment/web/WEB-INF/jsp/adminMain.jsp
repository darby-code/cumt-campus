<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员页面</title>
</head>
<body>
<div class="container-fluid">
    <%@ include file="base/header.jsp"%>
    <div class="row h-75">
        <!--左侧菜单区-->
        <div class="col-6 w-25 p-3">
            <div class="accordion" id="totalMenu">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminExperimentMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">实验管理</button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="adminExperimentMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="adminQueryExperiment" onclick="showAtRight('experiment/allExperiments.do?pageNum=1&pageSize=5');" class="btn btn-outline-secondary btn-lg">实验查询</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminDeleteExperiment" onclick="showAtRight('experiment/showAuditExperiments.do?pageNum=1&pageSize=5');" class="btn btn-outline-secondary btn-lg">待审核实验
                                    <span id="auditNumbers" class="badge rounded-pill bg-secondary">${auditNumbers == 0 ? '' : auditNumbers}</span><span class="visually-hidden">待审核实验数量</span></button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminTempExperiment" onclick="showAtRight('experiment/showAuditHistory.do?pageNum=1&pageSize=5')" class="btn btn-outline-secondary btn-lg">审核历史</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminUpdateExperiment" onclick="showAtRight('experiment/showAllowSelectedExperiments.do?pageNum=1&pageSize=4')" class="btn btn-outline-secondary btn-lg">可选实验</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminInfoMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">信息</button>
                    </h2>
                    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="adminInfoMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="adminQueryStudent" onclick="showAtRight('user/showStudentInfo.do')" class="btn btn-outline-secondary btn-lg">学生信息</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminQueryTeacher" onclick="showAtRight('user/showTeacherInfo.do')" class="btn btn-outline-secondary btn-lg">教师信息</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminUpdateMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">密码重置</button>
                    </h2>
                    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="adminUpdateMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="studentPasswordReset" onclick="showAtRight('user/showResetStudentPasswordBox.do?pageNum=1&pageSize=4')" class="btn btn-outline-secondary btn-lg">学生密码重置</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherPasswordReset" onclick="showAtRight('user/showResetTeacherPasswordBox.do?pageNum=1&pageSize=4')" class="btn btn-outline-secondary btn-lg">教师密码重置</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminAnnouncementMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">新公告发布</button>
                    </h2>
                    <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="adminAnnouncementMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="newAnnouncement" onclick="showAtRight('user/showAnnouncementContent.do')" class="btn btn-outline-secondary btn-lg">关于公告</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminSelfMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">个人信息</button>
                    </h2>
                    <div id="collapseEight" class="accordion-collapse collapse" aria-labelledby="adminSelfMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="adminSelfInfoQuery" onclick="showAdminInfo('user/adminInfo.do?account=${role.account}', this)" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminPasswordUpdate" onclick="showAtRight('user/showUpdatePasswordBox.do?role=admin&roleInfo=${role.account}')"  class="btn btn-outline-secondary btn-lg">密码修改</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--右侧显示区-->
        <div class="col-6 w-75 p-3">
            <div class="container">
                <h1 class="page-header"><i class="fa fa-cog fa-spin"></i><small>&nbsp;&nbsp;&nbsp;欢迎使用物理学院实验选课系统</small></h1>
                <!-- 载入左侧菜单指向的jsp（或html等）页面内容 -->
                <div id="content">

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    function previewContent() {
        var contentAreaObj = document.getElementById("contentArea");
        var showContentObj = document.getElementById("showContent");
        showContentObj.innerHTML = contentAreaObj.value;
    }

    function listenContentChange(changeObj) {
        document.getElementById("submitBtn").disabled = false;
    }

    function submitNewContent(urlPath, clickObj) {
        urlPath = urlPath + "newContent=" + document.getElementById("contentArea").value;
        if (confirm("确定要修改公告内容吗？")) {
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
                        //成功则更新数据
                        alert(obj.message);
                        //没有修改不再次点击
                        clickObj.disabled = true;
                    } else {
                        //告知异常
                        alert(obj.message);
                    }
                } else if (xmlhttp.readyState == 4 && xmlhttp.status == 404) {
                    alert("发生了一个未知的错误")
                }
            }
            xmlhttp.open("POST", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send();
        }
    }

    function resetPassword(urlPath, clickObj) {
        if (confirm("确定要执行该密码重置为初始值操作吗？")) {
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
                        //成功则更新数据
                        alert(obj.message);
                        clickLimit(clickObj);
                    } else {
                        //告知异常
                        alert(obj.message);
                    }
                } else if (xmlhttp.readyState == 4 && xmlhttp.status == 404) {
                    alert("发生了一个未知的错误")
                }
            }
            xmlhttp.open("POST", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send();
        }
    }

    //防止按钮频繁点击
    function clickLimit(clickObj) {
        //防止频繁点击,10s后恢复
        clickObj.disabled = true;
        setTimeout(function () {
            updateInfoBtn.disabled = false;
        }, 10000);
    }

    function setNotAllowSelected(clickObject) {
        var experimentId = clickObject.id.substr(3);
        if (confirm("确定截止该实验的选课吗？")) {
            var urlPath = 'experiment/setExperimentNotAllowSelected.do?experimentId=' + experimentId;
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
                        alert(obj.message);
                        //不能再点击
                        clickObject.disabled = true;
                    } else {
                        //告知异常
                        alert(obj.message);
                    }
                } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 400 || xmlhttp.status < 500)) {
                    alert("未知的请求");
                } else if (xmlhttp.readyState == 4 && xmlhttp.status >= 500) {
                    alert("发生了一个未知的错误");
                }
            }
            xmlhttp.open("POST", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded, ");
            xmlhttp.send();
        }
    }

    function showAtCollege(showCollegeId, urlPath) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            //通用浏览器,如Firefox Chrome  Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            //IE浏览器
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState != 4) {
                var spinStr = "";
                for (var i = 1; i <= 6; i++) {
                    spinStr += "<div class='spinner-grow' role='status'><span class='visually-hidden'>Loading...</span></div>";
                }
                document.getElementById("college" + showCollegeId).innerHTML = spinStr;
            } else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("college" + showCollegeId).innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", urlPath, true);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlhttp.send(null);
    }

    function changePasswordPageSize(collegeId, urlPath, clickObj) {
        var index = clickObj.selectedIndex;
        if (index != 0) {
            showAtCollege(collegeId, (urlPath + clickObj.options[index].value));
        }
    }

    function auditPassOrNot(clickObj) {
        var operation = clickObj.id.substr(0, 2);
        var tempId = clickObj.id.substr(2);

        var xmlhttp;
        if (window.XMLHttpRequest) {
            //通用浏览器,如Firefox Chrome  Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            //IE浏览器
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //拼接路径
        var urlPath = 'experiment/';
        if (operation == 'go' && confirm("确定该实验审核通过？")) {
            urlPath = urlPath + 'auditPass.do?auditAdminAccount=${role.account}&';
        } else if (operation == 'no' && confirm("确定该实验审核不通过？")) {
            urlPath = urlPath + 'auditNotPass.do?auditAdminAccount=${role.account}&';
        }
        urlPath = urlPath + 'tempId=' + tempId;

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && (xmlhttp.status >= 200 && xmlhttp.status < 300)) {
                //接收到服务器端返回的JSON对象
                var obj = JSON.parse(xmlhttp.responseText);
                if (obj.success) {
                    alert(obj.message);
                    document.getElementById('no' + tempId).disabled = true;
                    document.getElementById('go' + tempId).disabled = true;
                    //提示减一
                    var auditNumbersObj = document.getElementById("auditNumbers");
                    auditNumbersObj.innerHTML = parseInt(auditNumbersObj.innerHTML) - 1;
                } else {
                    //告知异常
                    alert(obj.message);
                }
            } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 400 || xmlhttp.status < 500)) {
                alert("未知的请求");
            } else if (xmlhttp.readyState == 4 && xmlhttp.status >= 500) {
                alert("发生了一个未知的错误");
            }
        }
        xmlhttp.open("POST", urlPath, true);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlhttp.send();
    }

    //主函数，采用AJAX实现异步请求，实现局部页面刷新
    function showAtRight(urlPath) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            //通用浏览器,如Firefox Chrome  Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            //IE浏览器
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState != 4) {
                var spinStr = "";
                for (var i = 1; i <= 6; i++) {
                    spinStr += "<div class='spinner-grow' role='status'><span class='visually-hidden'>Loading...</span></div>";
                }
                document.getElementById("content").innerHTML = spinStr;
            } else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("content").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", urlPath, true);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlhttp.send(null);
    }

    //显示管理员个人信息界面
    function showAdminInfo(urlPath, clickObj) {
        showAtRight(urlPath);
        clickObj.disabled = true;
        //10秒内不可再次查询
        setTimeout(function () {
            clickObj.disabled = false;
        }, 10000);
    }

    function checkPhone() {
        var check = true;
        var reg = /^1[0-9]{10}$/;
        var phoneNumber = document.getElementById("phoneNumber");
        if (!reg.test(phoneNumber.value)) {
            check = false;
            //检查不通过，提示非法
            phoneNumber.className = "form-control is-invalid";
            return check;
        }
        //检查通过，is-invalid取消
        phoneNumber.className = "form-control";
        return check;
    }

    function checkEmail() {
        var check = true;
        var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        var email = document.getElementById("email");
        if (!reg.test(email.value)) {
            check = false;
            //检查不通过，提示非法
            email.className = "form-control is-invalid";
            return check;
        }
        //检查通过，is-invalid取消
        email.className = "form-control";
        return check;
    }

    function checkQQ() {
        var check = true;
        var reg = /[0-9]{8,}$/;
        var qq = document.getElementById("qq");
        if (!reg.test(qq.value)) {
            check = false;
            //检查不通过，提示非法
            qq.className = "form-control is-invalid";
            return check;
        }
        //检查通过，is-invalid取消
        qq.className = "form-control";
        return check;
    }

    function checkPhoneEmailQQ() {
        if (checkPhone() && checkEmail() && checkQQ()) {
            return true;
        } else {
            return false;
        }
    }

    //监听控件内容是否变化，无变化不提交
    function changeAndSetNotDisabled() {
        document.getElementById("updateInfoBtn").disabled = false;
    }

    //修改个人信息
    function updateInfo(clickObj) {
        var urlPath = clickObj.action + formSerialize(clickObj);
        if (!checkPhoneEmailQQ()) {
            alert("请检查输入信息");
            return;
        }
        if (confirm("确认修改个人信息吗？")) {
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
                        //成功则更新数据
                        alert("修改个人信息成功")
                        document.getElementById("phoneNumber").innerHTML = obj.phoneNumber;
                        document.getElementById("email").innerHTML = obj.email;
                        document.getElementById("qq").innerHTML = obj.qq;
                        //防止频繁点击
                        var updateInfoBtn = document.getElementById("updateInfoBtn");
                        updateInfoBtn.disabled = true;
                        setTimeout(function () {
                            updateInfoBtn.disabled = false;
                        }, 5000);
                    } else {
                        //告知异常
                        alert(obj.message);
                    }
                } else if (xmlhttp.readyState == 4 && xmlhttp.status == 404) {
                    alert("发生了一个未知的错误")
                }
            }
            xmlhttp.open("POST", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send();
        }
    }

    function formSerialize(clickObj) {
        var res = [], //存放结果的数组
            current = null, //循环内的表单控件
            i,  //表单的索引
            len; //表单的长度

        for (i = 0, len = clickObj.elements.length; i < len; i++) {
            current = clickObj.elements[i];
            if (current.disabled) {
                continue;
            }
            switch (current.type) {
                case "file":
                case "submit":
                case "button":
                case "image":
                case "reset":
                case undefined: break;
                case "select-one":
                case "select-multiple":
                case "radio":
                case "checkbox":
                default:
                    if (current.name && current.name.length) {
                        res.push(encodeURIComponent(current.name) + "=" + encodeURIComponent(current.value));

                    }
            }
            res.join("&");
        }
        return res.join("&");
    }

    //检查原始密码
    function checkOldPassword() {
        var oldPasswordObj = document.getElementById("oldPassword");
        var oldPasswordTipObj = document.getElementById("oldPasswordTip");
        if (oldPasswordObj.value == '') {
            oldPasswordObj.className = "form-control is-invalid";
            oldPasswordTipObj.innerHTML = "该项为必填项！";
            return false;
        }
        if (oldPasswordObj.value.length < 7) {
            oldPasswordObj.className = "form-control is-invalid";
            oldPasswordTipObj.innerHTML = "密码长度大于7位，请检查！";
            return false;
        }
        oldPasswordObj.className = "form-control";
        oldPasswordTipObj.innerHTML = "";
        return true;
    }
    //检查新密码
    function checkNewPassword() {
        var oldPasswordObj = document.getElementById("oldPassword");
        var newPasswordObj = document.getElementById("newPassword");
        var newPasswordTipObj = document.getElementById("newPasswordTip");
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{7,16}$/;
        if (newPasswordObj.value == '') {
            newPasswordObj.className = "form-control is-invalid";
            newPasswordTipObj.innerHTML = "该项为必填项！";
            return false;
        }
        if (newPasswordObj.value.length < 7) {
            newPasswordObj.className = "form-control is-invalid";
            newPasswordTipObj.innerHTML = "密码长度应大于7位，请检查！";
            return false;
        }
        if (oldPasswordObj.value == newPasswordObj.value) {
            newPasswordObj.className = "form-control is-invalid";
            newPasswordTipObj.innerHTML = "新密码不能与原始密码相同";
            return false;
        }
        if (!reg.test(newPasswordObj.value)) {
            newPasswordObj.className = "form-control is-invalid";
            newPasswordTipObj.innerHTML = "密码必须为数字与字母的组合，不能含有特殊字符，并且不能为纯数字或纯字母";
            return false;
        }
        newPasswordObj.className = "form-control";
        newPasswordTipObj.innerHTML = "";
        return true;
    }
    //检查确认密码
    function checkCheckPassword() {
        var newPasswordObj = document.getElementById("newPassword");
        var checkPasswordObj = document.getElementById("checkPassword");
        var checkPasswordTipObj = document.getElementById("checkPasswordTip");
        if (checkPasswordObj.value == '') {
            checkPasswordObj.className = "form-control is-invalid";
            checkPasswordTipObj.innerHTML = "该项为必填项！";
            return false;
        }
        if (checkPasswordObj.value != newPasswordObj.value) {
            checkPasswordObj.className = "form-control is-invalid";
            checkPasswordTipObj.innerHTML = "两次密码输入不同";
            return false;
        }
        checkPasswordObj.className = "form-control";
        checkPasswordTipObj.innerHTML = "";
        return true;
    }

    function updatePassword(clickObj) {
        if (checkOldPassword() && checkNewPassword() && checkCheckPassword()) {
            if (confirm('确认要修改密码吗？')) {
                var urlPath = clickObj.action + 'oldPassword=' + document.getElementById('oldPassword').value
                    + '&newPassword=' + document.getElementById('newPassword').value;
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
                            //成功则更新数据
                            alert(obj.message);
                            //清空已填项
                            document.getElementById("oldPassword").value = '';
                            document.getElementById("newPassword").value= '';
                            document.getElementById("checkPassword").value = '';
                            //防止频繁点击
                            var updatePasswordBtn = document.getElementById("updatePasswordBtn");
                            updatePasswordBtn.disabled = true;
                            alert("请重新登录");
                            setTimeout(window.location.href='userLogin/index.do', 4000);
                            // updatePasswordBtn.attachEvent('onclick', window.location.href='userLogin/index.do');
                        } else {
                            //告知异常
                            alert(obj.message);
                        }
                    } else if (xmlhttp.readyState == 4 && xmlhttp.status == 404) {
                        alert("发生了一个未知的错误")
                    }
                }
                xmlhttp.open("POST", urlPath, true);
                xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xmlhttp.send();
            }
        }
    }

    function setPasswordUpdateBtnNotDisable() {
        document.getElementById("updatePasswordBtn").disabled = false;

    }

    //待审核实验页数据量更改
    function changeAuditPageSize(urlPath, clickObj) {
        var index = clickObj.selectedIndex;
        if (index != 0) {
            showAtRight(urlPath + clickObj.options[index].value);
        }
    }

    //页数据量更改，使得每页显示的数据量不同
    function changePageSize(currentObject) {
        var pageSizeBox = currentObject;
        var index = pageSizeBox.selectedIndex;
        if (index != 0) {
            showAtRight("experiment/allExperiments.do?pageNum=1&pageSize=" + pageSizeBox.options[index].value);
        }
    }

    //用画布显示实验的详细信息
    function getOffCanvasData(urlPath) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            //通用浏览器,如Firefox Chrome  Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            //IE浏览器
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            var targetObj = document.getElementById("experimentDetails");
            if (xmlhttp.readyState != 4) {
                var spinStr = "";
                for (var i = 1; i <= 6; i++) {
                    spinStr += "<div class='spinner-grow' role='status'><span class='visually-hidden'>Loading...</span></div>";
                }
                targetObj.innerHTML = spinStr;

            } else if (xmlhttp.readyState == 4 && xmlhttp.status == 404) {
                targetObj.innerHTML = "没有找到数据";
            } else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                targetObj.innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST", urlPath, true);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlhttp.send();
    }
</script>

</body>
</html>