package com.in6k.employees.servlet;

import com.in6k.employees.User;
import com.in6k.employees.domain.EmployeeModel;
import com.in6k.employees.form.EmployeeForm;
import com.in6k.employees.persistance.ProviderFactory;
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
import java.util.Map;

public class EmployeeFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeForm employeeForm = new EmployeeForm(req.getParameter("name"), req.getParameter("surname"), req.getParameter("email"), req.getParameter("password"), req.getParameter("passwordConfirmation"), req.getParameter("birhdate"));

        Map<String, String> errors = employeeForm.validate();
        boolean HAS_ERROR = !errors.isEmpty();

        if (HAS_ERROR) {
            req.setAttribute("from", employeeForm);
            req.setAttribute("errors", errors);
            return;
        }

        EmployeeModel em = new EmployeeModel(employeeForm, ProviderFactory.ProviderType.XML);
        em.save();

        resp.sendRedirect("/userlist");
    }
}
