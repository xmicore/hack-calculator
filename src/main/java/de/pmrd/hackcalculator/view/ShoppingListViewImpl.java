package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.presenter.ShoppingListPresenter;
import de.pmrd.hackcalculator.view.contracts.CalculatorView;
import de.pmrd.hackcalculator.view.contracts.ShoppingListView;
import de.pmrd.hackcalculator.view.events.ShoppingListViewBeforeInitEvent;
import de.pmrd.hackcalculator.view.events.ShoppingListViewInitEvent;
import de.pmrd.hackcalculator.view.layout.DefaultLayout;
import de.pmrd.hackcalculator.view.model.ShoppingListViewItem;
import java.util.Collection;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = ShoppingListView.VIEW_NAME, layout = DefaultLayout.class)
public class ShoppingListViewImpl extends Composite<VerticalLayout>
    implements ShoppingListView, HasUrlParameter<String>, HasDynamicTitle, AfterNavigationObserver {

  private final ApplicationEventPublisher eventPublisher;

  private Grid<ShoppingListViewItem> grid;

  public ShoppingListViewImpl(
      ShoppingListPresenter presenter, ApplicationEventPublisher eventPublisher) {
    presenter.setView(this);
    this.eventPublisher = eventPublisher;
  }

  @Override
  public void setItems(Collection<ShoppingListViewItem> items) {
    grid.setDataProvider(DataProvider.ofCollection(items));
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
    initGrid();
    Button backBtn = new Button(VaadinIcon.ARROW_BACKWARD.create());
    backBtn.addClickListener(e -> UI.getCurrent().navigate(CalculatorView.VIEW_NAME));

    content.add(backBtn, grid);

    return content;
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
