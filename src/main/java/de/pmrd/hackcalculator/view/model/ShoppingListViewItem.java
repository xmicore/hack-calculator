package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;

public class ShoppingListViewItem {

  private String ingredient;
  private BigDecimal quantity;
  private QuantityUnit quantityUnit;

  public ShoppingListViewItem(String ingredient, BigDecimal quantity, QuantityUnit quantityUnit) {
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
