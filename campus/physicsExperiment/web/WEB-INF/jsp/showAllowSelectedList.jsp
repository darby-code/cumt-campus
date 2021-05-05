
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div class="container">
        <div class="row" style="height: 25px;"></div>
        <div class="row justify-content-center">
            <div class="col-4">
                <p class="h3">可选实验</p>
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
                    <th scope="col">可选人数</th>
                    <th scope="col">已选人数</th>
                    <th scope="col">详细信息</th>
                    <th scope="col">实验选课截止时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allowSelectedList.list}" var="experiment">
                    <tr>
                        <th scope="row">${experiment.experimentId}</th>
                        <td>${experiment.experimentName}</td>
                        <td>${experiment.experimentTime}</td>
                        <td>${experiment.capacity}</td>
                        <td>${experiment.selectedNumber}</td>
                        <td><a class="btn btn-outline-dark btn-sm" id="${experiment.experimentId}" onclick="getOffCanvasData('experiment/experimentDetails.do?experimentId=' + this.id);" data-bs-toggle="offcanvas" data-bs-target="#experimentDetails" role="button">详情</a></td>
                        <td>${experimentDeadLine.get(experiment.experimentId)}</td>
                        <td><button class="btn btn-outline-secondary btn-sm" id="end${experiment.experimentId}" onclick="setNotAllowSelected(this);">手动截止选课</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row g-0">
            <!--分页导航区-->
            <div class="col">
                <c:if test="${allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/experiment/showAllowSelectedExperiments.do?pageNum=1&pageSize=${allowSelectedList.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/experiment/showAllowSelectedExperiments.do?pageNum=1&pageSize=${allowSelectedList.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAllowSelectedExperiments.do?pageNum=${allowSelectedList.pageNum > 1 ? allowSelectedList.pageNum - 1 : 1}&pageSize=${allowSelectedList.pageSize}"/>')">上一页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAllowSelectedExperiments.do?pageNum=${allowSelectedList.pageNum > 1 ? allowSelectedList.pageNum - 1 : 1}&pageSize=${allowSelectedList.pageSize}"/>')">上一页</button>
                </c:if>

            </div>
            <div class="col">
                <button class="btn btn-secondary" disabled>第${allowSelectedList.pageNum}页，共${allowSelectedList.pages}</button>
            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAllowSelectedExperiments.do?pageNum=${allowSelectedList.pageNum < allowSelectedList.pages ? allowSelectedList.pageNum + 1 : allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')">下一页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAllowSelectedExperiments.do?pageNum=${allowSelectedList.pageNum < allowSelectedList.pages ? allowSelectedList.pageNum + 1 : allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')">下一页</button>
                </c:if>

            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showAuditExperiments.do?pageNum=${allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
            </div>
            <div class="col">
                <select class="form-select" aria-label="pageNum" onchange="changeAuditPageSize('experiment/showAllowSelectedExperiments.do?pageNum=1&pageSize=', this);" id="pageSizeSelect">
                    <option selected>页数据</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="4">4</option>
                    <option value="8">8</option>
                </select>
            </div>
        </div>
        <div class="offcanvas offcanvas-start" tabindex="-1" id="experimentDetails" aria-labelledby="offcanvasLabel">

        </div>
    </div>
</body>
</html>
