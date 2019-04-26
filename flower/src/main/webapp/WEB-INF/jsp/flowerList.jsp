<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>价格</td>
            <td>产地</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="flower">
            <tr>
                <td>${flower.id}</td>
                <td>${flower.name}</td>
                <td>${flower.price}</td>
                <td>${flower.pid}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
