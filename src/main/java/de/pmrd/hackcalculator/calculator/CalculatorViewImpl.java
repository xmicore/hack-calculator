package de.pmrd.hackcalculator.calculator;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = CalculatorViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("Kalkulierung")
public class CalculatorViewImpl extends VerticalLayout implements CalculatorView, AfterNavigationObserver {

    static final String VIEW_NAME = "calculator";

    private final ApplicationEventPublisher eventPublisher;

    public CalculatorViewImpl(CalculatorPresenter presenter, ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
        init();
    }

    private void init() {
        add(new Label("Calculator coming soon."));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        eventPublisher.publishEvent(new CalculatorViewInitEvent(this));
    }

}

