<%@ page import="java.util.HashMap" %>
<%@ page import="edu.cumt.phyExperiment.entity.Experiment" %><%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/4/29
  Time: 20:59
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
                <p class="h3">可选实验</p>
            </div>
        </div>
        <div class="row gy-5">
            <!--数据显示区域-->
            <table id="allowSelectedExperiments" class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">实验编号</th>
                    <th scope="col">实验名称</th>
                    <th scope="col">实验时间</th>
                    <th scope="col">实验老师</th>
                    <th scope="col">实验地点</th>
                    <th scope="col">可选</th>
                    <th scope="col">已选</th>
                    <th scope="col">实验截止选课时间</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${allowSelectedList.list}" var="experiment">
                    <tr>
                        <th scope="row">${experiment.experimentId}</th>
                        <td>${experiment.experimentName}</td>
                        <td>${experiment.experimentTime}</td>
                        <td>${experiment.teacherName}</td>
                        <td>${experiment.experimentPlace}</td>
                        <td>${experiment.capacity}</td>
                        <td>${experiment.selectedNumber}</td>
                        <td>${experimentDeadLine.get(experiment.experimentId)}</td>
                        <td>
                            <c:if test="${studentSelectedExperiments.get(experiment.experimentId) == null}">
                                <c:if test="${experiment.selectedNumber < experiment.capacity}">
                                    <button class="btn btn-outline-dark" id="${experiment.experimentId}" onclick="checkExperimentCouldBeSelected(${studentId}, this)">选择</button>
                                </c:if>
                                <c:if test="${experiment.selectedNumber >= experiment.capacity}">
                                    <button class="btn btn-outline-dark" disabled id="${experiment.experimentId}">选择</button>
                                </c:if>
                            </c:if>
                            <c:if test="${studentSelectedExperiments.get(experiment.experimentId) != null}">
                                <button class="btn btn-outline-danger" id="${experiment.experimentId}" onclick="dropExperiment(${studentId}, this)">退选</button>
                            </c:if>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row g-0">
            <!--分页导航区-->
            <div class="col">
                <c:if test="${allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=1&pageSize=${allowSelectedList.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=1&pageSize=${allowSelectedList.pageSize}'/>')" aria-label="first">首页</button>
                </c:if>
            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pageNum > 1 ? allowSelectedList.pageNum - 1 : 1}&pageSize=${allowSelectedList.pageSize}"/>')">上一页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasPreviousPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pageNum > 1 ? allowSelectedList.pageNum - 1 : 1}&pageSize=${allowSelectedList.pageSize}"/>')">上一页</button>
                </c:if>

            </div>
            <div class="col">
                <button class="btn btn-secondary" disabled>第${allowSelectedList.pageNum}页，共${allowSelectedList.pages}</button>
            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pageNum < allowSelectedList.pages ? allowSelectedList.pageNum + 1 : allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')">下一页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pageNum < allowSelectedList.pages ? allowSelectedList.pageNum + 1 : allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')">下一页</button>
                </c:if>

            </div>
            <div class="col">
                <c:if test="${allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
                <c:if test="${!allowSelectedList.hasNextPage}">
                    <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/experiment/showSelectExperiment.do?studentId=${studentId}&pageNum=${allowSelectedList.pages}&pageSize=${allowSelectedList.pageSize}"/>')" aria-label="last">尾页</button>
                </c:if>
            </div>
            <div class="col">
                <select class="form-select" aria-label="pageNum" onchange="selectChangePageSize(this, ${studentId});" id="pageSizeSelect">
                    <option selected>页数据</option>
                    <option value="1">1</option>
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
            </div>
        </div>
    </div>
    <script type="text/javascript">

    </script>
</body>
</html>
