package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

class Header extends HorizontalLayout {

    Header() {
        add(new Label("Hack Calculator"));
        setSizeFull();
        setHeight("2.0em");
        // getStyle().set("background-color", "red");
    }
}
