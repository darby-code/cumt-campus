<%@ page import="java.util.List" %>
<%@ page import="edu.cumt.phyExperiment.entity.Experiment" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div class="container">
        <div class="row" style="height: 25px;"></div>
        <div class="row justify-content-center">
            <div class="col-4">
                <p class="h3">实验信息</p>
            </div>
        </div>
        <div class="row gy-5">
            <!--数据显示区域-->
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">实验名称</th>
                    <th scope="col">实验时间</th>
                    <th scope="col">实验地点</th>
                    <th scope="col">可选人数</th>
                    <th scope="col">已选人数</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="experiment">
                    <tr>
                        <th scope="row">${experiment.experimentName}</th>
                        <td>${experiment.experimentTime}</td>
                        <td>${experiment.experimentPlace}</td>
                        <td>${experiment.capacity}</td>
                        <td>${experiment.selectedNumber}</td>
                        <td><a class="btn btn-outline-dark" id="${experiment.experimentId}" onclick="getOffCanvasData('experiment/experimentDetails.do?experimentId=' + this.id);" data-bs-toggle="offcanvas" data-bs-target="#experimentDetails" role="button">详情</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row g-0">
            <!--分页导航区-->
            <div class="col">
                <c:if test="${pageInfo.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/experiment/allExperiments.do?pageNum=1&pageSize=${pageInfo.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
                <c:if test="${!pageInfo.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/experiment/allExperiments.do?pageNum=1&pageSize=${pageInfo.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
            </div>
            <div class="col">
                <c:if test="${pageInfo.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pageNum > 1 ? pageInfo.pageNum - 1 : 1}&pageSize=${pageInfo.pageSize}"/>')">上一页</button>
                </c:if>
                <c:if test="${!pageInfo.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pageNum > 1 ? pageInfo.pageNum - 1 : 1}&pageSize=${pageInfo.pageSize}"/>')">上一页</button>
                </c:if>

            </div>
            <div class="col">
                <button class="btn btn-secondary" disabled>第${pageInfo.pageNum}页，共${pageInfo.pages}</button>
            </div>
            <div class="col">
                <c:if test="${pageInfo.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pageNum < pageInfo.pages ? pageInfo.pageNum + 1 : pageInfo.pages}&pageSize=${pageInfo.pageSize}"/>')">下一页</button>
                </c:if>
                <c:if test="${!pageInfo.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pageNum < pageInfo.pages ? pageInfo.pageNum + 1 : pageInfo.pages}&pageSize=${pageInfo.pageSize}"/>')">下一页</button>
                </c:if>

            </div>
            <div class="col">
                <c:if test="${pageInfo.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
                <c:if test="${!pageInfo.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/allExperiments.do?pageNum=${pageInfo.pages}&pageSize=${pageInfo.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
            </div>
            <div class="col">
                <select class="form-select" aria-label="pageNum" onchange="changePageSize(this);" id="pageSizeSelect">
                    <option selected>页数据</option>
                    <option value="1">1</option>
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
            </div>
        </div>

        <div class="offcanvas offcanvas-start" tabindex="-1" id="experimentDetails" aria-labelledby="offcanvasLabel">

        </div>
    </div>
</body>
</html>
