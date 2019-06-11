<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/13
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.infos}" var="info">
    ${info.toString()}<br>
</c:forEach>

</body>
</html>
