package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

public class ShoppingListViewBeforeInitEvent extends ApplicationEvent {

  private final String uuid;

  public ShoppingListViewBeforeInitEvent(Object source, String uuid) {
    super(source);
    this.uuid = uuid;
  }

  public String getUuid() {
    return this.uuid;
  }
}
