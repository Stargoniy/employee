package com.in6k.employees.persistance;

import com.in6k.employees.domain.EmployeeModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataProvider {
    void save(Identifier model) throws IOException;

    EmployeeModel load(File file) throws FileNotFoundException;
}
