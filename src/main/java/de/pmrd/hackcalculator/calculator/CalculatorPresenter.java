package de.pmrd.hackcalculator.calculator;

import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import de.pmrd.hackcalculator.calculator.CalculatorView.CalculateListener;
import de.pmrd.hackcalculator.service.HistoryService;
import de.pmrd.hackcalculator.service.CalculatorData;
import de.pmrd.hackcalculator.service.CalculatorService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@VaadinSessionScope
public class CalculatorPresenter implements CalculateListener {

  private final CalculatorService calculatorService;

  private final HistoryService historyService;

  private CalculatorView view;

  private CalculatorViewModel model;

  public CalculatorPresenter(CalculatorService calculatorService, HistoryService historyService) {
    this.calculatorService = calculatorService;
    this.historyService = historyService;
  }

  void setView(CalculatorView view) {
    this.view = view;
  }

  @Override
  public void calculate() {
    CalculatorData data = new CalculatorData.Builder()
            .setBunsPerPerson(model.getBunsPerPerson())
            .setHackPerBun(model.getHackPerBun())
            .setNumberOfPersons(model.getNumberOfPersons())
            .build();
    final double hack =   calculatorService.calculateHack(data);
    this.view.setQuantity(hack);
  }

  @EventListener
  public void init(CalculatorViewInitEvent event) {
    this.view.setCalculateListener(this);
    this.model = event.getModel();
    this.view.setModel(this.model);
    this.view.setQuantity(0d);
  }

}
