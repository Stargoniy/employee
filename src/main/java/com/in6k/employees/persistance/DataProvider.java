package com.in6k.employees.persistance;

import java.io.IOException;

public interface DataProvider {
    void save(Identifier model) throws IOException;
}
