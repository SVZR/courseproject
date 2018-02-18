<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.country.name}</title>
</head>
<body>
    <%@ include file="header.jsp"%>
    <h3>${requestScope.country.name}</h3>
    <p>
        <c:forEach var="theme" items="${requestScope.country.themes}">
        <h4>${theme.name}</h4>
            <c:forEach var="series" items="${theme.series}">
                <h5>${series.name}</h5>
                    <c:forEach var="coin" items="${series.coins}">
                            <a href="${pageContext.request.contextPath}/coin?id=${coin.id}">${coin.name}</a>
                    </c:forEach>
            </c:forEach>
        </c:forEach>
    </p>
</body>
</html>
