<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-04-09
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify/Remove</title>
</head>
<body>
    <form action="/todo/modify" method="post">
        <div><input type="text" name="tno" value="${dto.tno}" readonly></div>
        <div><input type="text" name="title" value="${dto.title}"></div>
        <div><input type="text" name="dueDate" value="${dto.dueDate}"></div>
        <div><input type="text" name="finished" value="${dto.finished}" readonly></div>
        <div><button type="submit">Modify</button></div>
    </form>
    <form action="/todo/remove" method="post">
        <input type="hidden" name="tno" value="${dto.tno}" readonly>
        <div><button type="submit">Remove</button></div>
    </form>
</body>
</html>
