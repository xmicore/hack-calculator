package de.pmrd.hackcalculator.view.events;

import org.springframework.context.ApplicationEvent;

public class CalculatorViewInitEvent extends ApplicationEvent {

  public CalculatorViewInitEvent(Object source) {
    super(source);
  }
}
