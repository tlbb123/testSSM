<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/12
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${requestScope.accounts}" var="account">
        ${account.toString()} <a href="findById/${account.getAccount_id()}">查看</a>
        <a href="${sessionScope.path}/account/delete/${account.getAccount_id()}">删除账户</a>
        <br>
    </c:forEach><br>
    <a href="${sessionScope.path}/account/createAccount">新建账户</a>

</body>
</html>
