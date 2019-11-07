package de.pmrd.hackcalculator.example;

import org.springframework.context.ApplicationEvent;

public class ExampleViewInitEvent extends ApplicationEvent {

    public ExampleViewInitEvent(Object source) {
        super(source);
    }
}
