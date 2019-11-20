package de.pmrd.hackcalculator.cart;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = CartViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("Einkaufswagen")
public class CartViewImpl extends Composite<VerticalLayout> implements CartView, AfterNavigationObserver {

    public static final String VIEW_NAME = "cart";

    private final ApplicationEventPublisher eventPublisher;

    public CartViewImpl(CartPresenter presenter, ApplicationEventPublisher eventPublisher) {
        presenter.setView(this);
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        eventPublisher.publishEvent(new CartViewEvent(this));
    }

}
