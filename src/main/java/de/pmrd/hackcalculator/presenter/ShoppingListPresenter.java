package de.pmrd.hackcalculator.presenter;

import de.pmrd.hackcalculator.service.CalculatorService;
import de.pmrd.hackcalculator.service.HistoryService;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import de.pmrd.hackcalculator.view.contracts.ShoppingListView;
import de.pmrd.hackcalculator.view.events.ShoppingListViewBeforeInitEvent;
import de.pmrd.hackcalculator.view.events.ShoppingListViewInitEvent;
import de.pmrd.hackcalculator.view.model.QuantityUnit;
import de.pmrd.hackcalculator.view.model.ShoppingListViewItem;
import de.pmrd.hackcalculator.view.model.ShoppingListViewItemBuilder;
import de.pmrd.hackcalculator.view.model.ShoppingListViewModel;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequestScope
public class ShoppingListPresenter {

    private final CalculatorService calculatorService;

    private final HistoryService historyService;

    private ShoppingListView view;

    private ShoppingListViewModel model;

    public ShoppingListPresenter(CalculatorService calculatorService, HistoryService historyService) {
        this.calculatorService = calculatorService;
        this.historyService = historyService;
        this.model = new ShoppingListViewModel();
    }

    public void setView(ShoppingListView view) {
        this.view = view;
    }

    @EventListener
    public void beforeInit(ShoppingListViewBeforeInitEvent event) {
        model = createShoppingListItems(event.getUuid());
    }

    @EventListener
    public void init(ShoppingListViewInitEvent event) {
        view.setModel(model);
    }

    private ShoppingListViewModel createShoppingListItems(String uuid) {
        ShoppingListViewModel shoppingList = new ShoppingListViewModel();
        List<ShoppingListViewItem> items = new ArrayList<>();
        Optional<HistoryBackendItem> historyItemOpt = historyService.getHistoryItem(uuid);
        if (historyItemOpt.isPresent()) {
            HistoryBackendItem historyItem = historyItemOpt.get();
            BigDecimal numberOfPersons = historyItem.getNumberOfPersons();
            BigDecimal bunsPerPerson = historyItem.getNumberOfBuns();
            BigDecimal hackPerBun = historyItem.getHackPerBun();
            items.add(
                    new ShoppingListViewItemBuilder()
                            .setIngredient("Brötchen")
                            .setQuantity(calculatorService.calculateBuns(numberOfPersons, bunsPerPerson))
                            .setQuantityUnit(QuantityUnit.CHUNK)
                            .createItem());
            items.add(
                    new ShoppingListViewItemBuilder()
                            .setIngredient("Hack")
                            .setQuantity(
                                    calculatorService.calculateHackTotal(numberOfPersons, bunsPerPerson, hackPerBun))
                            .setQuantityUnit(QuantityUnit.GRAM)
                            .createItem());
            shoppingList.setBunsPerPerson(bunsPerPerson);
            shoppingList.setHackPerBun(hackPerBun);
            shoppingList.setNumberOfPersons(numberOfPersons);
        }
        shoppingList.setShoppingListItems(items);
        return shoppingList;
    }
}
