package de.pmrd.hackcalculator.example;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = ExampleViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("Beispiel")
public class ExampleViewImpl extends VerticalLayout implements ExampleView, AfterNavigationObserver {

    static final String VIEW_NAME = "example";

    private final ApplicationEventPublisher eventPublisher;

    private Label label;

    public ExampleViewImpl(ExamplePresenter presenter, ApplicationEventPublisher eventPublisher) {
        presenter.setView(this);
        this.eventPublisher = eventPublisher;
        init();
    }

    private void init() {
        this.label = new Label();
        add(this.label);
    }

    @Override
    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        eventPublisher.publishEvent(new ExampleViewInitEvent(this));
    }

}
