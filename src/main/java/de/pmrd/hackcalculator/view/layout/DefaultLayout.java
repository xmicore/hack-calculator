package de.pmrd.hackcalculator.view.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import de.pmrd.hackcalculator.view.layout.components.Header;
import de.pmrd.hackcalculator.view.layout.components.Menu;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class DefaultLayout extends AppLayout {

  public DefaultLayout() {
    initContent();
  }

  private void initContent() {
    addToNavbar(new Header());
    addToNavbar(true, new Menu());
  }
}
