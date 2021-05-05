<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/3
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div class="container">
        <div class="row" style="height: 25px;"></div>
        <div class="row justify-content-center">
            <div class="col-4">
                <p class="h3">个人实验课程</p>
            </div>
        </div>
        <div class="row gy-5">
            <!--数据显示区域-->
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">实验名称</th>
                    <th scope="col">实验教师</th>
                    <th scope="col">实验时间</th>
                    <th scope="col">实验地点</th>
                    <th scope="col">可选人数</th>
                    <th scope="col">已选人数</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teacherExperiments}" var="experiment">
                    <tr>
                        <th scope="row">${experiment.experimentName}</th>
                        <td>${experiment.teacherName}</td>
                        <td>${experiment.experimentTime}</td>
                        <td>${experiment.experimentPlace}</td>
                        <td>${experiment.capacity}</td>
                        <td>${experiment.selectedNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
