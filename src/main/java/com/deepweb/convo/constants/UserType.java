package com.deepweb.convo.constants;

public enum UserType {
    DIRECTOR("Director"), CAST("Cast");
    private final String label;

    UserType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
