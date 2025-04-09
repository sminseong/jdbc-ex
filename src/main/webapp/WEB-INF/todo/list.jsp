<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-04-07
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo List Page</h1>
    <h2>${loginInfo}</h2>
    <h3>${loginInfo.mname}</h3>
    <h3>${appName}</h3>
    <ul>
        <c:forEach items="${list}" var ="dto">
            <li>
                <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
                <span>${dto.title}</span>
                <span>${dto.dueDate}</span>
                <span>${dto.finished? "DONE": "NOT YET"}</span>
            </li>
        </c:forEach>
    </ul>
    <form action="/logout" method="post">
        <button>로그아웃</button>
    </form>
</body>
</html>
