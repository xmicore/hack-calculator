package de.pmrd.hackcalculator.history;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.pmrd.hackcalculator.layout.DefaultLayout;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;

@Route(value = HistoryViewImpl.VIEW_NAME, layout = DefaultLayout.class)
@PageTitle("History")
public class HistoryViewImpl extends Composite<VerticalLayout>
    implements HistoryView, AfterNavigationObserver {

  static final String VIEW_NAME = "history";

  private final ApplicationEventPublisher eventPublisher;
  private Grid<HistoryViewModel> historyGrid;

  public HistoryViewImpl(HistoryPresenter presenter, ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
    init();
    presenter.setView(this);
  }

  private void init() {
    getContent().setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    initGrid();
    getContent().add(historyGrid);
  }

  private void initGrid() {
    historyGrid = new Grid<>();
    historyGrid
        .addColumn(HistoryViewModel::getHackInGramsPerBroetchen, "buns")
        .setHeader("Hack pro Brötchen")
        .setSortable(true);
    historyGrid
        .addColumn(HistoryViewModel::getNumberOfBroetchen)
        .setHeader("Brötchen")
        .setSortable(true);
    historyGrid
        .addColumn(HistoryViewModel::getHackInGramsTotal)
        .setHeader("Hack gesamt")
        .setSortable(true);
    Grid.Column<HistoryViewModel> dateColumn =
        historyGrid
            .addColumn(HistoryViewModel::getDateSavedToHistory)
            .setHeader("Datum")
            .setSortable(true);
    historyGrid.setMultiSort(true);
    historyGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    historyGrid.setColumnReorderingAllowed(true);
    historyGrid.sort(List.of(new GridSortOrder<>(dateColumn, SortDirection.DESCENDING)));
  }

  @Override
  public void setHistoryData(List<HistoryViewModel> data) {
    historyGrid.setDataProvider(DataProvider.ofCollection(data));
  }

  @Override
  public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
    eventPublisher.publishEvent(new HistoryViewInitEvent(this));
  }
}
