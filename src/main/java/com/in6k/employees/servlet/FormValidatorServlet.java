package com.in6k.employees.servlet;

import com.in6k.employees.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormValidatorServlet extends HttpServlet {
    protected final Log logger = LogFactory.getLog(getClass());
    private static final String VALID_NAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_SURNAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_EMAIL_REGEXP = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$";
    private static final String VALID_PASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_CONFPASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_BIRTHDATE_REGEXP = "^[0-9]+-[0-9]+-[0-9]+$";

    private List<String> errors = new ArrayList<String>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("name = " + req.getParameter("name")
                + "; surName = " + req.getParameter("surname")
                + "; email = " + req.getParameter("email")
                + "; pass = " + req.getParameter("pass")
                + "; confpass = " + req.getParameter("confpass")
                + "; birhdate = " + req.getParameter("birhdate"));

        if (isValid(req)) {
            User user = new User(req.getParameter("name"), req.getParameter("surname"), req.getParameter("email"), req.getParameter("pass"), req.getParameter("birhdate"));
//            User user = new User();
//            user.setName(req.getParameter("name"));
//            user.setSurName(req.getParameter("surname"));
//            user.setEmail(req.getParameter("email"));
//            user.setPass(req.getParameter("pass"));
//            user.setBirhdate(req.getParameter("birhdate"));

            FileOutputStream fos = new FileOutputStream("/home/employee/IdeaProjects/employees/users/" + req.getParameter("email") + ".xml");
            XMLEncoder xenc = new XMLEncoder(fos);
            xenc.writeObject(user);
            xenc.flush();
            xenc.close();
            fos.close();

            resp.sendRedirect("/userlist");
        } else {
            req.setAttribute("valid", errors);
            req.getRequestDispatcher("/index.jsp").include(req, resp);
//            FormServlet formServlet = new FormServlet();
//            formServlet.doGet(req, resp);
        }
    }

    private boolean isValid(HttpServletRequest request) {
        errors.clear();
        boolean result = true;
        if (!isValidValue(request, "name", VALID_NAME_REGEXP)) {
            result = false;
        }
        if (!isValidValue(request, "surname", VALID_SURNAME_REGEXP)) {
            result = false;
        }
        if (!isValidValue(request, "email", VALID_EMAIL_REGEXP)) {
            result = false;
        }
        if (!isValidValue(request, "pass", VALID_PASS_REGEXP)) {
            result = false;
        } else {
            if (!isValidValue(request, "confpass", VALID_CONFPASS_REGEXP)) {
                result = false;
            } else {
                if (!request.getParameter("pass").equals(request.getParameter("confpass"))) {
                    result = false;
                    errors.add("confpass");
                }
            }
        }
        if (!isValidValue(request, "birhdate", VALID_BIRTHDATE_REGEXP)) {
            result = false;
        }
        return result;
    }

    private boolean isValidValue(HttpServletRequest request, String param, String pattern) {
        if (!request.getParameter(param).matches(pattern)) {
            errors.add(param);
            if (param.equals("pass")) {
                errors.add("confpass");
            }
            return false;
        } else {
            return true;
        }
    }
}
