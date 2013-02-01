package com.in6k.employees.domain;

import com.in6k.employees.form.EmployeeForm;
import com.in6k.employees.persistance.Identifier;
import com.in6k.employees.persistance.ProviderFactory;

import java.io.IOException;

public class EmployeeModel implements Identifier {
    String name;
    String email;
    String password;

    ProviderFactory.ProviderType providerType;

    public EmployeeModel(EmployeeForm ef, ProviderFactory.ProviderType providerType) {
        name = ef.getName();
        email = ef.getEmail();
        password = ef.getPassword();

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

    public void save() throws IOException {
        ProviderFactory.create(providerType).save(this);
    }

    @Override
    public String getIdentifier() {
        return this.getEmail();
    }
}

