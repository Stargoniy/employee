package com.in6k.employees.domain;

import com.in6k.employees.form.EmployeeForm;
import com.in6k.employees.persistance.Identifier;
import com.in6k.employees.persistance.ProviderFactory;

import java.io.File;
import java.io.IOException;

public class EmployeeModel implements Identifier {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String birhdate;

    ProviderFactory.ProviderType providerType;

    public EmployeeModel(EmployeeForm ef, ProviderFactory.ProviderType providerType) {
        name = ef.getName();
        surname = ef.getSurname();
        email = ef.getEmail();
        password = ef.getPassword();
        birhdate = ef.getBirhdate();

        this.providerType = providerType;
    }

    public EmployeeModel(ProviderFactory.ProviderType providerType) {
        this.providerType = providerType;
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

    public void save() throws IOException {
        ProviderFactory.create(providerType).save(this);
    }

    public void load(File file) throws IOException {
        EmployeeModel model = ProviderFactory.create(providerType).load(file);
        this.setName(model.getName());
        this.setSurname(model.getSurname());
        this.setEmail(model.getEmail());
        this.setPassword(model.getPassword());
        this.setBirhdate(model.getBirhdate());
    }

    @Override
    public String getIdentifier() {
        return this.getEmail();
    }
}

