
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="base/baseHeader.jsp"%>
<div class="container">
    <div class="row" style="height: 25px;"></div>
    <div class="row justify-content-center">
        <div class="col-4">
            <p class="h3">实验审核历史</p>
        </div>
    </div>
    <div class="row gy-5">
        <!--数据显示区域-->
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">实验名称</th>
                <th scope="col">实验时间</th>
                <th scope="col">实验星期</th>
                <th scope="col">实验地点</th>
                <th scope="col">可选人数</th>
                <th scope="col">实验教师</th>
                <th scope="col">发布者</th>
                <th scope="col">审核结果</th>
                <th scope="col">审核管理员</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allTempExperiments.list}" var="experiment">
                <tr>
                    <th scope="row">${experiment.experimentName}</th>
                    <td>${experiment.experimentTime}</td>
                    <td>${experiment.weekDay}</td>
                    <td>${experiment.experimentPlace}</td>
                    <td>${experiment.capacity}</td>
                    <td>${teachers.get(experiment.teacherId).teacherName}</td>
                    <td>${teachers.get(experiment.submitTeacherId).teacherName}</td>
                    <c:if test="${experiment.state == 0}">
                        <td>审核中</td>
                    </c:if>
                    <c:if test="${experiment.state == 1}">
                        <td>审核不通过</td>
                        <td>${admins.get(experiment.auditAdminAccount).name}</td>
                    </c:if>
                    <c:if test="${experiment.state == 2}">
                        <td>审核通过</td>
                        <td>${admins.get(experiment.auditAdminAccount).name}</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row g-0">
        <!--分页导航区-->
        <div class="col">
            <c:if test="${allTempExperiments.hasPreviousPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/experiment/showAuditHistory.do?pageNum=1&pageSize=${allTempExperiments.pageSize}'/>')" aria-label="first">首页</button>
            </c:if>
            <c:if test="${!allTempExperiments.hasPreviousPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/experiment/showAuditHistory.do?pageNum=1&pageSize=${allTempExperiments.pageSize}'/>')" aria-label="first">首页</button>
            </c:if>
        </div>
        <div class="col">
            <c:if test="${allTempExperiments.hasPreviousPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pageNum > 1 ? allTempExperiments.pageNum - 1 : 1}&pageSize=${allTempExperiments.pageSize}"/>')">上一页</button>
            </c:if>
            <c:if test="${!allTempExperiments.hasPreviousPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pageNum > 1 ? allTempExperiments.pageNum - 1 : 1}&pageSize=${allTempExperiments.pageSize}"/>')">上一页</button>
            </c:if>

        </div>
        <div class="col">
            <button class="btn btn-secondary" disabled>第${allTempExperiments.pageNum}页，共${allTempExperiments.pages}</button>
        </div>
        <div class="col">
            <c:if test="${allTempExperiments.hasNextPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pageNum < allTempExperiments.pages ? allTempExperiments.pageNum + 1 : allTempExperiments.pages}&pageSize=${allTempExperiments.pageSize}"/>')">下一页</button>
            </c:if>
            <c:if test="${!allTempExperiments.hasNextPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pageNum < allTempExperiments.pages ? allTempExperiments.pageNum + 1 : allTempExperiments.pages}&pageSize=${allTempExperiments.pageSize}"/>')">下一页</button>
            </c:if>

        </div>
        <div class="col">
            <c:if test="${allTempExperiments.hasNextPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pages}&pageSize=${allTempExperiments.pageSize}"/>')" aria-label="last">尾页</button>
            </c:if>
            <c:if test="${!allTempExperiments.hasNextPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditHistory.do?pageNum=${allTempExperiments.pages}&pageSize=${allTempExperiments.pageSize}"/>')" aria-label="last">尾页</button>
            </c:if>
        </div>
        <div class="col">
            <select class="form-select" aria-label="pageNum" onchange="changeAuditPageSize('experiment/showAuditHistory.do?pageNum=1&pageSize=', this);" id="pageSizeSelect">
                <option selected>页数据</option>
                <option value="1">1</option>
                <option value="3">3</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
        </div>
    </div>
</div>
</body>
</html>
