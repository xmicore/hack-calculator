package de.pmrd.hackcalculator.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

class Footer extends Composite<HorizontalLayout> {

  Footer() {
    getContent().add(new Label("© 2019 David König und Michael Kern"));
    getContent().setHeight("2.0em");
  }
}
