<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/4
  Time: 10:11
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
                <p class="h3">待审核实验</p>
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
                    <th scope="col">审核操作</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${auditExperiments.list}" var="experiment">
                        <tr>
                            <th scope="row">${experiment.experimentName}</th>
                            <td>${experiment.experimentTime}</td>
                            <td>${experiment.weekDay}</td>
                            <td>${experiment.experimentPlace}</td>
                            <td>${experiment.capacity}</td>
                            <td>${teachers.get(experiment.teacherId).teacherName}</td>
                            <td>${teachers.get(experiment.submitTeacherId).teacherName}</td>
                            <td class="col-2">
                                 <div class="btn-group" role="group" aria-label="Basic outlined example">
                                    <button class="btn btn-outline-dark" id="go${experiment.tempId}" onclick="auditPassOrNot(this)">通过</button>
                                    <button class="btn btn-outline-dark" id="no${experiment.tempId}" onclick="auditPassOrNot(this)">不通过</button>
                                </div>
                            </td>
                         </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row g-0">
            <!--分页导航区-->
            <div class="col">
                <c:if test="${auditExperiments.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/experiment/showAuditExperiments.do?pageNum=1&pageSize=${auditExperiments.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
                <c:if test="${!auditExperiments.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/experiment/showAuditExperiments.do?pageNum=1&pageSize=${auditExperiments.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
            </div>
            <div class="col">
                <c:if test="${auditExperiments.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pageNum > 1 ? auditExperiments.pageNum - 1 : 1}&pageSize=${auditExperiments.pageSize}"/>')">上一页</button>
                </c:if>
                <c:if test="${!auditExperiments.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pageNum > 1 ? auditExperiments.pageNum - 1 : 1}&pageSize=${auditExperiments.pageSize}"/>')">上一页</button>
                </c:if>

            </div>
            <div class="col">
                <button class="btn btn-secondary" disabled>第${auditExperiments.pageNum}页，共${auditExperiments.pages}</button>
            </div>
            <div class="col">
                <c:if test="${auditExperiments.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pageNum < auditExperiments.pages ? auditExperiments.pageNum + 1 : auditExperiments.pages}&pageSize=${auditExperiments.pageSize}"/>')">下一页</button>
                </c:if>
                <c:if test="${!auditExperiments.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pageNum < auditExperiments.pages ? auditExperiments.pageNum + 1 : auditExperiments.pages}&pageSize=${auditExperiments.pageSize}"/>')">下一页</button>
                </c:if>

            </div>
            <div class="col">
                <c:if test="${auditExperiments.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pages}&pageSize=${auditExperiments.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
                <c:if test="${!auditExperiments.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${auditExperiments.pages}&pageSize=${auditExperiments.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
            </div>
            <div class="col">
                <select class="form-select" aria-label="pageNum" onchange="changeAuditPageSize('experiment/showAuditExperiments.do?pageNum=1&pageSize=', this);" id="pageSizeSelect">
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
