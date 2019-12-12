package de.pmrd.hackcalculator.view.contracts;

import de.pmrd.hackcalculator.view.model.ShoppingListViewItem;
import java.util.Collection;

public interface ShoppingListView {

  String VIEW_NAME = "shoppingList";

  void setItems(Collection<ShoppingListViewItem> items);
}
