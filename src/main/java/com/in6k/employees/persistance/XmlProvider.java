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
        File file = new File(path + identifier.getIdentifier() + ".xml");
        FileOutputStream fos = new FileOutputStream(file);
        XMLEncoder xe = new XMLEncoder(fos);
        xe.writeObject(identifier);
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
