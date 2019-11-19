package de.pmrd.hackcalculator.calculator;

public interface CalculatorView {

  void setCalculateListener(CalculateListener listener);

  void setTransferToHistoryListener(TransferToHistoryListener listener);

  void setModel(CalculatorViewModel model);

  void setResult(String text);

  interface CalculateListener {

    void calculate();
  }

  interface TransferToHistoryListener {

    void transfer(CalculatorViewModel model);
  }
}
