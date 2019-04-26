<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath }/api-a"></c:set>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${cxt}/flowers.do" method="post">
<table>
    <tr>
        <td>名称</td>
        <td><input type="text" name="name" id="name" value="${name}"></td>
    </tr>
    <tr>
        <td rowspan="2"><input type="submit" value="提交"></td>
    </tr>
</table>
</form>
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
