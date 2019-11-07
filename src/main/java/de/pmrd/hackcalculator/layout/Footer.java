package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

class Footer extends HorizontalLayout {

    Footer() {
        add(new Label("© 2019 Michael Kern"));
        setHeight("2.0em");
        // getStyle().set("background-color", "blue");
    }
}
