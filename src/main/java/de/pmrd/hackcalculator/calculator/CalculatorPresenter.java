package de.pmrd.hackcalculator.calculator;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.example.ExampleViewInitEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class CalculatorPresenter {

    private final CalculatorService service;

    private CalculatorView view;

    public CalculatorPresenter(CalculatorService service) {
        this.service = service;
    }

    void setView(CalculatorView view) {
        this.view = view;
    }

    @EventListener
    private void init(ExampleViewInitEvent event) {

    }

}
