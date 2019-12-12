package de.pmrd.hackcalculator.view.model;

import java.util.List;

public class ShoppingListViewModel {

  private List<ShoppingListViewItem> shoppingListItems;

  public List<ShoppingListViewItem> getShoppingListItems() {
    return shoppingListItems;
  }

  public void setShoppingListItems(List<ShoppingListViewItem> shoppingListItems) {
    this.shoppingListItems = shoppingListItems;
  }
}
