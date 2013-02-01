package com.in6k.employees.form;

import java.util.Map;

public class EmployeeForm {
    private static final String VALID_NAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_SURNAME_REGEXP = "[a-zA-Z]{2,}";
    private static final String VALID_EMAIL_REGEXP = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$";
    private static final String VALID_PASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_CONFPASS_REGEXP = "[a-zA-Zа-яА-Я0-9]{1,}";
    private static final String VALID_BIRTHDATE_REGEXP = "^[0-9]+-[0-9]+-[0-9]+$";

    String name;
    String surname;
    String email;
    String password;
    String passwordConfirmation;
    String birhdate;

    public EmployeeForm() {
    }

    public EmployeeForm(String name, String surname, String email, String password, String passwordConfirmation, String birhdate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.birhdate = birhdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirhdate() {
        return birhdate;
    }

    public void setBirhdate(String birhdate) {
        this.birhdate = birhdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Map<String, String> validate() {
        return null;
    }

    //    private boolean isValid(HttpServletRequest request) {
//        errors.clear();
//        boolean result = true;
//        if (!isValidValue(request, "name", VALID_NAME_REGEXP)) {
//            result = false;
//        }
//        if (!isValidValue(request, "surname", VALID_SURNAME_REGEXP)) {
//            result = false;
//        }
//        if (!isValidValue(request, "email", VALID_EMAIL_REGEXP)) {
//            result = false;
//        }
//        if (!isValidValue(request, "pass", VALID_PASS_REGEXP)) {
//            result = false;
//        } else {
//            if (!isValidValue(request, "confpass", VALID_CONFPASS_REGEXP)) {
//                result = false;
//            } else {
//                if (!request.getParameter("pass").equals(request.getParameter("confpass"))) {
//                    result = false;
//                    errors.add("confpass");
//                }
//            }
//        }
//        if (!isValidValue(request, "birhdate", VALID_BIRTHDATE_REGEXP)) {
//            result = false;
//        }
//        return result;
//    }
//
//    private boolean isValidValue(HttpServletRequest request, String param, String pattern) {
//        if (!request.getParameter(param).matches(pattern)) {
//            errors.add(param);
//            if (param.equals("pass")) {
//                errors.add("confpass");
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }
}
