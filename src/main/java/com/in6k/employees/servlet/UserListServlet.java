package com.in6k.employees.servlet;

import com.in6k.employees.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File[] usersFiles = new File("/home/employee/IdeaProjects/employees/users/").listFiles();
        List<User> users = new ArrayList<User>();


        for (File f: usersFiles) {
            FileInputStream fis = new FileInputStream(f);
            XMLDecoder xmlDecoder = new XMLDecoder(fis);
            users.add((User) xmlDecoder.readObject());
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/userlist.jsp").include(req, resp);
    }
}
