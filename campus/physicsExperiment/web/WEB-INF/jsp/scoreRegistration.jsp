<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/3
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 50px;"></div>
    <div class="accordion" id="experimentStudentsMenu">
        <c:forEach items="${teacherExperiments}" var="experiment">
            <c:if test="${experiment.finished}">
                <!--如果实验已经录完成绩，则只是显示成绩-->
                <div class="accordion-item">
                    <h2 class="accordion-header" id="menu${experiment.experimentId}">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#id${experiment.experimentId}" aria-expanded="false" aria-controls="id${experiment.experimentId}">${experiment.experimentId}   ${experiment.experimentName}（已出成绩）</button>
                    </h2>
                    <div id="id${experiment.experimentId}" class="accordion-collapse collapse" aria-labelledby="menu${experiment.experimentId}" data-bs-parent="#experimentStudentsMenu">
                        <div class="accordion-body">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">学号</th>
                                    <th scope="col">学生姓名</th>
                                    <th scope="col">学院</th>
                                    <th scope="col">班级</th>
                                    <th scope="col">成绩</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${experimentRecords.get(experiment.experimentId)}" var="record">
                                    <tr>
                                        <th scope="row">${record.student.studentId}</th>
                                        <td>${record.student.studentName}</td>
                                        <td>${record.student.college.collegeName}</td>
                                        <td>${record.student.classInfo}</td>
                                        <td>${record.score}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${!experiment.finished}">
               <!--如果没有录完成绩，则显示相关操作界面-->
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
                                    <th scope="col">学院</th>
                                    <th scope="col">班级</th>
                                    <th scope="col">成绩</th>
                                    <th scope="col">录入</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${experimentRecords.get(experiment.experimentId)}" var="record">
                                    <tr>
                                        <th scope="row">${record.student.studentId}</th>
                                        <td>${record.student.studentName}</td>
                                        <td>${record.student.college.collegeName}</td>
                                        <td>${record.student.classInfo}</td>
                                        <c:if test="${record.allowModified}">
                                            <td>
                                                <div class="col-auto">
                                                    <input type="text" class="form-control" id="score${record.student.studentId}" onblur="checkScore(this);" placeholder="成绩">
                                                </div>
                                            </td>
                                            <td>
                                                <div class="col-auto">
                                                    <button type="button" id="${record.student.studentId}" onclick="submitStudentScore('experiment/submitStudentScore.do?experimentId=${experiment.experimentId}&', this)" class="btn btn-outline-secondary">录入</button>
                                                </div>
                                            </td>
                                        </c:if>
                                        <c:if test="${!record.allowModified}">
                                            <td>${record.score}</td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</body>
</html>
