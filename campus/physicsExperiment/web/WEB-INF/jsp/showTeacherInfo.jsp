<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/5
  Time: 13:34
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
            <p class="h3">教师信息</p>
        </div>
    </div>
    <div class="row gy-5">
        <!--数据显示区域-->
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">工号</th>
                <th scope="col">姓名</th>
                <th scope="col">性别</th>
                <th scope="col">学院</th>
                <th scope="col">手机号</th>
                <th scope="col">邮箱</th>
                <th scope="col">QQ</th>
                <th scope="col">登录密码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${infoList.list}" var="teacher">
                <tr>
                    <th scope="row">${teacher.teacherId}</th>
                    <td>${teacher.teacherName}</td>
                    <td>${teacher.sex == false ? "男" : "女"}</td>
                    <td>${teacher.college.collegeName}</td>
                    <td>${teacher.phoneNumber}</td>
                    <td>${teacher.email}</td>
                    <td>${teacher.qq}</td>
                    <td>${teacher.password}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row g-0">
        <!--分页导航区-->
        <div class="col">
            <c:if test="${infoList.hasPreviousPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value='/user/showTeacherInfo.do?pageNum=1&pageSize=${infoList.pageSize}'/>')" aria-label="first">首页</button>
            </c:if>
            <c:if test="${!infoList.hasPreviousPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value='/user/showTeacherInfo.do?pageNum=1&pageSize=${infoList.pageSize}'/>')" aria-label="first">首页</button>
            </c:if>
        </div>
        <div class="col">
            <c:if test="${infoList.hasPreviousPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pageNum > 1 ? infoList.pageNum - 1 : 1}&pageSize=${infoList.pageSize}"/>')">上一页</button>
            </c:if>
            <c:if test="${!infoList.hasPreviousPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pageNum > 1 ? infoList.pageNum - 1 : 1}&pageSize=${infoList.pageSize}"/>')">上一页</button>
            </c:if>

        </div>
        <div class="col">
            <button class="btn btn-secondary" disabled>第${infoList.pageNum}页，共${infoList.pages}</button>
        </div>
        <div class="col">
            <c:if test="${infoList.hasNextPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pageNum < infoList.pages ? infoList.pageNum + 1 : infoList.pages}&pageSize=${infoList.pageSize}"/>')">下一页</button>
            </c:if>
            <c:if test="${!infoList.hasNextPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pageNum < infoList.pages ? infoList.pageNum + 1 : infoList.pages}&pageSize=${infoList.pageSize}"/>')">下一页</button>
            </c:if>

        </div>
        <div class="col">
            <c:if test="${infoList.hasNextPage}">
                <button class="btn btn-outline-secondary" onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pages}&pageSize=${infoList.pageSize}"/>')" aria-label="last">尾页</button>
            </c:if>
            <c:if test="${!infoList.hasNextPage}">
                <button class="btn btn-outline-secondary" disabled onclick="showAtRight('<c:url value="/user/showTeacherInfo.do?pageNum=${infoList.pages}&pageSize=${infoList.pageSize}"/>')" aria-label="last">尾页</button>
            </c:if>
        </div>
        <div class="col">
            <select class="form-select" aria-label="pageNum" onchange="changeAuditPageSize('user/showTeacherInfo.do?pageNum=1&pageSize=', this);" id="pageSizeSelect">
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
