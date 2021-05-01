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
                                <button type="button" id="teacherQueryExperiment" class="btn btn-outline-secondary btn-lg">实验查看</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherReleaseExperiemnt" class="btn btn-outline-secondary btn-lg">发布新实验课</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherRecordScore" class="btn btn-outline-secondary btn-lg">成绩录入</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherQueryScore" class="btn btn-outline-secondary btn-lg">实验学生成绩查询</button>
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
                                <button type="button" id="teacherSelfInfo" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherUpdatePassword" class="btn btn-outline-secondary btn-lg">密码修改</button>
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
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First</th>
                            <th scope="col">Last</th>
                            <th scope="col">Handle</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td colspan="2">Larry the Bird</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="base/footer.jsp"%>

</body>
</html>