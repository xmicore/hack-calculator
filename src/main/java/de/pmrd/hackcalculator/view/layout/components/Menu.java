package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import de.pmrd.hackcalculator.view.CalculatorViewImpl;
import de.pmrd.hackcalculator.view.HistoryViewImpl;

public class Menu extends Composite<HorizontalLayout> {

  @Override
  protected HorizontalLayout initContent() {
    HorizontalLayout content = new HorizontalLayout();
    content.add(new RouterLink("Berechnung", CalculatorViewImpl.class));
    content.add(new RouterLink("Historie", HistoryViewImpl.class));
    return content;
  }
}
