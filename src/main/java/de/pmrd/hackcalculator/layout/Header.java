package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

class Header extends Composite<VerticalLayout> {

  Header() {
    getContent().add(new Label("Hack Calculator"));
    getContent().setSizeFull();
    getContent().setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    getContent().setHeight("2.0em");
    getContent().setMargin(true);
  }
}
