<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>学生页面</title>
</head>
<body>
    <div class="container-fluid">
       <%@ include file="base/header.jsp"%>
        <div class="row">
            <div class="col-6 w-25 p-3">
                <div class="accordion" id="totalMenu">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="experimentMenu">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">实验</button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="experimentMenu" data-bs-parent="#totalMenu">
                            <div class="accordion-body">
                                <div class="row">
                                    <button type="button" id="studentChooseOrDrop" onclick="showAllowSelectedExperiments('experiment/showSelectExperiment.do?studentId=${role.studentId}')" class="btn btn-outline-secondary btn-lg">实验选课/退课</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentQueryExperiment" onclick="clearSearchContent('experiment/allExperiments.do?pageNum=1&pageSize=3');" class="btn btn-outline-secondary btn-lg">所有实验</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentSearchExperiment" onclick="showSearchContent('experiment/showSearchBox.do')" class="btn  btn-outline-secondary btn-lg">实验搜索</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentSelectedExperiment" onclick="showSelectedList('experiment/selectedList.do?studentId=${role.studentId}')" class="btn  btn-outline-secondary btn-lg">已选实验</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="studentInfoMenu">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">个人信息</button>
                        </h2>
                        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="studentInfoMenu" data-bs-parent="#totalMenu">
                            <div class="accordion-body">
                                <div class="row">
                                    <button type="button" id="studentQueryScore" onclick="showStudentScores('experiment/studentScore.do?studentId=${role.studentId}')" class="btn btn-outline-secondary btn-lg">实验成绩查询</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentSelfInfo" onclick="showStudentInfo('user/studentInfo.do?studentId=${role.studentId}', this)" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentUpdatePassword" onclick="showUpdatePasswordBox('user/showUpdatePasswordBox.do?role=student&roleInfo=${role.studentId}');" class="btn btn-outline-secondary btn-lg">密码修改</button>
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
                    <div class="container" id="searchContent">

                    </div>
                    <div class="container" id="content">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--用于在显示区显示-->
    <script type="text/javascript">
        //显示密码修改界面
        function showUpdatePasswordBox(urlPath) {
            document.getElementById("searchContent").innerHTML = "";
            showAtRight(urlPath);
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

        //显示学生个人信息界面
        function showStudentInfo(urlPath, clickObj) {
            document.getElementById("searchContent").innerHTML = "";
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

        //显示学生成绩界面
        function showStudentScores(urlPath) {
            document.getElementById("searchContent").innerHTML = "";
            showAtRight(urlPath);
        }
        //显示选课/退选实验界面，只显示可选实验
        function showAllowSelectedExperiments(urlPath) {
            document.getElementById("searchContent").innerHTML = "";
            showAtRight(urlPath);
        }
        //选实验
        function checkExperimentCouldBeSelected(studentId, clickObj) {
            var urlPath = 'experiment/selectExperiment.do?studentId=' + studentId + '&experimentId=' + clickObj.id;
            if (confirm("确认选择该实验吗？")) {
                var xmlhttp;
                if (window.XMLHttpRequest) {
                    //通用浏览器,如Firefox Chrome  Safari
                    xmlhttp = new XMLHttpRequest();
                } else {
                    //IE浏览器
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        //接收到服务器端返回的JSON对象
                        var obj = JSON.parse(xmlhttp.responseText);
                        if (obj.state == 1) {
                            alert(obj.message);
                            clickObj.className = "btn btn-outline-danger";
                            clickObj.innerHTML = "退选";
                            var tab = document.getElementById("allowSelectedExperiments");
                            for (var i = 1; i < tab.rows.length; i++) {
                                if (tab.rows[i].cells[0].innerHTML == clickObj.id) {
                                    //已选数加一
                                    tab.rows[i].cells[6].innerHTML = 1 + parseInt(tab.rows[i].cells[6].innerHTML);
                                    break;
                                }
                            }
                            clickObj.onclick = function () {
                                dropExperiment(studentId, clickObj);
                            }

                            //attachEvent会立即触发，而上面的不会
                            // clickObj.attachEvent('onclick', dropExperiment(studentId, clickObj));
                        } else if ((obj.state == 0) || (obj.state == -4) || (obj.state == -3)) {
                            //实验可选人数达到上限，实验关闭选课，所选实验不存在，说明页面可能停留时间过久
                            //进行刷新
                            alert(obj.message);
                            showAllowSelectedExperiments('experiment/showSelectExperiment.do?studentId=' + studentId);
                        } else {
                            //其他的异常，抛出消息，让用户选择
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
        //显示搜索实验界面
        function showSearchContent(urlPath) {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                //通用浏览器,如Firefox Chrome  Safari
                xmlhttp = new XMLHttpRequest();
            } else {
                //IE浏览器
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("searchContent").innerHTML = xmlhttp.responseText;
                    document.getElementById("content").innerHTML = "";
                }
            }
            xmlhttp.open("GET", urlPath, true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlhttp.send(null);
        }
        //显示学生已选实验
        function showSelectedList(urlPath) {
            document.getElementById("searchContent").innerHTML = "";
            showAtRight(urlPath);
        }
        //根据关键词搜索实验
        function addSearchKeyWords(urlPath) {
            urlPath = urlPath + "words=" + document.getElementById("keyWords").value;
            showAtRight(urlPath);
        }
        //清空搜索区域内容
        function clearSearchContent(urlPath) {
            document.getElementById("searchContent").innerHTML = "";
            showAtRight(urlPath);
        }
        //退选实验
        function dropExperiment(studentId, clickObj) {
            urlPath = 'experiment/dropExperiment.do?studentId=' + studentId + '&experimentId=' + clickObj.id;
            if (confirm("确定退选该实验吗?")) {
                var xmlhttp;
                if (window.XMLHttpRequest) {
                    //通用浏览器,如Firefox Chrome  Safari
                    xmlhttp = new XMLHttpRequest();
                } else {
                    //IE浏览器
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        //接收到服务器端返回的JSON对象
                        var obj = JSON.parse(xmlhttp.responseText);
                        if (obj.state == 2) {
                            //退选成功
                            alert(obj.message);
                            var tab = document.getElementById("allowSelectedExperiments");
                            for (var i = 1; i < tab.rows.length; i++) {
                                if (tab.rows[i].cells[0].innerHTML == clickObj.id) {
                                    //已选数加一
                                    tab.rows[i].cells[6].innerHTML = parseInt(tab.rows[i].cells[6].innerHTML) - 1;
                                    break;
                                }
                            }
                            clickObj.className = "btn btn-outline-dark";
                            clickObj.innerHTML = "选择";
                            clickObj.onclick = function () {
                                checkExperimentCouldBeSelected(studentId, clickObj);
                            }
                            //attachEvent会立即触发，而上面的不会
                            // clickObj.attachEvent('onclick', checkExperimentCouldBeSelected(studentId, clickObj));
                        } else {
                            //其他的异常，抛出消息，让用户选择
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
    </script>
    <div class="container">
        <%@include file="base/footer.jsp"%>
    </div>
</body>
</html>