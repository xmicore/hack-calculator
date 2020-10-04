package de.pmrd.hackcalculator.view.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import de.pmrd.hackcalculator.view.layout.components.Header;
import de.pmrd.hackcalculator.view.layout.components.Menu;

import java.util.Optional;

@Theme(Lumo.class)
public class DefaultLayout extends AppLayout {

    private Menu menu;

    public DefaultLayout() {
        initContent();
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        final Tabs menuTabs = menu.getContent();
        final String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
        final Optional<Component> selectedTab = getSelectedTab(menuTabs, target);
        selectedTab.ifPresent(tab -> menuTabs.setSelectedTab((Tab) tab));
    }

    private void initContent() {
        menu = new Menu();
        addToNavbar(new Header());
        addToNavbar(true, menu);
    }

    private Optional<Component> getSelectedTab(Tabs menuTabs, String target) {
        return menuTabs
                .getChildren()
                .filter(
                        tab -> {
                            Component child = tab.getChildren().findFirst().orElse(new RouterLink());
                            return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
                        })
                .findFirst();
    }
}
