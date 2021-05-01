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
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">实验</button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="adminExperimentMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="adminQueryExperiment" class="btn btn-outline-secondary btn-lg">实验查询</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminDeleteExperiment" class="btn btn-outline-secondary btn-lg">实验删除</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminUpdateExperiment" class="btn btn-outline-secondary btn-lg">实验信息修改</button>
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
                                <button type="button" id="adminQueryStudent" class="btn btn-outline-secondary btn-lg">学生信息</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminQueryTeacher" class="btn btn-outline-secondary btn-lg">教师信息</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="adminUpdateMenu">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">修改</button>
                    </h2>
                    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="adminUpdateMenu" data-bs-parent="#totalMenu">
                        <div class="accordion-body">
                            <div class="row">
                                <button type="button" id="adminUpdateStudentScore" class="btn btn-outline-secondary btn-lg">学生成绩修改</button>
                            </div>

                            <div class="row">
                                <button type="button" id="studentPasswordReset" class="btn btn-outline-secondary btn-lg">学生密码重置</button>
                            </div>
                            <div class="row">
                                <button type="button" id="teacherPasswordReset" class="btn btn-outline-secondary btn-lg">教师密码重置</button>
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
                                <button type="button" id="newAnnouncement" class="btn btn-outline-secondary btn-lg">新公告发布</button>
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
                                <button type="button" id="adminSelfInfoQuery" class="btn btn-outline-secondary btn-lg">个人信息查询</button>
                            </div>
                            <div class="row">
                                <button type="button" id="adminPasswordUpdate"  class="btn btn-outline-secondary btn-lg">密码修改</button>
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