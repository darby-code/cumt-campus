<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/4/28
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasLabel">${clickExperiment.experimentName}</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <table class="table table-hover">
            <thead>
                <th scope="col">名称</th>
                <th scope="col">详细信息</th>
            </thead>
            <tr class="table-primary">
                <th scope="row">实验代号</th>
                <td>${clickExperiment.experimentId}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">实验名称</th>
                <td>${clickExperiment.experimentName}</td>
            </tr>
            <tr class="table-primary">
                <th scope="row">实验时间</th>
                <td>${clickExperiment.experimentTime}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">星期</th>
                <td>${clickExperiment.weekDay}</td>
            </tr>
            <tr class="table-primary">
                <th scope="row">实验地点</th>
                <td>${clickExperiment.experimentPlace}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">实验教师工号</th>
                <td>${clickExperiment.teacherId}</td>
            </tr>
            <tr class="table-primary">
                <th scope="row">实验教师姓名</th>
                <td>${clickExperiment.teacherName}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">实验教师联系电话</th>
                <td>${clickExperiment.phoneNumber}</td>
            </tr>
            <tr class="table-primary">
                <th scope="row">实验可选人数</th>
                <td>${clickExperiment.capacity}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">实验已选人数</th>
                <td>${clickExperiment.selectedNumber}</td>
            </tr>
            <tr class="table-primary">
                <th scope="row">实验是否可选</th>
                <td>${clickExperiment.allowSelected == true ? '是' : '否'}</td>
            </tr>
            <tr class="table-secondary">
                <th scope="row">实验是否已出成绩</th>
                <td>${clickExperiment.finished == true ? '是' : '否'}</td>
            </tr>
        </table>
    </div>
</body>
</html>
