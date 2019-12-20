package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class Footer extends Composite<FlexLayout> {

  @Override
  protected FlexLayout initContent() {
    FlexLayout content = new FlexLayout();
    // TODO can be replaced in later vaadin version with setFlexDircetion()
    content.getStyle().set("flex-direction", "column");
    content.setAlignItems(Alignment.CENTER);
    Label label = new Label(getTranslation("layout.footer.text"));
    label.setHeight("2em");
    content.add(label);
    return content;
  }
}
