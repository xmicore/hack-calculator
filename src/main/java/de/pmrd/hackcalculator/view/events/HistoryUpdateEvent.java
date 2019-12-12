package de.pmrd.hackcalculator.view.events;

import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import org.springframework.context.ApplicationEvent;

public class HistoryUpdateEvent extends ApplicationEvent {

  private HistoryViewItem data;

  public HistoryUpdateEvent(Object source, HistoryViewItem data) {
    super(source);
    this.data = data;
  }

  public HistoryViewItem getItem() {
    return data;
  }
}
