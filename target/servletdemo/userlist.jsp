<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.in6k.servletdemo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>OK!</h1>
<%
    List<User> users = (List<User>)request.getAttribute("users");
    for (User u: users) {
        %>
            <form name="test" method="post" action="index.jsp">
                <h3 style="color: #6005ff"><%=u.getEmail() + " "%><input type="submit" value="edit"></h3>
                <h4><%="Name: " + u.getName()%></h4>
                <h4><%="SurName: " + u.getSurName()%></h4>
                <h4><%="Password: " + u.getPass()%></h4>
                <h4><%="Birth dade: " + u.getBirhdate()%></h4>
            </form>
        <%
    }
%>

</body>
</html>