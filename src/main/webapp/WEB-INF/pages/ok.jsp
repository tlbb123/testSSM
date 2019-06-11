<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/12
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>操作完成</title>
</head>
<body>
    <%response.sendRedirect(request.getSession().getAttribute("path")+"/account/findById/"
            +request.getSession().getAttribute("aid"));%>

</body>
</html>
