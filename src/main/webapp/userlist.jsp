<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.in6k.employees.domain.EmployeeModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>OK!</h1>
<%
    List<EmployeeModel> employeeModels = (List<EmployeeModel>)request.getAttribute("employees");
    for (EmployeeModel e: employeeModels) {
        %>
            <h3 style="color: #6005ff"><%=e.getEmail() + " "%><a href=<%="employeeform?email=" + e.getEmail()%>>edit</a></h3>
            <h4><%="Name: " + e.getName()%></h4>
            <h4><%="SurName: " + e.getSurname()%></h4>
            <h4><%="Password: " + e.getPassword()%></h4>
            <h4><%="Birth dade: " + e.getBirhdate()%></h4>
        <%
    }
%>

</body>
</html>