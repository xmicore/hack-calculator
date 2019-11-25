package de.pmrd.hackcalculator.history;

import org.springframework.context.ApplicationEvent;

class HistoryViewInitEvent extends ApplicationEvent {

  HistoryViewInitEvent(Object source) {
    super(source);
  }
}
