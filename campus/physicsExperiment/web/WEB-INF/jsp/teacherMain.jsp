
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>老师页面</title>
</head>
<body>
    <div class="container-fluid">
        <%@ include file="base/header.jsp"%>
            <div class="row h-75">
                <div class="col-6 w-25 p-3">
                    <div class="accordion" id="totalMenu">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="teacherExperimentMenu">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">实验</button>
                            </h2>
                            <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="teacherExperimentMenu" data-bs-parent="#totalMenu">
                                <div class="accordion-body">
                                    <div class="row">
                                        <button type="button" id="teacherQueryExperiment" onclick="showAtRight('experiment/allExperiments.do?pageNum=1&pageSize=3');" class="btn btn-outline-secondary btn-lg">所有实验</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="teacherReleaseExperiment" onclick="showAtRight('experiment/showNewExperimentBox.do')" class="btn btn-outline-secondary btn-lg">发布新实验</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="pendingReviewExperiments" onclick="showAtRight('experiment/showSubmitExperiments.do?submitTeacherId=${role.teacherId}')" class="btn btn-outline-secondary btn-lg">待审核实验</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="selfExperiments" onclick="showAtRight('experiment/showTeacherExperiments.do?teacherId=${role.teacherId}')" class="btn btn-outline-secondary btn-lg">个人实验课程</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="teacherRecordScore" onclick="showAtRight('experiment/showStudentScore.do?teacherId=${role.teacherId}')" class="btn btn-outline-secondary btn-lg">实验成绩录入</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="teacherQueryScore" onclick="showAtRight('experiment/showExperimentStudents.do?teacherId=${role.teacherId}')" class="btn btn-outline-secondary btn-lg">实验学生</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="teacherSelfMenu">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSelf" aria-expanded="false" aria-controls="collapseSelf">个人信息</button>
                            </h2>
                            <div id="collapseSelf" class="accordion-collapse collapse" aria-labelledby="teacherSelfMenu" data-bs-parent="#totalMenu">
                                <div class="accordion-body">
                                    <div class="row">
                                        <button type="button" id="teacherSelfInfo" onclick="showTeacherInfo('user/teacherInfo.do?teacherId=${role.teacherId}', this)" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                                    </div>
                                    <div class="row">
                                        <button type="button" id="teacherUpdatePassword" onclick="showAtRight('user/showUpdatePasswordBox.do?role=teacher&roleInfo=${role.teacherId}');" class="btn btn-outline-secondary btn-lg">密码修改</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
        $("#experimentTime").datetimepicker({
            forceParse: 0,  //设置为0，时间不会跳转1899，只会显示当前时间
            language: 'zh-CN', //显示中文
            format: 'YYYY-MM-DD HH:mm'
        });

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
                } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 200 && xmlhttp.status < 300)) {
                    document.getElementById("content").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send(null);
        }
        //页数据量更改，使得每页显示的数据量不同
        function changePageSize(currentObject) {
            var pageSizeBox = currentObject;
            var index = pageSizeBox.selectedIndex;
            if (index != 0) {
                showAtRight("experiment/allExperiments.do?pageNum=1&pageSize=" + pageSizeBox.options[index].value);
            }
        }
        //用于选实验时更改页数据量
        function selectChangePageSize(currentObj, studentId) {
            var pageSizeBox = currentObj;
            var index = pageSizeBox.selectedIndex;
            if (index != 0) {
                showAtRight("experiment/showSelectExperiment.do?studentId=" + studentId + "&pageNum=1&pageSize=" + pageSizeBox.options[index].value);
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
        
        //确认提交的必填项是否为空，为空提示
        function checkExperimentTime() {
            var expTimeObj = document.getElementById("experimentTime");
            if ((expTimeObj.value == null) || (expTimeObj.value == '')) {
                expTimeObj.className = "form-control is-invalid";
                return false;
            }
            expTimeObj.className = "form-control";
            return true;
        }
        
        function checkExperimentPlace() {
            var expPlaceObj = document.getElementById("experimentPlace");
            if (expPlaceObj[expPlaceObj.selectedIndex].value == 0) {
                expPlaceObj.className = "form-select is-invalid";
                return false;
            }
            expPlaceObj.className = "form-select";
            return true;
        }
        
        function checkExperimentName() {
            var expNameObj = document.getElementById("experimentName");
            if (expNameObj[expNameObj.selectedIndex].value == 0) {
                expNameObj.className = "form-select is-invalid";
                return false;
            }
            expNameObj.className = "form-select";
            return true;
        }
        
        function checkTeacherId() {
            var teacherObj = document.getElementById("teacherId");
            if (teacherObj[teacherObj.selectedIndex].value == 0) {
                teacherObj.className = "form-select is-invalid";
                return false;
            }
            teacherObj.className = "form-select";
            return true;
        }
        
        function checkCapacity() {
            var capacityObj = document.getElementById("capacity");
            var reg = /^[1-9]\d{0,}/;
            if (!reg.test(capacityObj.value)) {
                capacityObj.className = "form-control is-invalid";
                return false;
            }
            capacityObj.className = "form-control";
            return true;
        }

        function submitNewExperiment(clickObj) {
            if (checkExperimentTime() && checkExperimentPlace() && checkExperimentName()
                    && checkTeacherId() && checkCapacity()) {
                //都有输入后，再提交
                var expTimeObj = document.getElementById("experimentTime");
                var expPlaceObj = document.getElementById("experimentPlace");
                var expNameObj = document.getElementById("experimentName");
                var teacherObj = document.getElementById("teacherId");
                var capacityObj = document.getElementById("capacity");
                var urlPath = clickObj.action + "submitTeacherId=" + ${role.teacherId} + "&experimentTime=" + expTimeObj.value
                    + "&experimentPlace=" + expPlaceObj[expPlaceObj.selectedIndex].value + "&experimentName="
                    + expNameObj[expNameObj.selectedIndex].value + "&teacherId=" + teacherObj[teacherObj.selectedIndex].value
                    + "&capacity=" + capacityObj.value;

                if (confirm("是否确定提交？提交后实验信息无法修改！")) {
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
                                alert("实验提交成功")
                                document.getElementById('teacherReleaseExperiment').attachEvent('onclick', showAtRight('experiment/showNewExperimentBox.do'));
                            } else {
                                //告知异常
                                alert(obj.message);
                            }
                        } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 400 && xmlhttp.status < 500)) {
                            alert("请检查请求内容")
                        } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 500)) {
                            alert("发生了一个未知的错误");
                        }
                    }
                    xmlhttp.open("POST", urlPath, true);
                    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded,charset=UTF-8");
                    xmlhttp.send();
                }
            }

        }

        function checkScore(checkObj) {
            var reg = /^(?:[1-9]?\d|100)$/;
            if (!reg.test(checkObj.value)) {
                checkObj.className = "form-control is-invalid";
                return false;
            }
            checkObj.className = "form-control";
            return true;
        }

        function submitStudentScore(urlPath, clickObj) {
            var scoreText = document.getElementById("score" + clickObj.id);
            if (checkScore(scoreText)) {
                urlPath = urlPath + "studentId=" + clickObj.id + "&score=" + scoreText.value;
                if (confirm("确认提交该学生成绩吗？提交后无法修改！请确认！")) {
                    //更新学生成绩
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
                                //成功更新成绩，还要根据后端返回的信息判断
                                if (obj.state == 4) {
                                    //学生成绩更新完毕，但是实验还有学生成绩没有录入
                                    //则将录入录入文本、录入按钮置为disabled
                                    clickObj.disabled = true;
                                    scoreText.disabled = true;
                                } else if (obj.state == 5) {
                                    //学生成绩更新完毕，实验的所有学生成绩录入完成
                                    //则刷新页面
                                    document.getElementById('teacherRecordScore').attachEvent('onclick', showAtRight('experiment/showStudentScore.do?teacherId=${role.teacherId}'));
                                }
                            } else {
                                //告知异常
                                alert(obj.message);
                            }
                        } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 400 && xmlhttp.status < 500)) {
                            alert("请检查请求内容")
                        } else if (xmlhttp.readyState == 4 && (xmlhttp.status >= 500)) {
                            alert("发生了一个未知的错误");
                        }
                    }
                    xmlhttp.open("POST", urlPath, true);
                    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded,charset=UTF-8");
                    xmlhttp.send();
                }
            }

        }

        function showTeacherInfo(urlPath, clickObj) {
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
            alert(urlPath);
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
        }
        //更新密码
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
            if(oldPasswordObj.value != ${role.password}) {
                oldPasswordObj.className = "form-control is-invalid";
                oldPasswordTipObj.innerHTML = "输入与登录密码不符！";
                return false;
            }
            oldPasswordObj.className = "form-control";
            oldPasswordTipObj.innerHTML = "";
            return true;
        }

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

        function setPasswordUpdateBtnNotDisable() {
            document.getElementById("updatePasswordBtn").disabled = false;
        }

    </script>

</body>
</html>
