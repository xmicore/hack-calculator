package de.pmrd.hackcalculator.history;

import org.springframework.context.ApplicationEvent;

public class HistoryViewInitEvent extends ApplicationEvent {

  public HistoryViewInitEvent(Object source) {
    super(source);
  }
}
