package de.pmrd.hackcalculator.calculator;

public interface CalculatorView {

  void setCalculateListener(CalculateListener listener);

  void setModel(CalculatorViewModel model);

  void setQuantity(double quantity);

  interface CalculateListener {

    void calculate();
  }

}
