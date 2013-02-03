package com.in6k.employees.persistance;


import com.in6k.employees.domain.EmployeeModel;

import java.io.File;
import java.io.FileNotFoundException;

public class DbProvider implements DataProvider {
    @Override
    public void save(Identifier identifier) {
    }

    @Override
    public EmployeeModel load(File file) throws FileNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
