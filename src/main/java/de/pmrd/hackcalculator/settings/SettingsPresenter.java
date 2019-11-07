package de.pmrd.hackcalculator.settings;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class SettingsPresenter {

    private SettingsView view;

    void setView(SettingsView view) {
        this.view = view;
    }

}
