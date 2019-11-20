package de.pmrd.hackcalculator.cart;

import org.springframework.context.ApplicationEvent;

public class CartViewEvent extends ApplicationEvent {

    public CartViewEvent(Object source) {
        super(source);
    }
}
