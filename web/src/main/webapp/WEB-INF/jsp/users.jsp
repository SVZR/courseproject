<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<%@include file="header.jsp"%>
<body>
<form name="search" method="get">
    <input type="text" placeholder="First name" value="${requestScope.searchFilter.getOrDefault("firstName", "")}" name="firstName">

    Role:
    <select name="role" id="role">
        <option value="ALL">ALL</option>
        <c:forEach var="role" items="${requestScope.roles}">
            <c:if test="${role eq requestScope.searchFilter.get('role')}">
                <option value="${role}" selected>${role}</option>
            </c:if>
            <c:if test="${role ne requestScope.searchFilter.get('role')}">
                <option value="${role}">${role}</option>
            </c:if>
        </c:forEach>
    </select>

    Have collection:
    <c:if test="${requestScope.searchFilter.get('haveCollection') eq 'on'}">
        <input type="checkbox" name="haveCollection" checked>
    </c:if>
    <c:if test="${requestScope.searchFilter.get('haveCollection') ne 'on'}">
        <input type="checkbox" name="haveCollection">
    </c:if>

    Amount users on page:
    <select name="amountUsersOnPage" id="usersOnPage">
        <c:forEach var="amounted" items="${requestScope.amount}">
            <c:if test="${amounted eq requestScope.searchFilter.get('amountUsersOnPage')}">
                <option value="${amounted}" selected>${amounted}</option>
            </c:if>
            <c:if test="${amounted ne requestScope.searchFilter.get('amountUsersOnPage')}">
                <option value="${amounted}">${amounted}</option>
            </c:if>
        </c:forEach>
    </select>
    <button name="search" type="submit">Search</button>
</form>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">UserId</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Login</th>
        <th scope="col">E-mail</th>
        <th scope="col">User role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.userLogin}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<br>
<c:forEach var="page" items="${requestScope.pages}">
    <a href="${pageContext.request.contextPath}/users?page=${page}&firstName=${requestScope.searchFilter.get('firstName')}&role=${requestScope.searchFilter.get('role')}&haveCollection=${requestScope.searchFilter.get('haveCollection')}&amountUsersOnPage=${requestScope.searchFilter.get('amountUsersOnPage')}"> ${page} </a>
</c:forEach>
</body>
</html>
