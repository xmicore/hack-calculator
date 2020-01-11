package de.pmrd.hackcalculator.view.layout.components;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import de.pmrd.hackcalculator.view.CalculatorViewImpl;
import de.pmrd.hackcalculator.view.HistoryViewImpl;

public class Menu extends Composite<Tabs> {

  @Override
  protected Tabs initContent() {
    final Tab calculationTab = new Tab(new RouterLink("Berechnung", CalculatorViewImpl.class));
    final Tab historyTab = new Tab(new RouterLink("Historie", HistoryViewImpl.class));
    final Tabs tabs = new Tabs(calculationTab, historyTab);
    tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
    return tabs;
  }
}
