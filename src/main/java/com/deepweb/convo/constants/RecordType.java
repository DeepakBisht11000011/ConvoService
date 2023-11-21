package com.deepweb.convo.constants;

public enum RecordType {
    MOVIE("Movie"),TV_Show("TV Show");
    public final String label;

    RecordType(String label){
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
