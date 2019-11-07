package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import de.pmrd.hackcalculator.calculator.CalculatorViewImpl;
import de.pmrd.hackcalculator.settings.SettingsViewImpl;

class Menu extends Composite<HorizontalLayout> implements HasComponents {

    Menu() {
        add(new RouterLink("Kalkulierung", CalculatorViewImpl.class));
        add(new RouterLink("Einstellungen", SettingsViewImpl.class));
    }
}
