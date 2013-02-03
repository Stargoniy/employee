package com.in6k.employees.persistance;

import java.io.File;

public class ProviderFactory {
    public enum ProviderType { XML, DB }

    public static DataProvider create(ProviderType type) {
        if (type == ProviderType.XML) return new XmlProvider(Config.getUsersDir());
        if (type == ProviderType.DB) return new DbProvider();
        return null;
    }
}
