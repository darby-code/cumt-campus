<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>主页面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<div class="row justify-content-md-center">
    <div id="carouselExampleCaptions" class="carousel slide" style="width: 900px;height: 555px;" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="resources/images/experiment-space.jpg" style="width: 900px;height: 555px;" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>物理实验选课通知</h5>
                    <p>本学期物理实验选课将在校历第二周开始，请相关同学注意</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="resources/images/experiment-board.png" style="width: 900px;height: 555px;" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>实验上课地点</h5>
                    <p>本学期物理实验上课地点均在物理学院4楼，具体地点见楼层通知栏</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="resources/images/experiment-dark.png" style="width: 900px;height: 555px;" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>物理实验注意事项</h5>
                    <p>不可以无故缺席所选物理实验，否则视为缺席。另外，本学期要选够5个实验</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="resources/images/experiment-func.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">登录页面</h5>
                    <p class="card-text">学生选课登录、教师登录</p>
                    <a href="userLogin/index.do" class="btn btn-link">进入登录页面</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="resources/images/experiment-book.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">物理实验中心</h5>
                    <p class="card-text">中国矿业大学物理教学实验中心于1997年在原数力系物理实验室的基础上组建而成。1998年5月通过江苏省教育厅组织的基础课教学实验室合格评估验收，所开设课程《大学物理实验》被评为省级二类优秀课程。2005年，物理教学实验中心从文昌校区搬迁到了风景秀丽的南湖校区。同年，物理教学实验中心被列为首批江苏省示范中心建设点，在建制上实施学校、理学院两级管理。并于2007年首批通过了江苏省物理实验教学示范中心评估验收.</p>
                    <a href="http://10.100.0.121:8019/customer/index/index0.html" class="btn btn-link">进入物理实验中心网站</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="resources/images/experiment-light.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">物理学院</h5>
                    <p class="card-text">2019年11月，中国矿业大学成立材料与物理学院，由原能源、材料与物理学部及其材料科学与工程学院、物理学院调整组建而成。学院下设金属材料与加工系、能源材料与器件系、无机非金属材料系、光电信息科学与工程系、应用物理系共5个系，大学物理教学中心、材料与物理前沿交叉研究中心、实验教学与分析测试中心共3个中心</p>
                    <a href="http://smsp.cumt.edu.cn/" class="btn btn-link">进入物理学院网站</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
