package de.pmrd.hackcalculator.cart;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.calculator.service.CalculatorService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class CartPresenter {

    private final CalculatorService service;

    private CartView view;

    public CartPresenter(CalculatorService service) {
        this.service = service;
    }

    void setView(CartView view) {
        this.view = view;
    }

    @EventListener
    public void init(CartViewEvent event) {

    }
}
