package de.pmrd.hackcalculator.example;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class ExamplePresenter {

    private final ExampleService service;

    private ExampleView view;

    public ExamplePresenter(ExampleService service) {
        this.service = service;
    }

    void setView(ExampleView view) {
        this.view = view;
    }

    @EventListener
    public void init(ExampleViewInitEvent event) {
        view.setText("Hello World at " + service.getDateTimeAsString());
    }

}
