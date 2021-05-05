<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/5
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@include file="base/baseHeader.jsp"%>
<div style="height: 50px;"></div>
<div class="accordion" id="teacherResetPasswordMenu">
    <c:forEach items="${colleges}" var="college">
        <c:if test="${(colleger.get(college.collegeId)).list.size() != 0}">
            <!--学院的老师不为空-->
            <div class="accordion-item">
                <h2 class="accordion-header" id="menu${college.collegeId}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#id${college.collegeId}" aria-expanded="false" aria-controls="id${college.collegeId}">
                            ${college.collegeId}   ${college.collegeName}        &nbsp;&nbsp;<a class="btn btn-outline-danger" onclick="resetPassword('user/resetAllTeacherPassword.do?collegeId=${college.collegeId}', this)">一键重置密码</a>
                    </button>
                </h2>
                <div id="id${college.collegeId}" class="accordion-collapse collapse" aria-labelledby="menu${college.collegeId}" data-bs-parent="#teacherResetPasswordMenu">
                    <div id="college${college.collegeId}" class="accordion-body">
                        <!--显示内容-->
                        <div class="row gy-5">
                            <!--数据显示区域-->
                            <table id="allowSelectedExperiments" class="table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">工号</th>
                                    <th scope="col">姓名</th>
                                    <th scope="col">手机号</th>
                                    <th scope="col">QQ</th>
                                    <th scope="col">密码</th>
                                    <th scope="col">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${(colleger.get(college.collegeId)).list}" var="teacher">
                                    <tr>
                                        <th scope="row">${teacher.teacherId}</th>
                                        <td>${teacher.teacherName}</td>
                                        <td>${teacher.phoneNumber}</td>
                                        <td>${teacher.qq}</td>
                                        <td>${teacher.password}</td>
                                        <td><button class="btn btn-danger" onclick="resetPassword('user/resetTeacherPassword.do?teacherId=${teacher.teacherId}', this)">重置</button></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="row g-0">
                            <!--分页导航区-->
                            <div class="col">
                                <c:if test="${colleger.get(college.collegeId).hasPreviousPage}">
                                    <button class="btn btn-outline-secondary" onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&collegeId=${college.collegeId}&pageNum=1&pageSize=${colleger.get(college.collegeId).pageSize}')" aria-label="first">首页</button>
                                </c:if>
                                <c:if test="${!colleger.get(college.collegeId).hasPreviousPage}">
                                    <button class="btn btn-outline-secondary" disabled onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=1&pageSize=${colleger.get(college.collegeId).pageSize}')" aria-label="first">首页</button>
                                </c:if>
                            </div>
                            <div class="col">
                                <c:if test="${colleger.get(college.collegeId).hasPreviousPage}">
                                    <button class="btn btn-outline-secondary" onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pageNum > 1 ? colleger.get(college.collegeId).pageNum - 1 : 1}&pageSize=${colleger.get(college.collegeId).pageSize}')">上一页</button>
                                </c:if>
                                <c:if test="${!colleger.get(college.collegeId).hasPreviousPage}">
                                    <button class="btn btn-outline-secondary" disabled onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pageNum > 1 ? colleger.get(college.collegeId).pageNum - 1 : 1}&pageSize=${colleger.get(college.collegeId).pageSize}')">上一页</button>
                                </c:if>

                            </div>
                            <div class="col">
                                <button class="btn btn-secondary" disabled>第${colleger.get(college.collegeId).pageNum}页，共${colleger.get(college.collegeId).pages}</button>
                            </div>
                            <div class="col">
                                <c:if test="${colleger.get(college.collegeId).hasNextPage}">
                                    <button class="btn btn-outline-secondary" onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pageNum < colleger.get(college.collegeId).pages ? colleger.get(college.collegeId).pageNum + 1 : colleger.get(college.collegeId).pages}&pageSize=${colleger.get(college.collegeId).pageSize}')">下一页</button>
                                </c:if>
                                <c:if test="${!colleger.get(college.collegeId).hasNextPage}">
                                    <button class="btn btn-outline-secondary" disabled onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pageNum < colleger.get(college.collegeId).pages ? colleger.get(college.collegeId).pageNum + 1 : colleger.get(college.collegeId).pages}&pageSize=${colleger.get(college.collegeId).pageSize}')">下一页</button>
                                </c:if>

                            </div>
                            <div class="col">
                                <c:if test="${colleger.get(college.collegeId).hasNextPage}">
                                    <button class="btn btn-outline-secondary" onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pages}&pageSize=${colleger.get(college.collegeId).pageSize}')" aria-label="last">尾页</button>
                                </c:if>
                                <c:if test="${!colleger.get(college.collegeId).hasNextPage}">
                                    <button class="btn btn-outline-secondary" disabled onclick="showAtCollege(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=${colleger.get(college.collegeId).pages}&pageSize=${colleger.get(college.collegeId).pageSize}')" aria-label="last">尾页</button>
                                </c:if>
                            </div>
                            <div class="col">
                                <select class="form-select" aria-label="pageNum" onchange="changePasswordPageSize(${college.collegeId}, 'user/teacherResetTable.do?collegeId=${college.collegeId}&pageNum=1&pageSize=', this);">
                                    <option selected>页数据</option>
                                    <option value="1">1</option>
                                    <option value="3">3</option>
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                </select>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
