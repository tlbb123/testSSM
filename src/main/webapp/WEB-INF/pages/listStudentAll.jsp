<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/12
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${requestScope.students}" var="student">
            ${student.toString()} <a href="findById/${student.getStudent_id()}">查看</a>
        <a href="${sessionScope.path}/student/delete/${student.getStudent_id()}">删除学生</a>
        <br>
    </c:forEach>
</body>
</html>
