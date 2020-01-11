package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class Header extends Composite<FlexLayout> {

  @Override
  protected FlexLayout initContent() {
    FlexLayout content = new FlexLayout();
    Icon piggy = VaadinIcon.PIGGY_BANK.create();
    piggy.setColor("#FF69B4");
    piggy.setSize("1em");
    content.add(new Span(new Label("Hack "), piggy, new Label(" Calculator")));
    content.setAlignSelf(Alignment.CENTER);
    return content;
  }
}
