package de.pmrd.hackcalculator.layout.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Header extends VerticalLayout {

    public Header() {
        add(new Label("Hack Calculator"));
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setHeight("2.0em");
        setMargin(true);
    }
}
