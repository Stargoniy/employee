package com.in6k.employees.persistance;

import java.io.File;

public class Config {
    private static final String WINDOWS_DIR = "F:\\Projects\\IdeaProjects\\employee\\users";
    private static final String LINUX_DIR = "/home/employee/IdeaProjects/employees/users/";
    public static String getUsersDir() {
        if (new File(LINUX_DIR).exists()) {
            return LINUX_DIR;
        }
        else {
            return WINDOWS_DIR;
        }
    }
}
