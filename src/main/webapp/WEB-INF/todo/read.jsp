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
    <title>Todo 1개 읽기 페이지</title>
</head>
<body>
    <div>${dto.tno}</div>
    <div>${dto.title}</div>
    <div>${dto.dueDate}</div>
    <div>${dto.finished}</div>
    <div>
        <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
        <a href="/todo/list">List</a>
    </div>
</body>
</html>
