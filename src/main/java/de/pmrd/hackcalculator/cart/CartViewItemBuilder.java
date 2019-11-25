package de.pmrd.hackcalculator.cart;

import java.math.BigDecimal;

public class CartViewItemBuilder {
    private String ingredient;
    private BigDecimal quantity;
    private QuantityUnit quantityUnit;

    public CartViewItemBuilder setIngredient(String ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public CartViewItemBuilder setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public CartViewItemBuilder setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
        return this;
    }

    public CartViewItem createCartViewItem() {
        return new CartViewItem(ingredient, quantity, quantityUnit);
    }
}