package de.pmrd.hackcalculator.cart;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collection;

@Route(value = CartViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("Einkaufswagen")
public class CartViewImpl extends Composite<VerticalLayout> implements CartView, AfterNavigationObserver {

    public static final String VIEW_NAME = "cart";

    private final ApplicationEventPublisher eventPublisher;

    private Grid<CartViewItem> grid;

    public CartViewImpl(CartPresenter presenter, ApplicationEventPublisher eventPublisher) {
        presenter.setView(this);
        this.eventPublisher = eventPublisher;
        init();
        bind();
    }

    private void init() {
        this.grid = new Grid<>();
        this.grid
                .addColumn(CartViewItem::getIngredient)
                .setHeader("Zutat");
        this.grid
                .addColumn(CartViewItem::getQuantity)
                .setHeader("Menge");
        this.grid
                .addColumn(CartViewItem::getQuantityUnit)
                .setHeader("Einheit");

        this.grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        getContent().add(this.grid);
    }

    private void bind() {

    }

    @Override
    public void setItems(Collection<CartViewItem> items) {
        this.grid.setDataProvider(DataProvider.ofCollection(items));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        eventPublisher.publishEvent(new CartViewEvent(this));
    }

}
