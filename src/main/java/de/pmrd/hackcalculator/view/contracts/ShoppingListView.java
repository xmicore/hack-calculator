package de.pmrd.hackcalculator.view.contracts;

import de.pmrd.hackcalculator.view.model.ShoppingListViewModel;

public interface ShoppingListView {

  String VIEW_NAME = "shoppingList";

  void setModel(ShoppingListViewModel model);
}
