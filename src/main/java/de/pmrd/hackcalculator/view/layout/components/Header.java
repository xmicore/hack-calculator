package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;


public class Header extends Composite<FlexLayout> {

  @Override
  protected FlexLayout initContent() {
    FlexLayout content = new FlexLayout();
    content.setClassName("branding");
    Icon piggy = VaadinIcon.PIGGY_BANK.create();
    piggy.setClassName("piggy");
    content.add(piggy, new Label("Hack-Calculator"));
    content.setAlignSelf(Alignment.CENTER);
    return content;
  }
}
