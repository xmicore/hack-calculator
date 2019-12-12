package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

public class HistoryEditViewInitEvent extends ApplicationEvent {

  public HistoryEditViewInitEvent(Object source) {
    super(source);
  }
}
