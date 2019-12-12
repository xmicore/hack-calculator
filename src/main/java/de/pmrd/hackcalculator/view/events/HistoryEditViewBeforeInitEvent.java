package de.pmrd.hackcalculator.view.events;

import java.util.UUID;
import org.springframework.context.ApplicationEvent;

public class HistoryEditViewBeforeInitEvent extends ApplicationEvent {

  private UUID itemId;

  public HistoryEditViewBeforeInitEvent(Object source, UUID itemId) {
    super(source);
    this.itemId = itemId;
  }

  public UUID getItemId() {
    return itemId;
  }
}
