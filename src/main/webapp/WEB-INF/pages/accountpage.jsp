<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/13
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.account}

<a href="${sessionScope.path}/info/showInfo">查看详细记录</a>

<h3>充值</h3>
<form method="post" action="${sessionScope.path}/account/recharge">
    <input type="text" name="money">
    <input type="submit" value="提交">
</form><br>
<h3>转账</h3>
<form method="post" action="${sessionScope.path}/account/transfor">
    转入账户id:<input type="text" name="fromid">
    转出金额:<input type="text" name="money">
    <input type="submit" value="确定">
</form><br>

<a href="${sessionScope.path}/account/consume/5">买瓶冰可乐</a><br>
<a href="${sessionScope.path}/account/consume/3">买根大香肠</a><br>
<a href="${sessionScope.path}/account/consume/3">吃一顿午饭</a>
</body>
</html>
