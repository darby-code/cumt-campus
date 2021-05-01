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
                                    <button type="button" id="studentQueryScore" class="btn btn-outline-secondary btn-lg">实验成绩查询</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentSelfInfo" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                                </div>
                                <div class="row">
                                    <button type="button" id="studentUpdatePassword" class="btn btn-outline-secondary btn-lg">密码修改</button>
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
                            clickObj.className = "btn btn-outline-danger";
                            clickObj.innerHTML = "退选";
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