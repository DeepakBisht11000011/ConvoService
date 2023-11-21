package com.deepweb.convo.constants;

public enum DurationUnit {
    MIN("min"), SEASON("Season");
    public final String label;

    DurationUnit(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
