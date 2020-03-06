package com.databaserelationship.dbrelationonetomany.resources.enums;

public enum Gender {

    MALE(1), FEMALE(2), OTHERS(3);

    int value;
    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
