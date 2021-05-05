
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 40px;"></div>
    <form method="post" class="row g-3" action="experiment/submitNewExperiment.do?" onsubmit="submitNewExperiment(this); return false;">
        <div class="col-md-6">
            <label for="experimentTime"  class="form-label">实验时间</label>
            <input type="datetime-local" onblur="checkExperimentTime();" class="form-control" placeholder="实验时间" name="experimentTime" id="experimentTime">
        </div>
        <div class="col-md-6">
            <label for="experimentPlace" class="form-label">实验地点</label>
            <select class="form-select" id="experimentPlace" onblur="checkExperimentPlace();" aria-label="Default select example">
                <option selected value="0">选择实验教室</option>
                <c:forEach items="${experimentPlaces}" var="place">
                    <option value="${place}">${place}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-12">
            <label for="experimentName" class="form-label">实验名称</label>
            <select class="form-select" id="experimentName" onblur="checkExperimentName();" aria-label="Default select example">
                <option selected value="0">选择实验名称</option>
                <c:forEach items="${experimentNames}" var="name">
                    <option value="${name}">${name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-10">
            <label for="teacherId" class="form-label">教师工号/教师姓名</label>
            <select class="form-select" id="teacherId" onblur="checkTeacherId()" aria-label="Default select example">
                <option selected value="0">选择实验教师</option>
                <c:forEach items="${teachers}" var="teacher">
                    <option value="${teacher.teacherId}">${teacher.teacherId}   ${teacher.teacherName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-4">
            <label for="capacity" class="form-label">实验可选人数</label>
            <input type="text" class="form-control" onblur="checkCapacity();" name="capacity" id="capacity">
        </div>
        <div class="row-cols-3">
            <h6>实验限选学院</h6>
        </div>
        <div class="col-md-auto">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" name="collegeSelect" id="allColleges" value="all">
                <label class="form-check-label" for="allColleges">全部学院</label>
            </div>
        </div>
        <c:forEach items="${colleges}" var="college">
            <div class="col-md-auto">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="collegeSelect" id="${college.collegeId}" value="${college.collegeId}">
                    <label class="form-check-label" for="${college.collegeId}">${college.collegeName}</label>
                </div>
            </div>
        </c:forEach>
        <div class="row-cols-3">
            <button type="submit" class="btn btn-secondary">提交</button>
        </div>
    </form>
</body>
</html>
