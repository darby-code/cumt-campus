<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/1
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 30px;"></div>
    <div class="container w-75">
        <!--学生-->
        <c:if test="${'student'.equals(role)}">
            <div class="row">
                <label for="studentId" class="col-sm-2 col-form-label">学号：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="studentId" value="${information.studentId}">
                </div>
            </div>
            <div class="row">
                <label for="studentName" class="col-sm-2 col-form-label">姓名：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="studentName" value="${information.studentName}">
                </div>
            </div>
            <div class="row">
                <label for="collegeName" class="col-sm-2 col-form-label">学院：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="collegeName" value="${information.college.collegeName}">
                </div>
            </div>
            <div class="row">
                <label for="classInfo" class="col-sm-2 col-form-label">班级：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="classInfo" value="${information.classInfo}">
                </div>
            </div>
            <div class="row">
                <label for="passwordInfo" class="col-sm-2 col-form-label">账号密码：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="passwordInfo" value="${information.password}">
                </div>
            </div>
            <div class="row">
                <label for="sex" class="col-sm-2 col-form-label">性别：</label>
                <div class="col-sm-10">
                    <c:if test="${information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="女">
                    </c:if>
                    <c:if test="${!information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="男">
                    </c:if>
                </div>
            </div>
            <form method="post" action="user/updateStudentInfo.do?studentId=${information.studentId}&" onsubmit="updateInfo(this);return false;">
                <div class="mb-3 row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">手机号：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkPhone();" id="phoneNumber" name="phoneNumber" value="${information.phoneNumber}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="email" class="col-sm-2 col-form-label">邮箱：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkEmail();"  id="email" name="email" value="${information.email}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="qq" class="col-sm-2 col-form-label">QQ：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="qq" name="qq" onblur="checkQQ();" value="${information.qq}">
                    </div>
                </div>
                <div class="mb-3 row justify-content-center">
                    <input type="submit" id="updateInfoBtn" onchange="changeAndSetNotDisabled();" disabled class="btn btn-secondary w-25" value="提交">
                </div>
            </form>
        </c:if>
        <!--教师-->
        <c:if test="${'teacher'.equals(role)}">
            <div class="row">
                <label for="teacherId" class="col-sm-2 col-form-label">工号：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="teacherId" value="${information.teacherId}">
                </div>
            </div>
            <div class="row">
                <label for="teacherName" class="col-sm-2 col-form-label">姓名：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="teacherName" value="${information.teacherName}">
                </div>
            </div>
            <div class="row">
                <label for="collegeName" class="col-sm-2 col-form-label">学院：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="collegeName" value="${information.college.collegeName}">
                </div>
            </div>
            <div class="row">
                <label for="passwordInfo" class="col-sm-2 col-form-label">账号密码：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="passwordInfo" value="${information.password}">
                </div>
            </div>
            <div class="row">
                <label for="sex" class="col-sm-2 col-form-label">性别：</label>
                <div class="col-sm-10">
                    <c:if test="${information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="女">
                    </c:if>
                    <c:if test="${!information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="男">
                    </c:if>
                </div>
            </div>
            <form method="post" action="user/updateTeacherInfo.do?teacherId=${information.teacherId}&" onsubmit="updateInfo(this);return false;">
                <div class="mb-3 row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">手机号：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkPhone();" id="phoneNumber" name="phoneNumber" value="${information.phoneNumber}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="email" class="col-sm-2 col-form-label">邮箱：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkEmail();" id="email" name="email" value="${information.email}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="qq" class="col-sm-2 col-form-label">QQ：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkQQ();" id="qq" name="qq" value="${information.qq}">
                    </div>
                </div>
                <div class="mb-3 row justify-content-center">
                    <input type="submit" id="updateInfoBtn" disabled class="btn btn-secondary w-25" value="提交">
                </div>
            </form>
        </c:if>
        <!--管理员-->
        <c:if test="${'admin'.equals(role)}">
            <div class="row">
                <label for="account" class="col-sm-2 col-form-label">账号：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="account" value="${information.account}">
                </div>
            </div>
            <div class="row">
                <label for="passwordInfo" class="col-sm-2 col-form-label">账号密码：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="passwordInfo" value="${information.password}">
                </div>
            </div>
            <div class="row">
                <label for="adminName" class="col-sm-2 col-form-label">姓名：</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="adminName" value="${information.name}">
                </div>
            </div>
            <div class="row">
                <label for="sex" class="col-sm-2 col-form-label">性别：</label>
                <div class="col-sm-10">
                    <c:if test="${information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="女">
                    </c:if>
                    <c:if test="${!information.sex}">
                        <input type="text" readonly class="form-control-plaintext" id="sex" value="男">
                    </c:if>
                </div>
            </div>
            <form method="post" action="user/updateAdminInfo.do?account=${information.account}&" onsubmit="updateInfo(this);return false;">
                <div class="mb-3 row">
                    <label for="phoneNumber" class="col-sm-2 col-form-label">手机号：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkPhone();" id="phoneNumber" name="phoneNumber" value="${information.phoneNumber}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="email" class="col-sm-2 col-form-label">邮箱：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkEmail();" id="email" name="email" value="${information.email}">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="qq" class="col-sm-2 col-form-label">QQ：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" onchange="changeAndSetNotDisabled();" onblur="checkQQ();" id="qq" name="qq" value="${information.qq}">
                    </div>
                </div>
                <div class="mb-3 row justify-content-center">
                    <input type="submit" id="updateInfoBtn" disabled class="btn btn-secondary w-25" value="提交">
                </div>
            </form>
        </c:if>

    </div>

</body>
</html>
