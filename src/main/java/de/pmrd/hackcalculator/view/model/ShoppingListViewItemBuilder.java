package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;

public class ShoppingListViewItemBuilder {
    private String ingredient;
    private BigDecimal quantity;
    private QuantityUnit quantityUnit;

    public ShoppingListViewItemBuilder setIngredient(String ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public ShoppingListViewItemBuilder setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public ShoppingListViewItemBuilder setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
        return this;
    }

    public ShoppingListViewItem createItem() {
        return new ShoppingListViewItem(ingredient, quantity, quantityUnit);
    }
}