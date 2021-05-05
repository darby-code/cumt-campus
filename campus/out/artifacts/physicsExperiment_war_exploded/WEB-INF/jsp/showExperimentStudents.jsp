<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/3
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 50px;"></div>
    <div class="accordion" id="experimentStudentsMenu">
        <c:forEach items="${teacherExperiments}" var="experiment">
            <div class="accordion-item">
                <h2 class="accordion-header" id="menu${experiment.experimentId}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#id${experiment.experimentId}" aria-expanded="false" aria-controls="id${experiment.experimentId}">${experiment.experimentId}   ${experiment.experimentName}</button>
                </h2>
                <div id="id${experiment.experimentId}" class="accordion-collapse collapse" aria-labelledby="menu${experiment.experimentId}" data-bs-parent="#experimentStudentsMenu">
                    <div class="accordion-body">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th scope="col">学号</th>
                                <th scope="col">学生姓名</th>
                                <th scope="col">性别</th>
                                <th scope="col">学院</th>
                                <th scope="col">班级</th>
                                <th scope="col">手机号</th>
                                <th scope="col">QQ</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${experimentStudentMap.get(experiment.experimentId)}" var="student">
                                    <tr>
                                        <th scope="row">${student.studentId}</th>
                                        <td>${student.studentName}</td>
                                        <td>${student.sex}</td>
                                        <td>${student.college.collegeName}</td>
                                        <td>${student.classInfo}</td>
                                        <td>${student.phoneNumber}</td>
                                        <td>${student.qq}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
