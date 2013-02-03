package com.in6k.employees.servlet;

import com.in6k.employees.User;
import com.in6k.employees.persistance.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File userFile = new File(Config.getUsersDir() + req.getParameter("email") + ".xml");
        FileInputStream fis = new FileInputStream(userFile);
        XMLDecoder xmlDecoder = new XMLDecoder(fis);
        User user = (User) xmlDecoder.readObject();

        req.setAttribute("user", user);
        req.getRequestDispatcher("/employeeform.jsp").include(req, resp);
    }
}
