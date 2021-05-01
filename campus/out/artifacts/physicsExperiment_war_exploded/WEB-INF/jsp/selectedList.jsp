<%@ page import="java.util.HashMap" %>
<%@ page import="edu.cumt.phyExperiment.entity.Experiment" %>
<%@ page import="edu.cumt.phyExperiment.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/4/28
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <% Student student = (Student) session.getAttribute("role"); %>
    <div class="row" style="height: 25px;"></div>
    <div class="row justify-content-center">
        <div class="col-4">
            <p class="h3">已选实验</p>
        </div>
    </div>
    <div class="row gy-5">
        <!--数据显示区域-->
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">实验编号</th>
                <th scope="col">实验名称</th>
                <th scope="col">实验时间</th>
                <th scope="col">实验地点</th>
                <th scope="col">实验老师</th>
                <th scope="col">已选/可选</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${selectedList}" var="experiment">
                <tr>
                    <th id="" scope="row">${experiment.experimentId}</th>
                    <td>${experiment.experimentName}</td>
                    <td>${experiment.experimentTime}</td>
                    <td>${experiment.experimentPlace}</td>
                    <td>${experiment.teacherName}</td>
                    <td>${experiment.selectedNumber}/${experiment.capacity}</td>
                    <td>
                        <c:if test="${experiment.allowSelected == true}">
                            <button class="btn btn-outline-danger" id="${experiment.experimentId}" onclick="dropExperiment(<%=student.getStudentId()%>, this)">退选</button>
                        </c:if>
                        <c:if test="${experiment.allowSelected == false}">
                            <button class="btn btn-outline-danger" id="${experiment.experimentId}" disabled>退选</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
