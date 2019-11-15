package de.pmrd.hackcalculator.view;

import de.pmrd.hackcalculator.view.model.CalculatorViewModel;

public interface CalculatorView {

  interface CalculateListener {

    void calculate();

  }

  void setCalculateListener(CalculateListener listener);

  interface TransferToHistoryListener {

    void transfer(CalculatorViewModel model);

  }

  void setTransferToHistoryListener(TransferToHistoryListener listener);

  void setModel(CalculatorViewModel model);

  void setResult(String text);

}
