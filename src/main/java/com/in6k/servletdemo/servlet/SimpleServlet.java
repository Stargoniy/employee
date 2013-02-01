package com.in6k.servletdemo.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {
    protected final Log logger = LogFactory.getLog(getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.print("<h1 style = 'color: red'>Hello, " + name + "!</h1>");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String surName = req.getParameter("surname");
//        String email = req.getParameter("email");
//        String pass = req.getParameter("pass");
//        String confpass = req.getParameter("confpass");
//        String birhdate = req.getParameter("birhdate");

        logger.info("name = " + req.getParameter("name")
                + "; surName = " + req.getParameter("surname")
                + "; email = " + req.getParameter("email")
                + "; pass = " + req.getParameter("pass")
                + "; confpass = " + req.getParameter("confpass")
                + "; birhdate = " + req.getParameter("birhdate"));

        resp.sendRedirect("");
    }
}
