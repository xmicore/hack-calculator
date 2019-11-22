package de.pmrd.hackcalculator.history;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class HistoryPresenter {

  private HistoryView view;

  void setView(HistoryView view) {
    this.view = view;
  }

  private List<HistoryViewModel> getHistoryData() {
    List<HistoryViewModel> historyItems = new ArrayList<>();
    HistoryViewModel historyViewModel = new HistoryViewModel();
    historyViewModel.setDateSavedToHistory(LocalDate.now());
    historyViewModel.setHackInGramsPerBroetchen(new BigDecimal(80));
    historyViewModel.setNumberOfBroetchen(new BigDecimal(10));
    historyViewModel.setHackInGramsTotal(new BigDecimal(800));
    historyItems.add(historyViewModel);

    HistoryViewModel historyViewModel2 = new HistoryViewModel();
    historyViewModel2.setDateSavedToHistory(LocalDate.of(2019, 10, 2));
    historyViewModel2.setHackInGramsPerBroetchen(new BigDecimal(70));
    historyViewModel2.setNumberOfBroetchen(new BigDecimal(9));
    historyViewModel2.setHackInGramsTotal(new BigDecimal(700));
    historyItems.add(historyViewModel2);

    return historyItems;
  }

  @EventListener
  public void init(HistoryViewInitEvent event) {
    view.setHistoryData(getHistoryData());
  }
}
