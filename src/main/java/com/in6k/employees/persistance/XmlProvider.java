package com.in6k.employees.persistance;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

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
}
