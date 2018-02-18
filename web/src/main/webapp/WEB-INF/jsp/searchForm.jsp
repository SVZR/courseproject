<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/search" method="post">
    <input type="text" placeholder="Coin name" name="coinName">
    <select class="form-control" name="metalId">
        <c:forEach var="metal" items="${requestScope.metals}">
            <option value="${metal.id}">${metal.name}</option>
        </c:forEach>
    </select>
    <input type="text" placeholder="Year" name="year">
    <button type="submit">Search</button>
</form>
</body>
</html>
