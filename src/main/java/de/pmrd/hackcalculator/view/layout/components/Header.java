package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Header extends Composite<VerticalLayout> {

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    content.add(new H1("Hack Calculator"));
    content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    return content;
  }
}
