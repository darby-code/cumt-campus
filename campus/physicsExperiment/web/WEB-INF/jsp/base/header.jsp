<%@ page import="edu.cumt.phyExperiment.dto.RoleTransfer" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="edu.cumt.phyExperiment.entity.Experiment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    RoleTransfer roleTransfer = (RoleTransfer) session.getAttribute("roleInfo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/jquery/jquery-3.5.1.min.js">
</head>
<body>
<div class="row justify-content-between">
    <div class="col-4 w-75">
        <h1 class="display-3">材料与物理学院实验中心</h1>
    </div>
    <div class="col-4 w-25">
        <div class="row justify-content-evenly">
            <div class="col-md-auto">
                <p class="lead"><%=roleTransfer.getName() + roleTransfer.getRoleStateEnum().getRoleInfo()%>，您好</p>
            </div>
            <div class="col-md-auto">
                <button type="button" class="btn btn-light" data-bs-toggle="tooltip" data-bs-placement="bottom" title="退出系统" id="logoutBtn" onclick="window.location.href='userLogin/index.do'">注销</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
