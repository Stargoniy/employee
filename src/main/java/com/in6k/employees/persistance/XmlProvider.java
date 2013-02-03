package com.in6k.employees.persistance;

import com.in6k.employees.domain.EmployeeModel;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlProvider implements DataProvider {

    protected String path;

    public XmlProvider(String path) {
        this.path = path;
    }

    @Override
    public void save(Identifier identifier) throws IOException {
        FileOutputStream fos = new FileOutputStream(path + "/" + identifier.getIdentifier() + ".xml");
        XMLEncoder xe = new XMLEncoder(fos);
        xe.writeObject(this);
        xe.flush();
        xe.close();
        fos.close();
    }

    @Override
    public EmployeeModel load(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        XMLDecoder xmlDecoder = new XMLDecoder(fis);
        return (EmployeeModel) xmlDecoder.readObject();
    }
}
