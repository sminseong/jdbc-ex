<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-04-07
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo login</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인</h1>
    </c:if>
    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="text" name="mpwd">
        <input type="checkbox" name="auto">
        <button type="submit">로그인</button>
    </form>
</body>
</html>
