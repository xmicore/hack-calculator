package de.pmrd.hackcalculator.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.presenter.HistoryPresenter;
import de.pmrd.hackcalculator.view.contracts.HistoryView;
import de.pmrd.hackcalculator.view.events.HistoryViewInitEvent;
import de.pmrd.hackcalculator.view.layout.DefaultLayout;
import de.pmrd.hackcalculator.view.model.HistoryViewItem;
import java.util.Collection;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = HistoryView.VIEW_NAME, layout = DefaultLayout.class)
public class HistoryViewImpl extends Composite<VerticalLayout>
    implements HistoryView, AfterNavigationObserver, HasDynamicTitle {

  private final ApplicationEventPublisher eventPublisher;
  private Grid.Column<HistoryViewItem> hackPerBunCol;
  private Grid.Column<HistoryViewItem> bunsCol;
  private Grid.Column<HistoryViewItem> personCol;
  private Grid.Column<HistoryViewItem> hackTotalCol;
  private Grid.Column<HistoryViewItem> savedToHistoryCol;
  private Grid.Column<HistoryViewItem> modifiedCol;
  private Grid.Column<HistoryViewItem> editCol;
  private Grid<HistoryViewItem> historyGrid;

  public HistoryViewImpl(HistoryPresenter presenter, ApplicationEventPublisher eventPublisher) {
    presenter.setView(this);
    this.eventPublisher = eventPublisher;
  }

  @Override
  public void setHistoryData(Collection<HistoryViewItem> data) {
    historyGrid.setDataProvider(DataProvider.ofCollection(data));
  }

  @Override
  public String getPageTitle() {
    return getTranslation("view.history.pageTitle");
  }

  @Override
  public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
    eventPublisher.publishEvent(new HistoryViewInitEvent(this));
  }

  @Override
  protected VerticalLayout initContent() {
    VerticalLayout content = new VerticalLayout();
    content.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    initGrid();
    adjustGridToDevice();
    content.add(historyGrid);
    return content;
  }

  private void initGrid() {
    historyGrid = new Grid<>();
    hackPerBunCol =
        historyGrid
            .addColumn(HistoryViewItem::getHackPerBun, "buns")
            .setHeader(getTranslation("view.history.hackPerBun"))
            .setSortable(true);
    bunsCol =
        historyGrid
            .addColumn(HistoryViewItem::getNumberOfBuns)
            .setHeader(getTranslation("view.history.numberOfBuns"))
            .setSortable(true);
    personCol =
        historyGrid
            .addColumn(HistoryViewItem::getNumberOfPersons)
            .setHeader(getTranslation("view.history.numberOfPersons"))
            .setSortable(true);
    hackTotalCol =
        historyGrid
            .addColumn(HistoryViewItem::getHackTotal)
            .setHeader(getTranslation("view.history.hackTotal"))
            .setSortable(true);
    savedToHistoryCol =
        historyGrid
            .addColumn(HistoryViewItem::getSavedToHistory)
            .setHeader(getTranslation("view.history.dateSaved"))
            .setSortable(true);
    modifiedCol =
        historyGrid
            .addColumn(HistoryViewItem::getModified)
            .setHeader(getTranslation("view.history.dateModified"));
    editCol = historyGrid.addColumn(new ComponentRenderer<>(this::getEditButton));

    historyGrid.setMultiSort(true);
    historyGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    historyGrid.setHeightByRows(true);
    historyGrid.setColumnReorderingAllowed(true);
    historyGrid.getColumns().forEach(column -> column.setAutoWidth(true));
    historyGrid.sort(List.of(new GridSortOrder<>(savedToHistoryCol, SortDirection.DESCENDING)));
  }

  private void adjustGridToDevice() {
    UI.getCurrent()
        .getPage()
        .retrieveExtendedClientDetails(
            details -> {
              if (details.getScreenWidth() < 720) {
                makeGridResponsive();
              }
            });
  }

  private Button getEditButton(HistoryViewItem item) {
    Button editBtn = new Button(VaadinIcon.EDIT.create());
    editBtn.addClickListener(
        e ->
            getUI()
                .ifPresent(ui -> ui.navigate(HistoryEditViewImpl.class, item.getId().toString())));
    return editBtn;
  }

  private void makeGridResponsive() {
    hackPerBunCol.setVisible(false);
    bunsCol.setVisible(false);
    personCol.setVisible(false);
    modifiedCol.setVisible(false);
    modifiedCol.setVisible(false);
    hackTotalCol.setHeader(VaadinIcon.PIGGY_BANK.create());
    savedToHistoryCol.setHeader(VaadinIcon.CLOCK.create());
    editCol.setHeader(VaadinIcon.EDIT.create());
  }
}
