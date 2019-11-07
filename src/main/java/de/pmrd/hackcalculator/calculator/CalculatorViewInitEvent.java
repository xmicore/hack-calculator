package de.pmrd.hackcalculator.calculator;

import org.springframework.context.ApplicationEvent;

public class CalculatorViewInitEvent extends ApplicationEvent {

    public CalculatorViewInitEvent(Object source) {
        super(source);
    }
}
