package de.pmrd.hackcalculator.presenter;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.service.CalculatorService;
import de.pmrd.hackcalculator.service.HistoryService;
import de.pmrd.hackcalculator.service.model.HistoryBackendItem;
import de.pmrd.hackcalculator.view.contracts.CalculatorView;
import de.pmrd.hackcalculator.view.contracts.CalculatorView.CalculateListener;
import de.pmrd.hackcalculator.view.contracts.CalculatorView.SaveListener;
import de.pmrd.hackcalculator.view.events.CalculatorViewInitEvent;
import de.pmrd.hackcalculator.view.model.CalculatorViewModel;
import java.math.BigDecimal;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@VaadinSessionScope
public class CalculatorPresenter implements CalculateListener, SaveListener {

  private final CalculatorService calculatorService;
  private final HistoryService historyService;

  private CalculatorView view;

  private CalculatorViewModel model;

  public CalculatorPresenter(CalculatorService calculatorService, HistoryService historyService) {
    this.calculatorService = calculatorService;
    this.historyService = historyService;
    this.model = new CalculatorViewModel();
  }

  @Override
  public void calculate() {
    view.setQuantity(
        calculatorService.calculateHackTotal(
            model.getNumberOfPersons(), model.getNumberOfBuns(), model.getHackPerBun()));
  }

  @Override
  public String save() {
    HistoryBackendItem historyBackendItem = new HistoryBackendItem();
    historyBackendItem.setHackPerBun(model.getHackPerBun());
    historyBackendItem.setNumberOfBuns(model.getNumberOfBuns());
    historyBackendItem.setNumberOfPersons(model.getNumberOfPersons());
    historyService.createHistoryItem(historyBackendItem);
    return historyBackendItem.getId().toString();
  }

  @EventListener
  public void init(CalculatorViewInitEvent event) {
    view.setCalculateListener(this);
    view.setSaveListener(this);
    view.setModel(this.model);
    view.setQuantity(BigDecimal.ZERO);
  }

  public void setView(CalculatorView view) {
    this.view = view;
  }
}
