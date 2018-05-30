<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main_box wrap1080 clearfix">
    <jsp:include page="/category_left.html"  flush="true"></jsp:include>
    <div class="main_right rightF">
        <jsp:include page="/activityUsers.html"  flush="true"></jsp:include>
    </div>
</div>
</body>
</html>
