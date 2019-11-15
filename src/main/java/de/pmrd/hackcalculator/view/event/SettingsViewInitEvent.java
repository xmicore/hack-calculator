package de.pmrd.hackcalculator.view.event;

import org.springframework.context.ApplicationEvent;

public class SettingsViewInitEvent extends ApplicationEvent {

    public SettingsViewInitEvent(Object source) {
        super(source);
    }

}
