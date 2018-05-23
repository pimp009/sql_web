<%--
  Created by IntelliJ IDEA.
  User: Azat
  Date: 17.05.2018
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SV</title>
</head>
<body>

<form action="${pageContext.request.contextPath}student" method="get">
    Введите id группы<input type="text" name="id">
    <input type="submit" value="Отправить">
</form>
</body>
</html>
