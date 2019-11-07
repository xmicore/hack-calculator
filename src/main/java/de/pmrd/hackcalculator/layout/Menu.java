package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import de.pmrd.hackcalculator.example.ExampleViewImpl;
import de.pmrd.hackcalculator.settings.SettingsViewImpl;

class Menu extends Composite<HorizontalLayout> implements HasComponents {

    Menu() {
        add(new RouterLink("Beispiel", ExampleViewImpl.class));
        add(new RouterLink("Einstellungen", SettingsViewImpl.class));
        // getContent().getStyle().set("background-color", "yellow");
    }
}
