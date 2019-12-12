package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Footer extends Composite<HorizontalLayout> {

  @Override
  protected HorizontalLayout initContent() {
    HorizontalLayout content = new HorizontalLayout();
    content.add(new Label("David und Michael wünschen Frohes Hacken!"));
    content.setHeight("2.0em");
    return content;
  }
}
