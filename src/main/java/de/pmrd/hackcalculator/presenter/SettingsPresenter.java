package de.pmrd.hackcalculator.presenter;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.view.SettingsView;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class SettingsPresenter {

    private SettingsView view;

    public void setView(SettingsView view) {
        this.view = view;
    }

}
