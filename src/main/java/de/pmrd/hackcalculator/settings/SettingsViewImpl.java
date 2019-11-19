package de.pmrd.hackcalculator.settings;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = SettingsViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("Einstellungen")
public class SettingsViewImpl extends VerticalLayout implements SettingsView, AfterNavigationObserver {

    static final String VIEW_NAME = "settings";

    private final ApplicationEventPublisher eventPublisher;

    public SettingsViewImpl(SettingsPresenter presenter, ApplicationEventPublisher eventPublisher) {
        presenter.setView(this);
        this.eventPublisher = eventPublisher;
        init();
    }

    private void init() {
        // TODO create components for settings
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        eventPublisher.publishEvent(new SettingsViewInitEvent(this));
    }
}
