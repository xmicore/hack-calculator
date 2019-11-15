package de.pmrd.hackcalculator.layout;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import de.pmrd.hackcalculator.layout.component.Footer;
import de.pmrd.hackcalculator.layout.component.Header;
import de.pmrd.hackcalculator.layout.component.Menu;

public class DefaultLayout extends Composite<VerticalLayout> implements HasComponents, RouterLayout {

    private Div contentWrapper = new Div();

    public DefaultLayout() {
        getContent().setSizeFull();

        Header header = new Header();
        getContent().setHorizontalComponentAlignment(Alignment.CENTER, header);
        add(header);

        Menu menu = new Menu();
        getContent().setHorizontalComponentAlignment(Alignment.CENTER, menu);
        add(menu);

        getContent().setFlexGrow(1, contentWrapper);
        getContent().setHorizontalComponentAlignment(Alignment.STRETCH, contentWrapper);
        add(contentWrapper);

        Footer footer = new Footer();
        getContent().setHorizontalComponentAlignment(Alignment.CENTER, footer);
        add(footer);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        contentWrapper.getElement().appendChild(content.getElement());
    }

}
