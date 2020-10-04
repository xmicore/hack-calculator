package de.pmrd.hackcalculator.view.model;

public enum QuantityUnit {

    CHUNK("quantityUnit.chunk"),
    GRAM("quantityUnit.gram");

    private final String key;

    QuantityUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
