<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.in6k.employees.domain.EmployeeModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>OK!</h1>
<c:forEach var="employee" items="${employees}">
    <h3 style="color: #6005ff"><c:out value="${employee.email}" /><a href="employeeform?email=<c:out value="${employee.email}" />" /> edit</a></h3>
    <h4>Name: <c:out value="${employee.name}" /></h4>
    <h4>SurName: <c:out value="${employee.surname}" /></h4>
    <h4>Password: <c:out value="${employee.password}" /></h4>
    <h4>Birth date: <c:out value="${employee.birhdate}" /></h4>
</c:forEach>

</body>
</html>