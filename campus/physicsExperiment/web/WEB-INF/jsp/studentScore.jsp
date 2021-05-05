<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/1
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div class="row" style="height: 25px;"></div>
    <div class="row justify-content-center">
        <div class="col-4">
            <p class="h3">实验成绩</p>
        </div>
    </div>
    <div class="row gy-5">
        <!--数据显示区域-->
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">实验编号</th>
                <th scope="col">实验老师</th>
                <th scope="col">实验名称</th>
                <th scope="col">学生学号</th>
                <th scope="col">学生姓名</th>
                <th scope="col">成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${scoreList}" var="selectedExperiment">
                <tr>
                    <th id="" scope="row">${selectedExperiment.experiment.experimentId}</th>
                    <td>${selectedExperiment.experiment.teacherName}</td>
                    <td>${selectedExperiment.experiment.experimentName}</td>
                    <td>${selectedExperiment.student.studentId}</td>
                    <td>${selectedExperiment.student.studentName}</td>
                    <td>${selectedExperiment.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
