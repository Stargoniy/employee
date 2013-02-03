package com.in6k.employees.form;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

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

    public Set<String> validate() {
        Set<String> result = new ConcurrentSkipListSet<String>();

        if (!isValidValue(this.getName(), VALID_NAME_REGEXP)) {
            result.add("name");
        }
        if (!isValidValue(this.getSurname(), VALID_SURNAME_REGEXP)) {
            result.add("surname");
        }
        if (!isValidValue(this.getEmail(), VALID_EMAIL_REGEXP)) {
            result.add("email");
        }
        if (!isValidValue(this.getPassword(), VALID_PASS_REGEXP)) {
            result.add("password");
        }
        if (!isValidValue(this.getPasswordConfirmation(), VALID_CONFPASS_REGEXP)) {
            result.add("passwordConfirmation");
        }
        if (!isValidValue(this.getBirhdate(), VALID_BIRTHDATE_REGEXP)) {
            result.add("birhdate");
        }
        return result;
    }

    private boolean isValidValue(String value, String pattern) {
        if (value == null) {
            return false;
        }
        return value.matches(pattern);
    }
}
