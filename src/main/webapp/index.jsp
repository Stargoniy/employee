<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.in6k.employees.User" %>

<html>
<html>
<head>
    <title></title>
</head>
<body>
<form name="test" method="post" action="formvalidator">
    <%!
        private String checkValue(String value) {
            return value != null ? value : "";
        }
        private String setFieldParam(HttpServletRequest request, String value) {
//            request.getParameter(value);
            String result = "";
            User user;
            if (request.getAttribute("user") != null) {
                user = (User)request.getAttribute("user");
                if (value.equals("name")) {
                    result = user.getName();
                } else if (value.equals("surname")) {
                    result = user.getSurName();
                } else if (value.equals("email")) {
                    result = user.getEmail();
                } else if (value.equals("pass") || value.equals("confpass")) {
                    result = user.getPass();
                } else if (value.equals("birhdate")) {
                    result = user.getBirhdate();
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
        colors.put("pass", "black");
        colors.put("confpass", "black");
        colors.put("birhdate", "black");

        if (request.getAttribute("valid") != null && !((List<String>)request.getAttribute("valid")).isEmpty()) {
            List<String> notCorrectValues = (List<String>)request.getAttribute("valid");
            for(String s: notCorrectValues) {
                colors.put(s, "red");
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

    <p style="color: <%=colors.get("pass")%>"><b>Password:</b><br>
        <input name="pass" type="password" size="40" value="<%=setFieldParam(request, "pass")%>">
    </p>

    <p style="color: <%=colors.get("confpass")%>"><b>Confirm password:</b><br>
        <input name="confpass" type="password" size="40" value="<%=setFieldParam(request, "confpass")%>">
    </p>

    <p style="color: <%=colors.get("birhdate")%>"><b>Birth date:</b><br>
        <input name="birhdate" type="text" size="40" value="<%=setFieldParam(request, "birhdate")%>">
    </p>

    <p><input type="submit" value="Save">
</form>
</body>
</html>