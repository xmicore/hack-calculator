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

  private List<HistoryViewItem> getHistoryData() {
    List<HistoryViewItem> historyItems = new ArrayList<>();

    HistoryViewItem historyViewItem2 = new HistoryViewItem();
    historyViewItem2.setDateSavedToHistory(LocalDate.of(2019, 10, 2));
    historyViewItem2.setHackInGramsPerBuns(new BigDecimal(70));
    historyViewItem2.setNumberOfBuns(new BigDecimal(9));
    historyViewItem2.setHackInGramsTotal(new BigDecimal(700));

    HistoryViewItem historyViewItem = new HistoryViewItem();
    historyViewItem.setDateSavedToHistory(LocalDate.now());
    historyViewItem.setHackInGramsPerBuns(new BigDecimal(80));
    historyViewItem.setNumberOfBuns(new BigDecimal(10));
    historyViewItem.setHackInGramsTotal(new BigDecimal(800));
    historyItems.add(historyViewItem2);
    historyItems.add(historyViewItem);

    return historyItems;
  }

  @EventListener
  public void init(HistoryViewInitEvent event) {
    view.setHistoryData(getHistoryData());
  }
}
