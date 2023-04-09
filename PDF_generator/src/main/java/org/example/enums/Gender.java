package org.example.enums;


public enum Gender {
    MALE("МУЖ."),
    FEMALE("ЖЕН.");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }
}
