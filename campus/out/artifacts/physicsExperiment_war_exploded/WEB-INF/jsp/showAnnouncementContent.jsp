<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/5/5
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="base/baseHeader.jsp"%>
    <div style="height: 50px;"></div>
    <div class="container">
        <div class="form-floating">
            <textarea class="form-control" id="contentArea" onchange="listenContentChange(this);" placeholder="Leave a comment here" id="announcement" style="height: 150px">
                ${announcementContent}
            </textarea>
            <label for="announcement">公告内容</label>
        </div>
        <div style="height: 20px;"></div>
        <div class="row justify-content-center">
            <div class="col-md-4">
                <button type="button" id="submitBtn" onclick="submitNewContent('user/modifyContent.do?')" class="btn btn-outline-primary" disabled>提交修改内容</button>
            </div>
            <div class="col-md-4">
                <button type="button" onclick="previewContent();" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">预览公告</button>
            </div>
        </div>
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">公告内容</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="card-body">
                            <h5 class="card-title">选课通知</h5>
                            <p class="card-text" id="showContent"></p>
                            <a href="" class="btn btn-outline-secondary">了解更多...</a>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭显示</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
