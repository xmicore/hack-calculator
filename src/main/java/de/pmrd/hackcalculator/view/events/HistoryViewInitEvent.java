package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

public class HistoryViewInitEvent extends ApplicationEvent {

  public HistoryViewInitEvent(Object source) {
    super(source);
  }
}
