package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.*;
import de.pmrd.hackcalculator.presenter.ShoppingListPresenter;
import de.pmrd.hackcalculator.view.contracts.CalculatorView;
import de.pmrd.hackcalculator.view.contracts.ShoppingListView;
import de.pmrd.hackcalculator.view.events.ShoppingListViewBeforeInitEvent;
import de.pmrd.hackcalculator.view.events.ShoppingListViewInitEvent;
import de.pmrd.hackcalculator.view.layout.DefaultLayout;
import de.pmrd.hackcalculator.view.model.ShoppingListViewItem;
import de.pmrd.hackcalculator.view.model.ShoppingListViewModel;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;

@Route(value = ShoppingListView.VIEW_NAME, layout = DefaultLayout.class)
public class ShoppingListViewImpl extends Composite<VerticalLayout>
    implements ShoppingListView, HasUrlParameter<String>, HasDynamicTitle, AfterNavigationObserver {

  private final ApplicationEventPublisher eventPublisher;

  private Binder<ShoppingListViewModel> binder;

  private NumberField numberOfPersons;
  private NumberField hackPerBun;
  private NumberField bunsPerPerson;

  private FlexLayout summary;
  private Grid<ShoppingListViewItem> grid;

  public ShoppingListViewImpl(
      ShoppingListPresenter presenter, ApplicationEventPublisher eventPublisher) {
    presenter.setView(this);
    this.eventPublisher = eventPublisher;
    this.binder = new Binder<>(ShoppingListViewModel.class);
  }

  @Override
  public void setModel(ShoppingListViewModel model) {
    binder.readBean(model);
    grid.setDataProvider(DataProvider.ofCollection(model.getShoppingListItems()));
  }

  @Override
  public void afterNavigation(AfterNavigationEvent event) {
    eventPublisher.publishEvent(new ShoppingListViewInitEvent(this));
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String uuid) {
    eventPublisher.publishEvent(new ShoppingListViewBeforeInitEvent(this, uuid));
  }

  @Override
  public String getPageTitle() {
    return getTranslation("view.shoppingList.pageTitle");
  }

  @Override
  protected VerticalLayout initContent() {

    VerticalLayout content = new VerticalLayout();
    initSummary();
    initGrid();
    Button backBtn = new Button(VaadinIcon.ARROW_BACKWARD.create());
    backBtn.addClickListener(e -> UI.getCurrent().navigate(CalculatorView.VIEW_NAME));

    content.add(summary, grid, backBtn);

    return content;
  }

  private void initSummary() {
    summary = new FlexLayout();
    summary.setClassName("shoppinglist__summary");
    numberOfPersons = new NumberField(getTranslation("view.shoppingList.numberOfPersons"));
    numberOfPersons.setEnabled(false);
    binder
        .forField(numberOfPersons)
        .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
        .bind(ShoppingListViewModel::getNumberOfPersons, ShoppingListViewModel::setNumberOfPersons);
    summary.add(numberOfPersons);

    hackPerBun = new NumberField(getTranslation("view.shoppingList.hackPerBun"));
    hackPerBun.setEnabled(false);
    hackPerBun.setSuffixComponent(new Span(getTranslation("quantityUnit.gram")));
    binder
            .forField(hackPerBun)
            .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
            .bind(ShoppingListViewModel::getHackPerBun, ShoppingListViewModel::setHackPerBun);
    summary.add(hackPerBun);

    bunsPerPerson = new NumberField(getTranslation("view.shoppingList.bunsPerPerson"));
    bunsPerPerson.setEnabled(false);
    binder
            .forField(bunsPerPerson)
            .withConverter(BigDecimal::valueOf, BigDecimal::doubleValue)
            .bind(ShoppingListViewModel::getBunsPerPerson, ShoppingListViewModel::setBunsPerPerson);
    summary.add(bunsPerPerson);
  }

  private void initGrid() {
    grid = new Grid<>();
    grid.addColumn(ShoppingListViewItem::getIngredient)
        .setHeader(getTranslation("view.shoppingList.ingredient"));
    grid.addColumn(ShoppingListViewItem::getQuantity)
        .setHeader(getTranslation("view.shoppingList.quantity"));
    grid.addColumn(new TextRenderer<>(e -> getTranslation(e.getQuantityUnit().getKey())))
        .setHeader(getTranslation("view.shoppingList.quantityUnit"));

    grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    grid.setHeightByRows(true);
  }
}
