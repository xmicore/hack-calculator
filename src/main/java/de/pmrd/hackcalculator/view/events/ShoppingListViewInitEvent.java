package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

public class ShoppingListViewInitEvent extends ApplicationEvent {

  private final String uuid;

  public ShoppingListViewInitEvent(Object source) {
    this(source, "");
  }

  public ShoppingListViewInitEvent(Object source, String uuid) {
    super(source);
    this.uuid = uuid;
  }

  public String getUuid() {
    return this.uuid;
  }
}
