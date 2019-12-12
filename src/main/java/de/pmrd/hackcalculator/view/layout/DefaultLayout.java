package de.pmrd.hackcalculator.view.layout;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import de.pmrd.hackcalculator.view.layout.components.Footer;
import de.pmrd.hackcalculator.view.layout.components.Header;
import de.pmrd.hackcalculator.view.layout.components.Menu;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class DefaultLayout extends Composite<VerticalLayout>
    implements HasComponents, RouterLayout {

  private Div contentWrapper = new Div();

  @Override
  public void showRouterLayoutContent(HasElement content) {
    contentWrapper.getElement().appendChild(content.getElement());
  }

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    content.setSizeFull();

    Header header = new Header();
    content.setHorizontalComponentAlignment(Alignment.CENTER, header);
    content.add(header);

    Menu menu = new Menu();
    content.setHorizontalComponentAlignment(Alignment.CENTER, menu);
    content.add(menu);

    content.setFlexGrow(1, contentWrapper);
    content.setHorizontalComponentAlignment(Alignment.STRETCH, contentWrapper);
    content.add(contentWrapper);

    Footer footer = new Footer();
    content.setHorizontalComponentAlignment(Alignment.CENTER, footer);
    content.add(footer);

    return content;
  }
}
