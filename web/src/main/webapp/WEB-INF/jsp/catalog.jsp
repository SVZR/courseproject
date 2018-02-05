<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
<c:forEach var="country" items="${requestScope.countrynames}">
    <p>${country.name}</p>
</c:forEach>
</body>
</html>