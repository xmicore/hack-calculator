package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

class Header extends VerticalLayout {

    Header() {
        add(new Label("Hack Calculator"));
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setHeight("2.0em");
        setMargin(true);
    }
}
