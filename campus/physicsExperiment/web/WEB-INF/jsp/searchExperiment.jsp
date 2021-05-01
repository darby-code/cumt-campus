<%--
  Created by IntelliJ IDEA.
  User: HMY-computer
  Date: 2021/4/28
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@ include file="base/baseHeader.jsp"%>
    <div class="row" style="height: 25px;"></div>
    <div class="row justify-content-center">
        <div class="col-4">
            <p class="h4">实验搜索</p>
        </div>
    </div>
    <div class="row" style="height: 10px;"></div>
    <div class="row justify-content-center">
        <div class="col-auto">
            <div class="form-floating">
                <input type="text" name="words" class="form-control" id="keyWords" placeholder="Password">
                <label for="keyWords">关键词</label>
            </div>
        </div>
        <div class="col-auto">
            <button class="btn btn-secondary btn-lg" onclick="addSearchKeyWords('experiment/searchExperiment.do?')">搜索</button>
        </div>
    </div>

</body>
</html>
