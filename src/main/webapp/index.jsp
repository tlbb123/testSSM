<%--
  Created by IntelliJ IDEA.
  User: tl
  Date: 2019/5/12
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用</title>
</head>
<body>
<h1>欢迎使用学生管理系统</h1>
<h3>请输入要访问的学生姓名</h3>

<form method="post" action="student/findByname">
    学生姓名:<input type="text" name="name">
    <input type="submit">
</form>

<a href="registerpage.html">注册</a>

<a href="student/findAll">查找全部学生</a><br/>


</form>
</body>
</html>
