package de.pmrd.hackcalculator.view.contracts;

import de.pmrd.hackcalculator.view.model.CalculatorViewModel;
import java.math.BigDecimal;

public interface CalculatorView {

  String VIEW_NAME = "calculator";

  void setModel(CalculatorViewModel model);

  void setQuantity(BigDecimal quantity);

  void setCalculateListener(CalculateListener listener);

  void setSaveListener(SaveListener listener);

  interface CalculateListener {

    void calculate();
  }

  interface SaveListener {

    String save();
  }
}
