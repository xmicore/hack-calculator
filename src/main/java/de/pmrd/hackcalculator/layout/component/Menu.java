package de.pmrd.hackcalculator.layout.component;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import de.pmrd.hackcalculator.view.impl.CalculatorViewImpl;
import de.pmrd.hackcalculator.view.impl.SettingsViewImpl;

public class Menu extends Composite<HorizontalLayout> implements HasComponents {

    public Menu() {
        add(new RouterLink("Berechnung", CalculatorViewImpl.class));
        add(new RouterLink("Einstellungen", SettingsViewImpl.class));
    }
}
