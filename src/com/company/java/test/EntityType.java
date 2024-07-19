package com.company.java.test;

public enum EntityType {
    LISTING("L"),
    PRODUCT("P"),
    BRAND("B");

    private String code;

    private EntityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
