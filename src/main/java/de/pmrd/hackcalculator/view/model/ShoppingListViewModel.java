package de.pmrd.hackcalculator.view.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewModel {

    private List<ShoppingListViewItem> shoppingListItems;
    private BigDecimal numberOfPersons;

    private BigDecimal hackPerBun;

    private BigDecimal bunsPerPerson;

    public ShoppingListViewModel() {
        numberOfPersons = BigDecimal.ZERO;
        hackPerBun = BigDecimal.ZERO;
        bunsPerPerson = BigDecimal.ZERO;
        shoppingListItems = new ArrayList<>();
    }

    public BigDecimal getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(BigDecimal numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public BigDecimal getHackPerBun() {
        return hackPerBun;
    }

    public void setHackPerBun(BigDecimal hackPerBun) {
        this.hackPerBun = hackPerBun;
    }

    public BigDecimal getBunsPerPerson() {
        return bunsPerPerson;
    }

    public void setBunsPerPerson(BigDecimal bunsPerPerson) {
        this.bunsPerPerson = bunsPerPerson;
    }

    public List<ShoppingListViewItem> getShoppingListItems() {
        return shoppingListItems;
    }

    public void setShoppingListItems(List<ShoppingListViewItem> shoppingListItems) {
        this.shoppingListItems = shoppingListItems;
    }
}
