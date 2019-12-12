package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Header extends Composite<VerticalLayout> {

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    Icon piggy = VaadinIcon.PIGGY_BANK.create();
    piggy.setColor("#FF69B4");
    piggy.setSize("2em");
    content.add(new H1(new Label("Hack "), piggy, new Label(" Calculator")));
    content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    return content;
  }
}
