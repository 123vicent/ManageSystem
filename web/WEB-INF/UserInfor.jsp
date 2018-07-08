<%--
  Created by IntelliJ IDEA.
  User: rsh
  Date: 2018/7/5
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="U" items="${userAll}">
    <h1>${U}</h1>
</c:forEach>
</body>
</html>
