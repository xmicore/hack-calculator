package de.pmrd.hackcalculator.settings;

import org.springframework.context.ApplicationEvent;

public class SettingsViewInitEvent extends ApplicationEvent {

    public SettingsViewInitEvent(Object source) {
        super(source);
    }

}
