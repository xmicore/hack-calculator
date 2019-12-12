package de.pmrd.hackcalculator.view.contracts;

import de.pmrd.hackcalculator.view.model.HistoryViewItem;

public interface HistoryEditView {

  String VIEW_NAME = HistoryView.VIEW_NAME + "/edit";

  void setHistoryItem(HistoryViewItem item);

}
