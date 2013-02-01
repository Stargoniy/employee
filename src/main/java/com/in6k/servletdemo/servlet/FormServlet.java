package com.in6k.servletdemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String form;
        if (req.getAttribute("valid") != null && !((List<String>)req.getAttribute("valid")).isEmpty()) {
            List<String> notCorrectValues = (List<String>)req.getAttribute("valid");
            Map<String, String> colors = new HashMap<String, String>();
            colors.put("name", "black");
            colors.put("surname", "black");
            colors.put("email", "black");
            colors.put("pass", "black");
            colors.put("confpass", "black");
            colors.put("birhdate", "black");
            for(String s: notCorrectValues) {
                colors.put(s, "red");
            }
            form = "<html>\n" +
                    "<head>\n" +
                    "    <title></title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <form name=\"test\" method=\"post\" action=\"formvalidator\">\n" +
                    "        <p style='color:" + colors.get("name") + "'><b>First name:</b><br>\n" +
                    "            <input name=\"name\" type=\"text\" size=\"40\" value=" + checkValue(req.getParameter("name")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p style='color:" + colors.get("surname") + "'><b>Surname:</b><br>\n" +
                    "            <input name=\"surname\" type=\"text\" size=\"40\" value=" + checkValue(req.getParameter("surname")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p style='color:" + colors.get("email") + "'><b>E-Mail:</b><br>\n" +
                    "            <input name=\"email\" type=\"text\" size=\"40\" value=" + checkValue(req.getParameter("email")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p style='color:" + colors.get("pass") + "'><b>Password:</b><br>\n" +
                    "            <input name=\"pass\" type=\"password\" size=\"40\" value=" + checkValue(req.getParameter("pass")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p style='color:" + colors.get("confpass") + "'><b>Confirm password:</b><br>\n" +
                    "            <input name=\"confpass\" type=\"password\" size=\"40\" value=" + checkValue(req.getParameter("confpass")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p style='color:" + colors.get("birhdate") + "'><b>Birth date:</b><br>\n" +
                    "            <input name=\"birhdate\" type=\"text\" size=\"40\" value=" + checkValue(req.getParameter("birhdate")) + ">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><input type=\"submit\" value=\"Save\">\n" +
                    "    </form>\n" +
                    "</body>\n" +
                    "</html>";
        } else {
            form = "<html>\n" +
                    "<head>\n" +
                    "    <title></title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <form name=\"test\" method=\"post\" action=\"formvalidator\">\n" +
                    "        <p><b>First name:</b><br>\n" +
                    "            <input name=\"name\" type=\"text\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><b>Surname:</b><br>\n" +
                    "            <input name=\"surname\" type=\"text\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><b>E-Mail:</b><br>\n" +
                    "            <input name=\"email\" type=\"text\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><b>Password:</b><br>\n" +
                    "            <input name=\"pass\" type=\"password\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><b>Confirm password:</b><br>\n" +
                    "            <input name=\"confpass\" type=\"password\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><b>Birth date:</b><br>\n" +
                    "            <input name=\"birhdate\" type=\"text\" size=\"40\">\n" +
                    "        </p>\n" +
                    "\n" +
                    "        <p><input type=\"submit\" value=\"Save\">\n" +
                    "    </form>\n" +
                    "</body>\n" +
                    "</html>";
        }
        PrintWriter pw = resp.getWriter();
        pw.print(form);
        pw.close();

    }

    private String checkValue(String value) {
        return value != null ? value : "";
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        FormValidatorServlet formValidatorServlet = new FormValidatorServlet();
//        formValidatorServlet.doPost(req, resp);
//    }
}
