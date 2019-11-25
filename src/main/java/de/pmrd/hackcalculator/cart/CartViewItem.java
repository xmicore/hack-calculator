package de.pmrd.hackcalculator.cart;

import java.math.BigDecimal;

class CartViewItem {

    private String ingredient;
    private BigDecimal quantity;
    private QuantityUnit quantityUnit;

    public CartViewItem(String ingredient, BigDecimal quantity, QuantityUnit quantityUnit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
    }
}
