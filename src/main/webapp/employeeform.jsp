<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.in6k.employees.domain.EmployeeModel" %>

<html>
<html>
<head>
    <title></title>
</head>
<body>
<form name="test" method="post" action="/employeeform">
    <%!
        private String checkValue(String value) {
            return value != null ? value : "";
        }
        private String setFieldParam(HttpServletRequest request, String value) {
            String result = "";
            EmployeeModel employee;
            if (request.getAttribute("employee") != null) {
                employee = (EmployeeModel)request.getAttribute("employee");
                if (value.equals("name")) {
                    result = employee.getName();
                } else if (value.equals("surname")) {
                    result = employee.getSurname();
                } else if (value.equals("email")) {
                    result = employee.getEmail();
                } else if (value.equals("password") || value.equals("passwordConfirmation")) {
                    result = employee.getPassword();
                } else if (value.equals("birhdate")) {
                    result = employee.getBirhdate();
                }
            } else if (request.getParameter(value) != null) {
                result = request.getParameter(value);
            }
            return result;
        }
    %>
    <%
        Map<String, String> colors = new HashMap<String, String>();
        colors.put("name", "black");
        colors.put("surname", "black");
        colors.put("email", "black");
        colors.put("password", "black");
        colors.put("passwordConfirmation", "black");
        colors.put("birhdate", "black");

        if (request.getAttribute("errors") != null && !((Set<String>)request.getAttribute("errors")).isEmpty()) {
            Set<String> errors = (Set<String>)request.getAttribute("errors");
            for(String err: errors) {
                colors.put(err, "red");
            }
        }
    %>

    <p style="color: <%=colors.get("name")%>"><b>First name:</b><br>
        <input name="name" type="text" size="40" value="<%=setFieldParam(request, "name")%>">
    </p>

    <p style="color: <%=colors.get("surname")%>"><b>Surname:</b><br>
        <input name="surname" type="text" size="40" value="<%=setFieldParam(request, "surname")%>">
    </p>

    <p style="color: <%=colors.get("email")%>"><b>E-Mail:</b><br>
        <input name="email" type="text" size="40" value="<%=setFieldParam(request, "email")%>">
    </p>

    <p style="color: <%=colors.get("password")%>"><b>Password:</b><br>
        <input name="password" type="password" size="40" value="<%=setFieldParam(request, "password")%>">
    </p>

    <p style="color: <%=colors.get("passwordConfirmation")%>"><b>Confirm password:</b><br>
        <input name="passwordConfirmation" type="password" size="40" value="<%=setFieldParam(request, "passwordConfirmation")%>">
    </p>

    <p style="color: <%=colors.get("birhdate")%>"><b>Birth date:</b><br>
        <input name="birhdate" type="text" size="40" value="<%=setFieldParam(request, "birhdate")%>">
    </p>

    <p><input type="submit" value="Save">
</form>
</body>
</html>