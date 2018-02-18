<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coin</title>
</head>
<body>
<%@ include file="header.jsp"%>
    <p>${requestScope.coin.series.theme.country.name}</p>
    <p>${requestScope.coin.series.theme.name}</p>
        <c:if test="${requestScope.coin.series.name ne 'No theme'}">
            <p>${requestScope.coin.series.name}</p>
        </c:if>
    <p>${requestScope.coin.name}</p>
    <p>Release date: ${requestScope.coin.releaseDate}</p>
    <p>Designer: ${requestScope.coin.designer}          Mintage by: ${requestScope.coin.mintedBy}</p>
    <table class="table">
        <tbody>
            <%@ include file="coin-description-table-catalog.jsp"%>
        </tbody>
    </table>
<br>
<br>
<p>Obverse: ${requestScope.coin.description}</p>
</body>
</html>
