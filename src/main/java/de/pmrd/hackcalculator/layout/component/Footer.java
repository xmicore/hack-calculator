package de.pmrd.hackcalculator.layout.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Footer extends HorizontalLayout {

    public Footer() {
        add(new Label("© 2019 David König und Michael Kern"));
        setHeight("2.0em");
    }
}
