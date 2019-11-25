package de.pmrd.hackcalculator.cart;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.service.CalculatorService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        this.view.setItems(getCartData());
    }

    private List<CartViewItem> getCartData() {
        List<CartViewItem> items = new ArrayList<>();

        CartViewItem item1 = new CartViewItemBuilder().createCartViewItem();
        item1.setIngredient("Brötchen");
        item1.setQuantity(new BigDecimal(10));
        item1.setQuantityUnit(QuantityUnit.CHUNK);
        items.add(item1);

        CartViewItem item2 = new CartViewItemBuilder().createCartViewItem();
        item2.setIngredient("Hack");
        item2.setQuantity(new BigDecimal(1000));
        item2.setQuantityUnit(QuantityUnit.GRAM);
        items.add(item2);

        CartViewItem item3 = new CartViewItemBuilder().createCartViewItem();
        item3.setIngredient("Zwiebel");
        item3.setQuantity(new BigDecimal(1));
        item3.setQuantityUnit(QuantityUnit.CHUNK);
        items.add(item3);

        return items;
    }
}
